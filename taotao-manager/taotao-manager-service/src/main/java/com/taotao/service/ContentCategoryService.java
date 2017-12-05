package com.taotao.service;

import java.util.List;

import com.taotao.common.entity.EasyUITreeNode;

public interface ContentCategoryService {
	// 查询内容分类列表
	public List<EasyUITreeNode> getContentCatList(Long parentId);
}
