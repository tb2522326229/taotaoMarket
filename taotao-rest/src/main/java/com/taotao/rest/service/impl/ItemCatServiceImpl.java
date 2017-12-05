package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.entity.TbItemCat;
import com.taotao.entity.TbItemCatExample;
import com.taotao.entity.TbItemCatExample.Criteria;
import com.taotao.entity.TbItemExample;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.rest.entity.CatgoryNode;
import com.taotao.rest.entity.ItemCatResult;
import com.taotao.rest.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;

	// 查询商品种类
	@Override
	public ItemCatResult getItemCatList() {
		// 调用递归方法来查询商品分类列表
		List catList = getItemCatList(0L);
		// 返回结果
		ItemCatResult result = new ItemCatResult();
		result.setData(catList);
		return result;
	}

	// 递归方法通过parent_id查询商品分类
	public List getItemCatList(Long parentId) {
		// 根据parentId查询列表
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List resultList = new ArrayList<>();

		int index = 0; // 设置一级节点下标
		for (TbItemCat tbItemCat : list) {
			if (index >= 14) {
				break;
			}
			// 如果是父节点
			if (tbItemCat.getIsParent()) {
				CatgoryNode node = new CatgoryNode();
				node.setUrl("/products/" + tbItemCat.getId() + ".html");
				// 如果当前节点为第一级节点
				if (tbItemCat.getParentId() == 0) {
					node.setName("<a href='/products/" + tbItemCat.getId() + ".html'>" + tbItemCat.getName() + "</a>");
					// 第一个节点不能超过14个元素，index为计数器
					index++;
				} else {
					node.setName(tbItemCat.getName());
				}
				node.setItems(getItemCatList(tbItemCat.getId()));
				// 把node添加到列表
				resultList.add(node);
			} else {
				// 如果是叶子节点
				String item = "/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName();
				resultList.add(item);
			}
		}
		return resultList;
	}
}
