package com.taotao.service;


import com.taotao.common.entity.EasyUIDataGridResult;

public interface ItemParamServive {
	
	// 获取分页查询
	public EasyUIDataGridResult getItemList(int pageIndex, int pageSize);
}
