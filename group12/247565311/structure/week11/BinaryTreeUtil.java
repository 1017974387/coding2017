package structure.week11;
import structure.week11.BinaryTreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUtil {
	/**
	 * �õݹ�ķ�ʽʵ�ֶԶ�������ǰ������� ��Ҫͨ��BinaryTreeUtilTest����
	 * @param root
	 * @return
	 */
	public static <T> List<T> preOrderVisit(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		if(root == null) return result;
		result.add(root.val);
		List<T> left = preOrderVisit(root.left);
		for(int i=0;i<left.size();i++){
			result.add(left.get(i));
		}
		List<T> right = preOrderVisit(root.right);
		for(int i=0;i<right.size();i++){
			result.add(right.get(i));
		}
		return result;
	}

	/**
	 * �õݹ�ķ�ʽʵ�ֶԶ��������б���
	 * @param root
	 * @return
	 */
	public static <T> List<T> inOrderVisit(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		if(root==null) return result;
		List<T> left = inOrderVisit(root.left);
		for(int i=0;i<left.size();i++){
			result.add(left.get(i));
		}
		result.add(root.val);
		List<T> right = inOrderVisit(root.right);
		for(int i=0;i<right.size();i++){
			result.add(right.get(i));
		}
		return result;
	}

	/**
	 * �õݹ�ķ�ʽʵ�ֶԶ������ĺ����
	 * 
	 * @param root
	 * @return
	 */
	public static <T> List<T> postOrderVisit(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		if(root==null) return result;
		List<T> left = postOrderVisit(root.left);
		for(int i=0;i<left.size();i++){
			result.add(left.get(i));
		}	
		List<T> right = postOrderVisit(root.right);
		for(int i=0;i<right.size();i++){
			result.add(right.get(i));
		}
		result.add(root.val);
		return result;
	}
	/**
	 * �÷ǵݹ�ķ�ʽʵ�ֶԶ�������ǰ�����
	 * @param root
	 * @return
	 */
	public static <T> List<T> preOrderWithoutRecursion(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
		while(stack.size()>0 || root !=null){
			if(root!=null){
				result.add(root.val);
				stack.add(root);
				root = root.left;
			}else{
				root = stack.pop();
				root = root.right;
			}
		}
		return result;
	}
	/**
	 * �÷ǵݹ�ķ�ʽʵ�ֶԶ��������������
	 * @param root
	 * @return
	 */
	public static <T> List<T> inOrderWithoutRecursion(BinaryTreeNode<T> root) {
		List<T> result = new ArrayList<T>();
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
		while(stack.size()>0||root!=null){
			if(root != null){
				stack.add(root);
				root = root.left;
			}else{
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
	}
}
