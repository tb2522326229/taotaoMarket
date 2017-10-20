package com.taotao.service;

import java.util.List;

import com.taotao.common.entity.EasyUITreeNode;

public interface ItemCatService {
	// 根据父类目的id查询该类别下面所有叶子类目（父节点下的子节点）
	public List<EasyUITreeNode> getItemCatList(Long id);
}
