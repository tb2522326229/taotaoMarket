package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.service.ItemParamServive;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamServive itemParamService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getParamList(Integer page,Integer rows){
		EasyUIDataGridResult itemList = itemParamService.getItemList(page,rows);
		return itemList;
	}
	
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Long cid){
		TaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;
	}
}
