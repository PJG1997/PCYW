package com.yc.bean;

import java.io.Serializable;
import java.util.List;

public class JsonModel<T> implements Serializable{
	
	private static final long serialVersionUID = -2141546735354453318L;
	
	
	private Integer code;
	private Object obj;
	private String errmsg;
	
	private List<Admin> users; //记录管理员数量
	
	
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
	public List<Admin> getUsers() {
		return users;
	}
	public void setUsers(List<Admin> users) {
		this.users = users;
	}
	
	
	
	
	
}
