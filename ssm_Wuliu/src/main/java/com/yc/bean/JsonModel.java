package com.yc.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class JsonModel<T> implements Serializable{
	
	private static final long serialVersionUID = -2141546735354453318L;
	
	
	private Integer code;
	private Object obj;
	private String errmsg;
	
	//private List<Users> users; //记录管理员数量
	private Map<String,Object> userMap;
	
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
	public Map<String, Object> getUserMap() {
		return userMap;
	}
	public void setUserMap(Map<String, Object> ump) {
		this.userMap = ump;
	}
	
	
	
	
	
}
