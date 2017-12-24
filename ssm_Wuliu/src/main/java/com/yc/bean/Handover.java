package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

public class Handover implements Serializable{
	private static final long serialVersionUID = 1286352651445904050L;
	
	private Integer hid;	//交接ID
    private Car car;		//汽车对象
    private Driver driver;	//司机对象
    private Order1 order1;	//订单对象
    private Integer rid;	//路线对象
    private String hfromspname;		//起始配送点名称
    private String htospname;		//到达配送点名称
    private Date hstarttime;		//起始时间
    private Date hendtime;			//到达时间
    private Integer hstatus;		//交接单状态（默认状态0）。0未发车，1已发车，2已完成
    private String hremark;			//备注
    private String remark1;			//备用字段1
    private String remark2;			//备用字段2
    private String remark3;			//备用字段3
    private String remark4;			//备用字段4
    private String remark5;			//备用字段5
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Order1 getOrder1() {
		return order1;
	}
	public void setOrder1(Order1 order1) {
		this.order1 = order1;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getHfromspname() {
		return hfromspname;
	}
	public void setHfromspname(String hfromspname) {
		this.hfromspname = hfromspname;
	}
	public String getHtospname() {
		return htospname;
	}
	public void setHtospname(String htospname) {
		this.htospname = htospname;
	}
	public Date getHstarttime() {
		return hstarttime;
	}
	public void setHstarttime(Date hstarttime) {
		this.hstarttime = hstarttime;
	}
	public Date getHendtime() {
		return hendtime;
	}
	public void setHendtime(Date hendtime) {
		this.hendtime = hendtime;
	}
	public Integer getHstatus() {
		return hstatus;
	}
	public void setHstatus(Integer hstatus) {
		this.hstatus = hstatus;
	}
	public String getHremark() {
		return hremark;
	}
	public void setHremark(String hremark) {
		this.hremark = hremark;
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
		return "Handover [hid=" + hid + ", car=" + car + ", driver=" + driver + ", order1=" + order1 + ", rid=" + rid
				+ ", hfromspname=" + hfromspname + ", htospname=" + htospname + ", hstarttime=" + hstarttime
				+ ", hendtime=" + hendtime + ", hstatus=" + hstatus + ", hremark=" + hremark + ", remark1=" + remark1
				+ ", remark2=" + remark2 + ", remark3=" + remark3 + ", remark4=" + remark4 + ", remark5=" + remark5
				+ "]";
	}
    
}