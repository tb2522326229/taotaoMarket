package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.entity.TbContent;
import com.taotao.entity.TbContentExample;
import com.taotao.mapper.TbContentMapper;
import com.taotao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public EasyUIDataGridResult getContentList(int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		TbContentExample conExample = new TbContentExample();
		List<TbContent> list = contentMapper.selectByExample(conExample);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}
