package com.yc.bean;

import java.io.Serializable;

public class Driver implements Serializable{
	private static final long serialVersionUID = -2939412317386360377L;
	
	private Integer did;		//司机ID
    private Shippoint shipPoint;	//配送点的对象
    private String dname;		//司机名称、
    private String dnumber;		//驾驶证号
    private String dphone;		//联系电话、
    private String didcard;		//身份证、
    private Integer ddage;		//驾龄
    private Integer dstatus;	//司机状态（0空闲，1在忙）。默认0
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Shippoint getShipPoint() {
		return shipPoint;
	}
	public void setShipPoint(Shippoint shipPoint) {
		this.shipPoint = shipPoint;
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
	public String getDidcard() {
		return didcard;
	}
	public void setDidcard(String didcard) {
		this.didcard = didcard;
	}
	public Integer getDdage() {
		return ddage;
	}
	public void setDdage(Integer ddage) {
		this.ddage = ddage;
	}
	public Integer getDstatus() {
		return dstatus;
	}
	public void setDstatus(Integer dstatus) {
		this.dstatus = dstatus;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getRemark4() {
		return remark4;
	}
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	public String getRemark5() {
		return remark5;
	}
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}
	@Override
	public String toString() {
		return "Driver [did=" + did + ", shipPoint=" + shipPoint + ", dname=" + dname + ", dnumber=" + dnumber
				+ ", dphone=" + dphone + ", didcard=" + didcard + ", ddage=" + ddage + ", dstatus=" + dstatus
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + ", remark3=" + remark3 + ", remark4=" + remark4
				+ ", remark5=" + remark5 + "]";
	}
    
}