package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.entity.EasyUITreeNode;
import com.taotao.entity.TbItemCat;
import com.taotao.entity.TbItemCatExample;
import com.taotao.entity.TbItemCatExample.Criteria;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyUITreeNode> getItemCatList(Long id) {
		// 根据parentId查询分类列表
		TbItemCatExample example = new TbItemCatExample();
		// 设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		// 执行查询
		List<TbItemCat> itemList = itemCatMapper.selectByExample(example);
		// 转换成EasyUITreeNode列表（用于返回json格式的字符串）
		List<EasyUITreeNode> nodeList = new ArrayList<EasyUITreeNode>();
		for (TbItemCat itemCat : itemList) {
			// 创建一个节点对象
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			node.setState(itemCat.getIsParent() ? "closed" : "open");
			// 添加到列表
			nodeList.add(node);
		}
		return nodeList;
	}

}
