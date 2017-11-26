package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.service.ItemParamServive;

@Controller
public class ItemParamController {

	@Autowired
	private ItemParamServive itemParamService;
	
	@RequestMapping("/item/param/list")
	@ResponseBody
	public EasyUIDataGridResult getParamList(Integer page,Integer rows){
		EasyUIDataGridResult itemList = itemParamService.getItemList(page,rows);
		return itemList;
	}
}
