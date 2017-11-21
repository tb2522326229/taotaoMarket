package com.taotao.common.entity;

 /*上传图片用的是kindeditor插件，需要返回一个json数据来表示是否上传成功*/
public class PictureResult {
	private int error; // 错误信息：0上传成功；1上传失败
	private String url; // 上传成功个后返回的图片的路径
	private String message; // 失败的信息

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
