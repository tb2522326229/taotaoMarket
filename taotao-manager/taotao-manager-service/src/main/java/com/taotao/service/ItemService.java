package com.taotao.service;

import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.entity.TbItem;

public interface ItemService {

	// 根据商品id查询商品
	public TbItem getItemById(Long itemId);
	
	// 获取分页查询
	public EasyUIDataGridResult getItemList(int pageIndex,int pageSize);
	
	// 新增商品
	public TaotaoResult createItem(TbItem item,String desc,String itemParam);

}
