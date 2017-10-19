package com.taotao.common.pojo;

import java.util.List;

/**
 * EasyUI DataGrid的返回值类型
 */
public class EasyUIDataGridResult {

	private long total;//总记录数
	private List<?> rows;//每一页显示的内容的集合
	
	public EasyUIDataGridResult(long total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
