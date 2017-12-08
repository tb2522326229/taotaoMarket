package com.taotao.service;

import com.taotao.common.entity.EasyUIDataGridResult;

public interface ContentService {

	// 获取内容列表
	public EasyUIDataGridResult getContentList(int pageIndex, int pageSize);
}
