package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.entity.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;
	@Autowired
	private ContentService contentService;
	
	/*@RequestMapping("/query/list")
	@ResponseBody
	public EasyUIDataGridResult getContentList(Integer page,Integer rows){
		System.out.println("进入了controller");
		EasyUIDataGridResult result = contentService.getContentList(page, rows);
		return result;
	}*/
	
	@RequestMapping("/query/list/{categoryId}")
	@ResponseBody
	public EasyUIDataGridResult getContentById(@PathVariable Long categoryId,Integer page, Integer rows){
		EasyUIDataGridResult content = contentService.getContentById(categoryId,page,rows);
		return content;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		// 调用taotao-rest发布的服务，同步缓存
		HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
		return result;
	}

}
