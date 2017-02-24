package com.coding.basic;

/**
 * LinkedList ʵ�� ��14С�� 296933284
 * 
 * @author Tonnyson
 *
 */
public class LinkedList implements List {

	private Node head;
	private int size;
	
	public LinkedList() {
		super();
		this.head = new Node();
		this.size = 0;
	}

	/**
	 * β�巨������ĩβ����ڵ�
	 */
	public void add(Object obj) {

		if (head.data == null) {
			head.data = obj;
			head.next = null;
		} else {

			Node r = head;
			while (r.next != null)
				r = r.next;

			Node node = new Node();
			node.data = obj;
			node.next = null;

			r.next = node;
		}

		size++;

	}

	/**
	 * ��ָ������λ�ò���ڵ�
	 */
	public void add(int index, Object obj) {

		if (index > size)
			throw new IndexOutOfBoundsException();

		Node r = head;
		for (int i = 0; i < index - 1; i++)
			r = r.next;

		Node node = new Node();
		node.data = obj;
		node.next = null;
		node.next = r.next;
		r.next = node;
		size++;
	}

	/**
	 * ����ָ��λ�õ�ֵ
	 */
	public Object get(int index) {
		if (index > size)
			throw new IndexOutOfBoundsException();

		Node r = head;
		for (int i = 0; i < index; i++)
			r = r.next;

		return r.data;
	}

	/**
	 * ɾ��ָ��λ�ýڵ㲢������ֵ
	 */
	public Object remove(int index) {
		if (index > size)
			throw new IndexOutOfBoundsException();

		Node node = new Node();

		Node r = head;
		for (int i = 0; i < index - 1; i++)
			r = r.next;

		node = r.next;
		r.next = node.next;
		node.next = null;
		size--;
		return node.data;
	}

	/**
	 * ��������ĳ���
	 */
	public int size() {
		return size;
	}

	/**
	 * ���������ʼλ�ò���ڵ�
	 * 
	 * @param obj
	 */
	public void addFirst(Object obj) {
		Node node = new Node();
		node.data = obj;
		node.next = head;
		head = node;
		size++;
	}

	/**
	 * ������β������ڵ�
	 * 
	 * @param obj
	 */
	public void addLast(Object obj) {
		add(obj);
	}

	/**
	 * ɾ������ĵ�һ���ڵ�
	 * 
	 * @return ��ɾ���ڵ��ֵ
	 */
	public Object removeFirst() {
		Node node = new Node();
		node = head;
		head = head.next;
		size--;

		return node.data;
	}

	/**
	 * ɾ����������һ���ڵ�
	 * 
	 * @return ��ɾ���ڵ��ֵ
	 */
	public Object removeLast() {
		return remove(size - 1);
	}
	
	/**
	 * ������
	 * 
	 * @return ����һ������������
	 */
	public Iterator iterator() {
		return new Iter();
	}

	// �������ڲ���
	private class Iter implements Iterator {
		int current;

		@Override
		public boolean hasNext() {
			return current != size;
		}

		@Override
		public Object next() {
			int i = current;
			
			if (i >= size)
				throw new IndexOutOfBoundsException();
			
			current++;

			return get(i);
		}

	}

	// �ڵ��ඨ��
	private static class Node {
		Object data;
		Node next;
	}
}
