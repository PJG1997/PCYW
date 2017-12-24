package com.yc.bean;

import java.io.Serializable;


public class Route implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8772782235592525532L;
	private Integer rid;//1.	线路ID
	private String rname;//2.	线路名称、
	private String rvia;//3.	配送路线顺序
	
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRvia() {
		return rvia;
	}
	public void setRvia(String rvia) {
		this.rvia = rvia;
	}
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Route(String rname, String rvia) {
		super();
		this.rname = rname;
		this.rvia = rvia;
	}
	@Override
	public String toString() {
		return "Route [rid=" + rid + ", rname=" + rname + ", rvia=" + rvia
				+ "]";
	}
	
	
	
//	private String r1;
//	private String r2;
//	private String r3;
//	private String r4;
	

	
}
