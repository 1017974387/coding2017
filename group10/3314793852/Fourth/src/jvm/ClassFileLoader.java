	
	package jvm;
	
	import java.io.BufferedInputStream;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	
	public class ClassFileLoader {
	
		private List<String> clzPaths = new ArrayList<String>();
		
		public byte[] readBinaryCode(String className) {
			byte[] data=new byte[1016];
			
			//��ȡClass�ļ�Ҫ���ֽ�������,ͨ���ֽ�������ȡ�ļ���
			 try {
				BufferedInputStream bis = new BufferedInputStream(
				           new FileInputStream(clzPaths.get(0)));
				 bis.read(data);
				 bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;	
		}
		
		public void addClassPath(String path) {
			clzPaths.add(path);
		}
		
		public String getClassPath(){
			String allPath="";
			for(String s:clzPaths){
				allPath=allPath+s+";";
			}
			return allPath;
		}

	}
	
