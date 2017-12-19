package com.taotao.rest.service;

import java.util.List;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.entity.TbContent;

public interface ContentService {
	// 发布内容查询服务：根据内容分类id查询tb_content表，得到此分类下的内容列表，返回。
	public List<TbContent> getContentList(Long cid);
	// 缓存同步：当后台修改内容信息后，只需要把redis中缓存的数据删除即可。
	public TaotaoResult syncContent(Long cid);
}
