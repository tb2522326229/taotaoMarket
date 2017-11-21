package com.taotao.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class TestFastdfs {
	@Test
	public void testUpload() throws Exception {
		// 1、把FastDFS提供的jar包添加到工程中
		// 2、初始化全局配置。加载一个配置文件。
		ClientGlobal.init(
				"E:\\JAVA\\GitHub\\taotaoMarket\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\Client.conf");
		// 3、创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
		// 4、创建一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5、声明一个StorageServer对象，null。
		StorageServer storageServer = null;
		// 6、获得StorageClient对象。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 7、直接调用StorageClient对象方法上传文件即可。
		String[] strings = storageClient.upload_file("F:\\壁纸\\0.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}

	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient(
				"E:\\JAVA\\GitHub\\taotaoMarket\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\Client.conf");
		String[] string = fastDFSClient.uploadFile("F:\\壁纸\\测试图片1.jpg");
		// 注意，你再上传一遍，刚才你上传的那个图片就已经丢了，它已经存在服务器上了，你再也访问不到了
		for (String string2 : string) {
			System.out.println(string2);
		}
	}

}
