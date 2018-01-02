package com.taotao.search.service;

import com.taotao.search.entity.SearchResult;

public interface SearchService {
	
	// 查询商品的方法
	public SearchResult search(String queryString, int pageIndex, int pageSize) throws Exception;
}
