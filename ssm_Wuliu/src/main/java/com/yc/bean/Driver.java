package com.yc.bean;

import java.io.Serializable;



public class Driver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3453764343626256016L;
	private Integer did;//1.	司机ID
	private String dname;//2.	司机名称、
	private String dnumber;//3.	驾驶证号、
	private String dphone;//4.	联系电话、
	private String didCard;//5.	身份证、
	private Integer ddage;//6.	驾龄
	private Integer dstatus = 0;//7.	司机状态（0空闲，1在忙）。默认0

	private ShipPoint shipPoint;

	public Integer getDid() {
		return did;
	}
	
	public ShipPoint getShipPoint() {
		return shipPoint;
	}
	

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDnumber() {
		return dnumber;
	}

	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}

	public String getDphone() {
		return dphone;
	}

	public void setDphone(String dphone) {
		this.dphone = dphone;
	}

	public String getDidCard() {
		return didCard;
	}

	public void setDidCard(String didCard) {
		this.didCard = didCard;
	}

	public Integer getDdage() {
		return ddage;
	}

	public void setDdage(Integer ddage) {
		this.ddage = ddage;
	}


	public void setShipPoint(ShipPoint shipPoint) {
		this.shipPoint = shipPoint;
	}

	public Driver() {
		super();
	}

	public Driver(String dname, String dnumber, String dphone, String didCard,
		Integer ddage, Integer dstatus) {
	super();
	this.dname = dname;
	this.dnumber = dnumber;
	this.dphone = dphone;
	this.didCard = didCard;
	this.ddage = ddage;
	this.dstatus = dstatus;
}

	
	@Override
	public String toString() {
		return "Driver [ddage=" + ddage + ", did=" + did + ", didCard="
				+ didCard + ", dname=" + dname + ", dnumber=" + dnumber
				+ ", dphone=" + dphone + ", dstatus=" + dstatus + "]";
	}

	public Driver(Integer did) {
		super();
		this.did = did;
	}

	public Integer getDstatus() {
		return dstatus;
	}

	public void setDstatus(Integer dstatus) {
		this.dstatus = dstatus;
	}

	
//	private String d1;
//	private String d2;
//	private String d3;
//	private String d4;
	
	
	

}
