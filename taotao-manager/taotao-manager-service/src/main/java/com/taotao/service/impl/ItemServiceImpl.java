package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.entity.TbItem;
import com.taotao.entity.TbItemDesc;
import com.taotao.entity.TbItemExample;

import com.taotao.entity.TbItemExample.Criteria;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;

import com.taotao.service.ItemService;

@Service

public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;

	@Autowired
	private TbItemDescMapper itemDescMapper;

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

	@Override
	public TaotaoResult createItem(TbItem item, String desc) {
		// 先生成商品id
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		// 商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		// 插入到商品表
		tbItemMapper.insert(item);
		// 商品描述
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		// 插入商品描述
		itemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();

	}

}