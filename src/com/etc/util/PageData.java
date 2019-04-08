package com.etc.util;


import java.util.List;

/**
 * 分页数据类
 */
public class PageData<T> {
	private List<T> data; // 查找[页面上显示]的数据

	private Integer total; // 总记录数

	private Integer pageSize;// 每页几行

	private Integer page;// 页数

	public PageData() {
		super();
	}

	/**
	 * 
	 * @param data
	 * @param total
	 * @param pageSize
	 * @param page
	 */
	public PageData(List<T> data, Integer total, Integer pageSize, Integer page) {
		super();
		this.data = data;
		this.total = total;
		this.pageSize = pageSize;
		this.page = page;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		// total是总记录数 100/10 101/10
		int num = total / pageSize;
		if (total % pageSize != 0) {
			num++;
		}
		return num;
	}

	@Override
	public String toString() {
		return "{total:" + total + ",data:" + data + "}";
	}
}
