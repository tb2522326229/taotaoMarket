package com.taotao.service;

import java.util.List;

import com.taotao.common.entity.EasyUITreeNode;
import com.taotao.common.utils.TaotaoResult;

public interface ContentCategoryService {
	// 查询内容分类列表
	public List<EasyUITreeNode> getContentCatList(Long parentId);
	
	// 商城首页新增内容分类节点
	public TaotaoResult insertCatgory(Long parentId, String name);
}
