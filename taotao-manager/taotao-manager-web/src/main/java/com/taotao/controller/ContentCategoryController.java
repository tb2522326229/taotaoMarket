package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.entity.EasyUITreeNode;
import com.taotao.service.ContentCategoryService;
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCatgoryService;

	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		List<EasyUITreeNode> list = contentCatgoryService.getContentCatList(parentId);
		return list;
	}
}
