package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.entity.TbItemParam;
import com.taotao.entity.TbItemParamExample;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.service.ItemParamServive;

@Service
public class ItemParamServiveImpl implements ItemParamServive {
	
	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public EasyUIDataGridResult getItemList(int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		TbItemParamExample itemParamExample = new TbItemParamExample();
		List<TbItemParam> list = itemParamMapper.selectByExample(itemParamExample);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		PageInfo<TbItemParam> pageInfo = new PageInfo<TbItemParam>(list);
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
