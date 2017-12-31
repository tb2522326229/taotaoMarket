package com.taotao.search.entity;
/**
 * 搜索服务的返回对应的实体类
 */
import java.util.List;

public class SearchResult {
	private List<SearchItem> itemList;// 返回的集合
	private Long total;// 返回总记录数
	private int pageCount;// 总页数
	private int pageIndex;// 当前页

	public List<SearchItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
