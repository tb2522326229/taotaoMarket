package com.taotao.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.search.dao.SearchDao;
import com.taotao.search.entity.SearchResult;
import com.taotao.search.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;

	@Override
	public SearchResult search(String queryString, int pageIndex, int pageSize) throws Exception {
		// 创建查询条件
		SolrQuery query = new SolrQuery();
		// 设置查询条件
		query.setQuery(queryString);
		// 设置分页条件
		query.setStart((pageIndex - 1) * pageSize);
		query.setRows(pageSize);
		// 设置默认搜索域
		query.set("df", "item_title");
		// 设置高亮
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<font class=\"skcolor_ljg\">");
		query.setHighlightSimplePost("</font>");
		// 执行查询
		SearchResult searchResult = searchDao.search(query);
		// 计算总页数
		Long recordCount = searchResult.getTotal();
		int pageCount = (int) (recordCount / pageSize);
		if (recordCount % pageSize > 0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setPageIndex(pageIndex);
		return searchResult;

	}

}
