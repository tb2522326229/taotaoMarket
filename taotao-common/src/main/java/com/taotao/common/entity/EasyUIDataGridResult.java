package com.taotao.common.entity;

import java.util.List;

/**
 * EasyUI DataGrid的返回值类型
 */
public class EasyUIDataGridResult {

	private long total;// 总记录数
	private List<?> rows;// 返回的結果
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
