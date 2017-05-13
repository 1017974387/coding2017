package structure.week9;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 * ��Queue��ʵ��Josephus����
 * ��������ϵ����⵱�У� N�����ݾ�������һ��ͬ�������ַ�ʽ��������������  N����Χ��һȦ��λ�ü�Ϊ0��N-1���� ���Ҵӵ�һ���˱����� ����M���˻ᱻɱ���� ֱ�����һ����������
 * �÷�������һ��List�� �����˱�ɱ���˵Ĵ���
 * @author liuxin
 *
 */
public class Josephus {
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static List<Integer> execute(int n, int m){
		List<Integer> res = new ArrayList<Integer>();
		int index = 0;
		for(int i=0;i<n;i++){
			queue.add(i);
		}
	    while(queue.size()>0){
	    	Integer intege = queue.remove();
	    	if(index==m-1){
	    		res.add(intege);
	    		index = 0;
	    	}else{
	    		queue.add(intege);
		    	index += 1;
		    	index %= m;
	    	}
	    }
		return res;
	}
}