package com.basic.linklist;

/**
 * ��˫������ʵ��LRU�㷨
 * 
 * @author liuxin
 *
 */
public class LRUPageFrame {

	private static class Node {

		Node prev;
		Node next;
		int pageNum;

		Node() {
		}
	}

	private int capacity;

	private Node first;// ����ͷ
	private Node last;// ����β

	public LRUPageFrame(int capacity) {

		this.capacity = capacity;

	}

	/**
	 * ��ȡ�����ж���
	 * 
	 * @param key
	 * @return
	 */
	public void access(int pageNum) {

	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		Node node = first;
		while (node != null) {
			buffer.append(node.pageNum);

			node = node.next;
			if (node != null) {
				buffer.append(",");
			}
		}
		return buffer.toString();
	}

}