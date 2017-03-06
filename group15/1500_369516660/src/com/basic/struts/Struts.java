package com.basic.struts;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Struts {
	
	public static View runAction(String actionName,Map<String,String> parameters){
		/*
		 * 0. ��ȡ�����ļ�struts.xml
		 * 1. ����actionName�ҵ����Ӧ��class, ����LoginAction,ͨ������ʵ��������������,
		 * ��parameters�е����ݣ����ö����setter������ ����parameters�е������� ("name"="test","password"="1234"),�Ǿ�Ӧ�õ��� setName��setPassword����
		 * 2. ͨ��������ö����exectue ������ ����÷���ֵ������"success"
		 * 3. ͨ�������ҵ����������getter���������� getMessage��, 
		 *  ͨ�����������ã� ��ֵ�������γ�һ��HashMap , ���� {"message":  "��¼�ɹ�"} ,�ŵ�View�����parameters
		 * 4. ����struts.xml�е� <result> ����,�Լ�execute�ķ���ֵ��  ȷ����һ��jsp,�ŵ�View�����jsp�ֶ��С� 
		 */
		DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();//�õ� DOM �������Ĺ���ʵ��    
		try {
			DocumentBuilder domBuilder=domfac.newDocumentBuilder();//�� DOM ������� DOM ������ 
			InputStream is= new  FileInputStream(new File("../struts.xml"));
			Document doc = domBuilder.parse(is);
			Element root =  doc.getDocumentElement();//��ȡ���ڵ�
			NodeList childNodes = root.getChildNodes();//��ȡ�ӽڵ�<action>
			if(childNodes!=null){
				for(int i=0;i<childNodes.getLength();i++){//�����ӽڵ�<action>
					Node childNode = childNodes.item(i);
					if(childNode.getNodeType()==Node.ELEMENT_NODE){//�ж��Ƿ���Ԫ�ؽڵ�
						String name = childNode.getAttributes().getNamedItem("name").getNodeValue();//��ȡ�ڵ������ֵ��action������name��ֵ��
						if(actionName.equals(name)){
							Class<?> class1 = Class.forName(childNode.getAttributes().getNamedItem("class").getNodeValue());//�õ�action��һ��class����
							Object object = class1.newInstance();//����һ��actionʵ��
							for(Entry<String,String> entry : parameters.entrySet()){
								//�õ�ÿ��������setter����
								Method method = class1.getMethod(new StringBuffer("set").append(entry.getKey().substring(0,1).toUpperCase()).append(entry.getKey().substring(1)).toString(), entry.getKey().getClass());
								//����action�е�ÿ��������setter��������action���Ը�ֵ
								method.invoke(object,entry.getValue());
							}
							//�õ�����action����ĺ������
							Method method2 = class1.getMethod("execute");
						
						}
						/*for(Node node = childNode.getFirstChild();node!=null;node=node.getNextSibling()){
							if(node.getNodeType()==Node.ELEMENT_NODE){
								if(node.getNodeName().equals("name")){
									String name2 = node.getNodeValue();
									String name3 = node.getFirstChild().getNodeValue();
								}
								if(node.getNodeName().equals("price")){
									String price = node.getFirstChild().getNodeValue();
								}
							}
						}*/
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
