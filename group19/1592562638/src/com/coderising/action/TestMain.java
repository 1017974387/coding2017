package com.coderising.action;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/*
0. ��ȡ�����ļ�struts.xml

1. ����actionName�ҵ����Ӧ��class �� ����LoginAction,   ͨ������ʵ��������������
��parameters�е����ݣ����ö����setter������ ����parameters�е������� 
("name"="test" ,  "password"="1234") ,     	
�Ǿ�Ӧ�õ��� setName��setPassword����

2. ͨ��������ö����exectue ������ ����÷���ֵ������"success"

3. ͨ�������ҵ����������getter���������� getMessage��,  
ͨ�����������ã� ��ֵ�������γ�һ��HashMap , ���� {"message":  "��¼�ɹ�"} ,  
�ŵ�View�����parameters

4. ����struts.xml�е� <result> ����,�Լ�execute�ķ���ֵ��  ȷ����һ��jsp��  
�ŵ�View�����jsp�ֶ��С�

*/
//ͨ��JDOM����ȡxml�ļ�
public class TestMain {
	
	private static String xmlSource=System.getProperty("user.dir")+"\\src\\com\\coderising\\action\\struts.xml";
	private static Map<String, Object> container = new HashMap<String, Object>();//��ȡxml��name�ַ�����class��
	private static Map<String, String> containerStr = new HashMap<String, String>();//��ȡxml��name��class�ַ���
	private static Map<String, Object> containerBak = new HashMap<String, Object>();//��ȡgetter��������
	
	private static View view;
	
	public static void main(String[] args) throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		//������
		SAXBuilder builder=new SAXBuilder();
		//StringReader reader=new StringReader(System.getProperty("user.dir")+"\\src\\com\\second\\xml/struts.xml");
		
		Document document=builder.build(xmlSource);
		
		XPathFactory xFactory=XPathFactory.instance();
		XPathExpression<Element> expr=xFactory.compile("//struts//action",Filters.element());
		
		List<Element> links=expr.evaluate(document);
		for(Element linkElement:links){
			String name=linkElement.getAttributeValue("name");
			String clazz=linkElement.getAttributeValue("class");
			//���÷�������ʵ�� Ȼ��װ������
			Object o=Class.forName(clazz).newInstance();
			container.put(name,o);
			containerStr.put(name, clazz);
			
			System.out.println("name: "+name+", class: "+clazz);
		}
		
		if(container.containsKey("login")){
			LoginAction lAction=(LoginAction)container.get("login");
			lAction.setName("test");
			lAction.setPassword("1234");
			
			String strTmp=lAction.execute();//ִ��execute����
			System.out.println("name="+lAction.getName()+" password="+lAction.getPassword()+"->��¼�����"+strTmp);
			
			Class clazz=Class.forName(containerStr.get("login"));
			Method[] methods=clazz.getMethods();
			for(Method method:methods){
				String methodName=method.getName();
				//int indexTmp=methodName.indexOf("get");
				//if(indexTmp!=-1){
				if(methodName.startsWith("get")){
					//����get�ķ�����
					//String methodStr=methodName.substring(indexTmp+3);
					String methodStr=methodName.substring(3);
					System.out.println(methodStr);
					
					Field field=clazz.getDeclaredField(methodName);
					if(null!=field){
						Object obj=new Object();
						method.invoke(obj);
						field.setAccessible(true);
						containerBak.put(methodStr, field.get(obj));
					}
				}
			}
			view.setParameters(containerBak);//���浽view��
		}
	}

}
