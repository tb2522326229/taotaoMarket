package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content/query")
public class ContentController {
	@Autowired
	private ContentService contentService;
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getContentList(Integer page,Integer rows){
		EasyUIDataGridResult result = contentService.getContentList(page, rows);
		return result;
	}
}
