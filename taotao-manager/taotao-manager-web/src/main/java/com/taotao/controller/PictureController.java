package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.entity.PictureResult;
import com.taotao.service.PictureService;

@Controller
public class PictureController {

	@Autowired
	private PictureService picService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PictureResult uploadFile(MultipartFile uploadFile){
		PictureResult result = picService.uploadPic(uploadFile);
		return result;
	}
}
