package com.coding.basic;

/**
 * �Զ���LinkList
 * 
 * @author xiongrui233
 *
 */
public class LinkedList implements List {
	
	/**
	 * ��������ڵ�ṹ
	 * @author xiongrui233
	 *
	 */
	private static class Node {
		Object data;
		Node next;
	}
	//����ڵ�
	private Node head = new Node();

	/**
	 * ���Ԫ��
	 * 
	 * @param o
	 */
	public void add(Object o) {
		Node node = head;
		while (node.data != null) {
			node = node.next;
		}
		node.data = o;
	}

	/**
	 * ���Ԫ��
	 * 
	 * @param index
	 * @param o
	 */
	public void add(int index, Object o) {
		Node node = head;
		Node oldNode = head;
		Node newNode = new Node();
		for (int i = 0; i <= index; i++) {
			if (i == index - 1) {
				oldNode = node.next;
			}
			node = node.next;
		}
		newNode.data = o;
		newNode.next = node;
		oldNode.next = newNode;
	}

	/**
	 * ��ȡԪ��
	 * 
	 * @param index
	 */
	public Object get(int index) {
		Node node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		return node.data;
	}

	/**
	 * ɾ��Ԫ��
	 * 
	 * @param index
	 */
	public Object remove(int index) {
		Node node = head;
		Node oldNode = head;
		Node newNode = new Node();
		for (int i = 0; i <= index; i++) {
			if (i == index - 1) {
				oldNode = node.next;
			}
			node = node.next;
		}
		if (node.next != null) {
			newNode = node.next;
		} else {
			newNode = node;
		}
		oldNode.next = newNode;
		return node.data;
	}

	public int size() {
		int size = 0;
		while (head.next != null) {
			size ++;
		}
		return size;
	}

	public void addFirst(Object o) {

	}

	public void addLast(Object o) {

	}

	public Object removeFirst() {
		return null;
	}

	public Object removeLast() {
		return null;
	}

	public Iterator iterator() {
		return null;
	}

	/**
	 * �Ѹ��������� ��������Ϊ 3->7->10 , ���ú��Ϊ 10->7->3
	 */
	public void reverse() {

	}

	/**
	 * ɾ��һ���������ǰ�벿�� ���磺list = 2->5->7->8 , ɾ���Ժ��ֵΪ 7->8 ���list = 2->5->7->8->10
	 * ,ɾ���Ժ��ֵΪ7,8,10
	 */
	public void removeFirstHalf() {

	}

	/**
	 * �ӵ�i��Ԫ�ؿ�ʼ�� ɾ��length ��Ԫ�� �� ע��i��0��ʼ
	 * 
	 * @param i
	 * @param length
	 */
	public void remove(int i, int length) {

	}

	/**
	 * �ٶ���ǰ�����list���������������е����� �ӵ�ǰ������ȡ����Щlist��ָ����Ԫ�� ���統ǰ���� =
	 * 11->101->201->301->401->501->601->701 listB = 1->3->4->6
	 * ���صĽ��Ӧ����[101,301,401,601]
	 * 
	 * @param list
	 */
	public static int[] getElements(LinkedList list) {
		return null;
	}

	/**
	 * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� �ӵ�ǰ��������ɾ����list�г��ֵ�Ԫ��
	 * 
	 * @param list
	 */

	public void subtract(LinkedList list) {

	}

	/**
	 * ��֪��ǰ�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� ɾ����������ֵ��ͬ�Ķ���Ԫ�أ�ʹ�ò���������Ա�������Ԫ�ص�ֵ������ͬ��
	 */
	public void removeDuplicateValues() {

	}

	/**
	 * ��֪�����е�Ԫ����ֵ�����������У����Ե��������洢�ṹ�� ��дһ��Ч���㷨��ɾ����������ֵ����min��С��max��Ԫ�أ������д���������Ԫ�أ�
	 * 
	 * @param min
	 * @param max
	 */
	public void removeRange(int min, int max) {

	}

	/**
	 * ���赱ǰ����Ͳ���listָ�����������Ԫ����ֵ�����������У�ͬһ���е�Ԫ��ֵ������ͬ��
	 * ��Ҫ������������C����Ԫ��Ϊ��ǰ�����list��Ԫ�صĽ������ұ�C�е�Ԫ������ֵ������������
	 * 
	 * @param list
	 */
	public LinkedList intersection(LinkedList list) {
		return null;
	}
}