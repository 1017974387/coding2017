public class ArrayList implements List {
	
	private int size;
    
    private int capacity;
    
    private static final int DEFAULT_CAPACITY = 10;
	
	private Object[] elementData;
    
    //add()ʱ��������
    private void expand() {
        if (size < capacity) return;//��δ��Ա����������
        
        if (capacity < DEFAULT_CAPACITY) capacity = DEFAULT_CAPACITY;//��������С����
        
        Object[] oldElem = elementData;
        elementData = new Object[capacity <<= 1];
        for (int i = 0; i < size; i++)
            elementData[i] = oldElem[i];
    }
    
    //remove()ʱ��������
    private void shrink() {
        if (capacity < DEFAULT_CAPACITY << 1) return;//����������DEFAULT_CAPACITY����
        
        if (capacity >> 2 < size) return; //��25%Ϊ��
        
        Object[] oldElem = elementData; elementData = new Object[capacity >>= 1];
        for (int i = 0; i < size; i++)
            elementData[i] = oldElem[i];
            
    }
    
    public ArrayList() {
        clear();
    }
    
    public ArrayList(Object ...args) {
        this();
        for (Object o : args)
            add(o);
    }
    
    public void clear() {
        size = 0;
        elementData = new Object[capacity = DEFAULT_CAPACITY];
    }
	
    public int size() { return size; }
    
    public int capacity() { return capacity; }//���ڲ���shrink()&expand()
    
    public boolean isEmpty() { return size == 0; }
    
	public void add(Object o){
		add(size(), o);
	}
	public void add(int index, Object o){
        if (index < 0 || size < index) throw new IndexOutOfBoundsException();
		expand();
        
        for (int i = size; i > index; i--)
            elementData[i] = elementData[i - 1];
        elementData[index] = o;
        
        size++;
	}
    public void add(Object ...args) {
        for (Object o : args) 
            add(o);
    }
	
	public Object get(int index){
        if (index < 0 || size <= index) throw new IndexOutOfBoundsException();
		return elementData[index];
	}
	
	public Object remove(int index){
        if (index < 0 || size <= index) throw new IndexOutOfBoundsException();
        
        Object removed = elementData[index];
        
        for (int i = index; i < size - 1; i++)
            elementData[i] = elementData[i + 1];
        size--;
        shrink();
		return removed;
	}
    
    public void removeElems(int ...args) {
        for (int i : args)
            remove(i);
    }
	
	public Iterator iterator(){
		return new ArrayListIterator();
	}
	
    private class ArrayListIterator implements Iterator {
        private int current;
        public boolean hasNext() { return current != size; }
        public Object next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            
            return elementData[current++];
        }
    }
    public static void showElements(ArrayList list) {
        System.out.print("��ǰlist��Ԫ�أ�");
        Iterator iter = list.iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();
    }
    
    public static void test(ArrayList list) {
        System.out.println("--------������������---------");
        System.out.println("��ǰlist.isEmpty(): " + list.isEmpty());
        System.out.println("��ǰlist.size(): " + list.size());
        System.out.println("��ǰlist.capacity(): " + list.capacity());
        showElements(list);
        
    }
    
    public static void main(String[] args) {
        ArrayList list = new ArrayList(1, 2, 3, 4, 5);
        test(list);
        list.add(6, 7, 8, 9, 10);
        test(list);
        list.add(3, 11);
        list.get(3);
        test(list);
        list.remove(3);
        test(list);
        list.add(11,12,13,14,15,16,17,18,19,20,21,22,23,24);
        test(list);
        
        list.removeElems(1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        test(list);
        
        
    }
}
