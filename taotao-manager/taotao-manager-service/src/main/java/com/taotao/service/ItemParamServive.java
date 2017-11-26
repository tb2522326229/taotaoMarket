package com.taotao.service;


import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;

public interface ItemParamServive {
	
	// 获取分页查询
	public EasyUIDataGridResult getItemList(int pageIndex, int pageSize);
	
	//根据cid查询商品的模板
	public TaotaoResult getItemParamByCid(Long cid);
}
