package tree;

import java.io.File;

public class FileList {

	public void list(File file)
	{
		//��ȡ��Ŀ¼�����е��ļ������ļ��е�File����
		File[] fileArray=file.listFiles();
		// ������File���飬�õ�ÿһ��File����
		for(File f:fileArray)
		{
			// �жϸ�File�����Ƿ����ļ���
			if(f.isDirectory())
			{
				System.out.println("�ļ�����Ϊ��"+f.getName());
				list(f);
			}else{
				System.out.println("�ļ���Ϊ��"+f.getName());
			}
		}
	}
}
