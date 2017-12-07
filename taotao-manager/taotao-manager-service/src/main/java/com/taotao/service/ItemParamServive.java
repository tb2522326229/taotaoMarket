package com.taotao.service;

import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;

public interface ItemParamServive {

	// 获取分页查询
	public EasyUIDataGridResult getItemParamList(int pageIndex, int pageSize);

	// 根据cid查询商品的模板
	public TaotaoResult getItemParamByCid(Long cid);

	// 插入新的商品模板
	public TaotaoResult insertItemParamByCid(Long cid, String paramData);
}
