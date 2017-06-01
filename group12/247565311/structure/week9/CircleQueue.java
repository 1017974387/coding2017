package structure.week9;

/**
 * ������ʵ��ѭ������
 * @author liuxin
 * @param <E>
 */
public class CircleQueue <E> {
	private final static int DEFAULT_SIZE = 10;
	//������������ѭ�����е�Ԫ��
	private Object[] elementData = new Object[DEFAULT_SIZE] ;
	boolean isFull = false;
	
	private int front = 0;  //��ͷ
	private int rear = 0;    //��β 
	public boolean isEmpty() {
		if(isFull) return false;
		return (rear-front+DEFAULT_SIZE)%DEFAULT_SIZE==0;
    }
    public int size() {
    	if(isFull) return DEFAULT_SIZE;
    	else{
        	if(rear<front)return rear-front+DEFAULT_SIZE;
    		else return rear-front;
    	}
    }
    public void enQueue(E data) {
    	if(isFull){
    		elementData[rear] = data;
    		rear += 1;
    		rear %= DEFAULT_SIZE;
    		front = rear;
    	}else{
    		elementData[rear] = data;
    		rear += 1;
    		rear %= DEFAULT_SIZE;
    		if(rear == front) isFull = true;
    	}
    }
    public E deQueue() {
    	E res = (E) elementData[front];
    	front += 1;
    	front %=DEFAULT_SIZE;
    	isFull = false;
    	return res;
    }
}