package structure.week10;

/**
 * ��һ������ʵ������ջ
 * ���������ʼλ�ÿ����ǵ�һ��ջ��ջ�ף��������β�������ڶ���ջ��ջ�ף�ѹջʱ��ջ��ָ��ֱ����м��ƶ���ֱ����ջ��ָ�������������ݡ�
 * @author liuxin
 *
 */
public class TwoStackInOneArray {
	Object[] data = new Object[10];
	int index1 = -1,index2 = data.length;
	/**
	 * ���һ��ջ��ѹ��Ԫ��
	 * @param o
	 */
	public void push1(Object o){
		if(index2-index1<=1)doubleSpace();
		index1 += 1;
		data[index1] = o;
	}
	/**
	 * �ӵ�һ��ջ�е���Ԫ��
	 * @return
	 */
	public Object pop1(){
		if(index1<0)return null;
		Object res = data[index1];
		index1 -= 1;
		return res;
	}
	
	/**
	 * ��ȡ��һ��ջ��ջ��Ԫ��
	 * @return
	 */
	
	public Object peek1(){
		if(index1<0) return null;
		return data[index1];
	}
	/*
	 * ��ڶ���ջѹ��Ԫ��
	 */
	public void push2(Object o){
		if(index2-index1<=1)doubleSpace();
		index2 -=1;
		data[index2] = o;
	}
	/**
	 * �ӵڶ���ջ����Ԫ��
	 * @return
	 */
	public Object pop2(){
		if(index2==data.length) return null;
		Object res = data[index2];
		index2 += 1;
		return res;
	}
	/**
	 * ��ȡ�ڶ���ջ��ջ��Ԫ��
	 * @return
	 */
	public Object peek2(){
		if(index2==data.length) return null;
		return data[index2];
	}
	private void doubleSpace(){
		Object []newData = new Object[data.length*2];
		for(int i=0;i<=index1;i++){
			newData[i] = data[i];
		}
		for(int i=data.length-1;i>=index2;i--){
			newData[data.length+i] = data[i];
		}
		index2 += data.length;
		data=newData;
	}
}
