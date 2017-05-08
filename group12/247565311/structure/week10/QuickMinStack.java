package structure.week10;

import structure.week1.Stack;

/**
 * ���һ��ջ��֧��ջ��push��pop�������Լ������ֲ���findMin, �����ظ����ݽṹ�е���СԪ��
 * finMin�������������ʱ�临�Ӷ�Ӧ����O(1) �� ������������һ�ξͿ��Եõ���Сֵ
 */
public class QuickMinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	public QuickMinStack(){
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	public void push(int data){
		stack.push(data);
		if(data<=minStack.peek().intValue()) minStack.push(data);
	}
	public int pop(){
		int val = stack.pop();
		if(val == minStack.peek().intValue()) minStack.pop();
		return val;
	}
	public int findMin(){
		return minStack.peek();
	}
}
