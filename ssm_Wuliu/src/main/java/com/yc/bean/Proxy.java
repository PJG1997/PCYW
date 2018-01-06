package com.yc.bean;

import java.io.Serializable;

public class Proxy implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7223050574951984236L;

	private Integer prid;		//代理ID
    private String prname;		//代理名字
    private String prtime;		//代理的工作时间
    private Double prprice;		//代理价格
    private Shippoint shipPoint; //配送点对象
    private String prremark;	//配注
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
    
    private Integer pageNo;
    private Integer pageSize;
    
    
    
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	public String getPrtime() {
		return prtime;
	}
	public void setPrtime(String prtime) {
		this.prtime = prtime;
	}
	public Double getPrprice() {
		return prprice;
	}
	public void setPrprice(Double prprice) {
		this.prprice = prprice;
	}
	public Shippoint getShippoint() {
		return shipPoint;
	}
	public void setShippoint(Shippoint shipPoint) {
		this.shipPoint = shipPoint;
	}
	public String getPrremark() {
		return prremark;
	}
	public void setPrremark(String prremark) {
		this.prremark = prremark;
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
		return "Proxy [prid=" + prid + ", prname=" + prname + ", prtime=" + prtime + ", prprice=" + prprice
				+ ", shippoint=" + shipPoint + ", prremark=" + prremark + ", remark1=" + remark1 + ", remark2="
				+ remark2 + ", remark3=" + remark3 + ", remark4=" + remark4 + ", remark5=" + remark5 + ", pageNo="
				+ pageNo + ", pageSize=" + pageSize + "]";
	}
}