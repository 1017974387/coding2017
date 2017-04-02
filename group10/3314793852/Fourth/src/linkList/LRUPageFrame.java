	
	package linkList;
	
	/**
	 * ��˫������ʵ��LRU�㷨
	 * @author liuxin
	 * ��������ͷ����β�ڵ㡣
	 */
	public class LRUPageFrame {
		
		private static class Node {
			
			Node prev;
			Node next;
			int pageNum;
	
//			Node() {
//			}
			
			Node(Node prev,Node next,int pageNum){
				this.prev=prev;
				this.next=next;
				this.pageNum=pageNum;
			}
		}

		
		private int capacity;
		private int currentSize;
		
		private Node first;// ����ͷ
		private Node last;// ����β
	
		
		public LRUPageFrame(int capacity) {
			this.capacity = capacity;
			first=new Node(null,null,0);
			last=new Node(first,null,0);
			first.next=last;
			currentSize=0;
		}
	
		/**
		 * ��ȡ�����ж���
		 * �������ݡ�
		 * @param key
		 * @return
		 */
		public void access(int pageNum) {
			
			//�жϵ�ǰ��С�Ƿ�����������ǣ������ɾ��ͷ�ڵ����ݲ�������ֱ�Ӳ��롣
			Node p=first;
			if(currentSize==capacity){
				//�жϱ����Ƿ���ڱ���������ɾ��ָ��ֵ��
				int j=contain(pageNum);
				if(j!=0){
					delect(j);
				}
				else{
					delect(1);
				}
				//�ڱ�β�����½ڵ㡣
				Node q=first;
				for(int i=0;i<=1;i++){
					q=q.next;
				}
				Node aNode=new Node(q,last,pageNum);
				q.next=aNode;
				last.prev=aNode;
				
			}else{
				for(int i=0;i<currentSize;i++){
					p=p.next;
				}
				Node aNode=new Node(p,last,pageNum);
				p.next=aNode;
				last.prev=aNode;
				
				currentSize++;
			}
		
		}
	

		
		/*
		 * �жϵ�ǰ�����Ƿ���ڱ����õı���������������λ��.
		 * �������򷵻�0��
		 */
		public int contain(int number){
			Node p=first;
			int flag=0;
			for(int i=1;i<=currentSize;i++){
				p=p.next;
				if(number==p.pageNum){
					flag=i;
				}
			}
			return flag;
		}
		
		/*
		 * ɾ��ָ��λ�õ�ֵ��
		 */
		public void delect(int place){
			Node p=first;
			for(int i=1;i<=place;i++){//����λ�ã��ҵ�ָ���ڵ㡣
				p=p.next;
			}
			p.prev.next=p.next;
			p.next.prev=p.prev;
			
		}
		
		
		/*
		 * ��ӡ�����е����ݡ�
		 */
		public String toString(){
			StringBuilder buffer = new StringBuilder();
			Node node = last.prev;
			while(node != null){
				if(node==first){
					break;
				}
				
				buffer.append(node.pageNum);
				node = node.prev;
				if(node != null&&node!=first){
					buffer.append(",");
				}
			}
			return buffer.toString();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 */
