package com.taotao.service;

import com.taotao.common.entity.EasyUIDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.entity.TbContent;

public interface ContentService {

	// 获取内容列表
	public EasyUIDataGridResult getContentList(int pageIndex, int pageSize);

	// 根据id查询内容
	public EasyUIDataGridResult getContentById(Long categoryId, int pageIndex, int pageSize);
	
	// 新增前台页面内容
	public TaotaoResult insertContent(TbContent content);
}
