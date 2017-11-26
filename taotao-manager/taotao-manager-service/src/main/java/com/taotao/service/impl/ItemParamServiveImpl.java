package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.entity.TbItemParam;
import com.taotao.entity.TbItemParamExample;
import com.taotao.entity.TbItemParamExample.Criteria;
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

	@Override
	public TaotaoResult getItemParamByCid(Long cid) {
		// 创建查询条件
		TbItemParamExample itemParamExample = new TbItemParamExample();
		Criteria criteria = itemParamExample.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(itemParamExample);
		if (list != null && list.size() > 0) {
			TbItemParam tbItemParam = list.get(0);
			return TaotaoResult.ok(tbItemParam);
		}
		return TaotaoResult.ok();
	}

}
