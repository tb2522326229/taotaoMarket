package com.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.taotao.search.entity.SearchResult;

public interface SearchDao {
	
	// 查询方法（根据查询条件进行查询，返回查询结果。）
	public SearchResult search(SolrQuery query) throws Exception;
}
