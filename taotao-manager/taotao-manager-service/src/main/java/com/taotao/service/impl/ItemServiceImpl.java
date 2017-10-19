package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.entity.TbItem;
import com.taotao.entity.TbItemExample;
import com.taotao.entity.TbItemExample.Criteria;
import com.taotao.mapper.TbItemMapper;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem getItemById(Long itemId) {
		TbItemExample itemExample = new TbItemExample();
		// 创建查询条件
		Criteria criteria = itemExample.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(itemExample);
		//判断list是否为空
		TbItem item = null;
		if(list != null && list.size() > 0){
			item = list.get(0);
		}
		return item;
	}

}
