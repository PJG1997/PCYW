package com.yc.bean;

import java.io.Serializable;

public class JsonModel implements Serializable{

	private static final long serialVersionUID = 9106902882602433353L;
	
	private Integer code;
	private Object obj;
	private String errmsg;

	private Integer total;	//总记录数
	private Integer pages;	//当前为第几页
	private Integer pageSize;	//页面的大小
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
}
