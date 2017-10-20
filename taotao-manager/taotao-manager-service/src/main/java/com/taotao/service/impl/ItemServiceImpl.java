package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.entity.EasyUIDataGridResult;
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
		// 判断list是否为空
		TbItem item = null;
		if (list != null && list.size() > 0) {
			item = list.get(0);
		}
		return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(itemExample);
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}