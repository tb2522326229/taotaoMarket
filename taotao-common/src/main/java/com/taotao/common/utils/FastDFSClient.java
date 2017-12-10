package com.taotao.common.utils;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {
	private static TrackerClient trackerClient;
	private static TrackerServer trackerServer;
	private static StorageServer storageServer;
	private static StorageClient storageClient;

	public FastDFSClient(String conf) throws Exception {
		if (conf.contains("classpath:")) {
			conf = conf.replace("classspath", this.getClass().getResource("/").getPath());
		}
		ClientGlobal.init(conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageClient = new StorageClient(trackerServer, storageServer);
	}

	/**
	 * 上传文件的方法
	 * 
	 * @param fileName
	 *            文件的全路径
	 * @param extName
	 *            文件扩展名，不包含.
	 * @param metas
	 *            文件扩展信息
	 */
	public String[] uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
		String[] result = storageClient.upload_file(fileName, extName, null);
		return result;
	}

	public String[] uploadFile(String fileName) throws Exception {
		return uploadFile(fileName, null, null);
	}

	public String[] uploadFile(String fileName, String extName) throws Exception {
		return uploadFile(fileName, extName, null);
	}

	/**
	 * 上传文件的方法
	 * 
	 * @param fileContent
	 *            文件的内容，
	 * @param extName
	 *            文件扩展名，不包含.
	 * @param metas
	 *            文件扩展信息
	 */
	public String[] uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
		String[] result = storageClient.upload_file(fileContent, extName, metas);
		return result;
	}

	public String[] uploadFile(byte[] fileContent) throws Exception {
		return uploadFile(fileContent, null, null);
	}

	public String[] uploadFile(byte[] fileContent, String extName) throws Exception {
		return uploadFile(fileContent, extName, null);
	}
}
