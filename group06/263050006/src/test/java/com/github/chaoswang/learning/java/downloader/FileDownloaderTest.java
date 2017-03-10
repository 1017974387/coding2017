package com.github.chaoswang.learning.java.downloader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.chaoswang.learning.java.downloader.api.ConnectionManager;
import com.github.chaoswang.learning.java.downloader.api.DownloadListener;
import com.github.chaoswang.learning.java.downloader.impl.ConnectionManagerImpl;

public class FileDownloaderTest {
	boolean downloadFinished = false;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDownload() {
		
		String url = "http://dev.zte.com.cn/upload/banners/1488981056630_.jpg";
		
		FileDownloader downloader = new FileDownloader(url);

	
		ConnectionManager cm = new ConnectionManagerImpl();
		downloader.setConnectionManager(cm);
		
		downloader.setListener(new DownloadListener() {
			@Override
			public void notifyFinished() {
				downloadFinished = true;
			}

		});

		
		downloader.execute();
		
		// �ȴ����߳����س���ִ�����
		while (!downloadFinished) {
			try {
				System.out.println("��û��������ɣ���������");
				//����5��
				Thread.sleep(5000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		System.out.println("������ɣ�");
		
		

	}

}
