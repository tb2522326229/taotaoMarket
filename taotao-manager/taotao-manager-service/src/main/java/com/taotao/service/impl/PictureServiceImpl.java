package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.entity.PictureResult;
import com.taotao.common.utils.FastDFSClient;
import com.taotao.service.PictureService;

/**
 * 图片服务器上传功能的实现
 */
@Service
public class PictureServiceImpl implements PictureService {
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Override
	public PictureResult uploadPic(MultipartFile picFile) {

		PictureResult result = new PictureResult();
		// 判断图片是否为空
		if (picFile.isEmpty()) {
			result.setError(1);
			result.setMessage("图片为空，上传失败");
			return result;
		}
		// 取到文件的原始名称
		String filename = picFile.getOriginalFilename();
		// 获取图片的格式（如jpg）
		String extName = filename.substring(filename.lastIndexOf(".") + 1);
		// 上传到图片服务器
		try {
			FastDFSClient fastdfs = new FastDFSClient(
					"E:/JAVA/GitHub/taotaoMarket/taotao-manager/taotao-manager-web/src/main/resources/properties/Client.conf");
			String[] urls = fastdfs.uploadFile(picFile.getBytes(), extName);
			String url = IMAGE_BASE_URL;
			// String url = "192.168.133.25";
			for (int i = 0; i < urls.length; i++) {
				/*
					添加if语句是因为返回的url少了一个“/”，导致文件夹路径错误：例如：
					http://192.168.25.133/group1M00/00/00/wKgZhVoWSGiAItI4AALlmdmYimQ895.jpg
					正确的是：http://192.168.25.133/group1/M00/00/00/wKgZhVoWSGiAItI4AALlmdmYimQ895.jpg
				 */
				if(i == 0){
					url += urls[i] + "/";
				}
				else{
					url += urls[i];
				}
			}
			System.out.println("url: " + url);
			result.setError(0);

		} catch (Exception e) {
			e.printStackTrace();
			result.setError(1);
			result.setMessage("图片上传失败");
		}
		return result;
	}

}
