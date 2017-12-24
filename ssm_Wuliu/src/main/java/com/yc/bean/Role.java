package com.yc.bean;

import java.io.Serializable;


public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 887732382166041410L;
	private Integer roleid;
	private String rolename;//角色名（普通用户，管理者）
	private Integer renabled;//关系是否可用(0,可用 1，不可用)
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Integer getRenabled() {
		return renabled;
	}
	public void setRenabled(Integer renabled) {
		this.renabled = renabled;
	}
	public Role(String rolename, Integer renabled) {
		super();
		this.rolename = rolename;
		this.renabled = renabled;
	}
	public Role() {
		super();
	}
	
	
	
	
}
