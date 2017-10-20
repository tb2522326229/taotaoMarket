package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.entity.EasyUITreeNode;
import com.taotao.service.ItemCatService;

//商品分类管理的controller
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	//新增类目
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {// 把前台传过来的id赋值给parentId
		List<EasyUITreeNode> itemCatList = itemCatService.getItemCatList(parentId);
		return itemCatList;
	}
}
