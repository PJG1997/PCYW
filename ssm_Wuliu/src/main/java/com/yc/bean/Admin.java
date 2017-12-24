package com.yc.bean;

import java.io.Serializable;


public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6512667711947218306L;
	private Integer aid;		//	1．管理员ID
	private String aname;		//	2.用户名
	private String apwd;  	//密码
	
	  
//	  private String a1;
//	  private String a2;
//	  private String a3;
//	  private String a4;
  
	
	
	public String getApwd() {
		return apwd;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
    
  
  
	
}
