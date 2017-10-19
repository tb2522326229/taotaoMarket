package com.taotao.service;

import com.taotao.entity.TbItem;

public interface ItemService {
	
	//根据商品id查询商品
	public TbItem getItemById(Long itemId);
}
