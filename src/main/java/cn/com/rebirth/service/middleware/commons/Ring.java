/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-service-middleware-server Ring.java 2012-7-17 11:29:58 l.xue.nong$$
 */
package cn.com.rebirth.service.middleware.commons;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Class Ring.
 *
 * @param <T> the generic type
 * @author l.xue.nong
 */
public class Ring<T> {

	/**
	 * The Class Node.
	 *
	 * @author l.xue.nong
	 */
	private class Node {

		/** The front. */
		Node front; //前节点

		/** The next. */
		Node next; //后节点

		/** The data. */
		T data; //节点携带的数据
	}

	/** The current. */
	private Node current; //当前节点

	/**
	 * Instantiates a new ring.
	 */
	public Ring() {

	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return null == current;
	}

	/**
	 * Ring.
	 *
	 * @return the t
	 */
	public T ring() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		current = current.next;
		return current.data;
	}

	/**
	 * Insert.
	 *
	 * @param t the t
	 */
	public void insert(T t) {
		Node node = new Node();
		node.data = t;

		// 第一个插入的节点要初始化环行头节点
		if (null == current) {
			current = node;
			current.front = current.next = current;
		}

		// 随后插入的就按规矩来
		else {
			node.front = current;
			node.next = current.next;
			current.next.front = node;
			current.next = node;
		}

	}

	/**
	 * Clean.
	 */
	public void clean() {
		current = null;
	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	public Iterator<T> iterator() {
		final Node _current = current;
		return new Iterator<T>() {

			private Node first = null;
			private Node itP = _current;

			@Override
			public boolean hasNext() {
				return first != itP;
			}

			@Override
			public T next() {
				if (null == first) {
					first = itP;
				}
				itP = itP.next;
				return itP.data;
			}

			@Override
			public void remove() {
				// 要干掉最后一个元素，变成空环
				if (itP.next == itP) {
					first = itP = null;
					clean();
				}

				// 非最后一个元素，就按照规矩来
				else {
					itP.next.front = itP.front;
					itP.front.next = itP.next;
				}
			}

		};
	}
}
