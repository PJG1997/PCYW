package com.yc.bean;

import java.io.Serializable;

public class Orderinfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4426195307488140749L;

	private Integer oiid;	//订单详细表ID
    private Order1 order1;	//订单对象
    private String gname;	//商品名
    private Double gprice;	//商品价格
    private Integer gcount;	//商品数量
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
	public Integer getOiid() {
		return oiid;
	}
	public void setOiid(Integer oiid) {
		this.oiid = oiid;
	}
	public Order1 getOrder1() {
		return order1;
	}
	public void setOrder1(Order1 order1) {
		this.order1 = order1;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Double getGprice() {
		return gprice;
	}
	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}
	public Integer getGcount() {
		return gcount;
	}
	public void setGcount(Integer gcount) {
		this.gcount = gcount;
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
		return "Orderinfo [oiid=" + oiid + ", order1=" + order1 + ", gname=" + gname + ", gprice=" + gprice
				+ ", gcount=" + gcount + ", remark1=" + remark1 + ", remark2=" + remark2 + ", remark3=" + remark3
				+ ", remark4=" + remark4 + ", remark5=" + remark5 + "]";
	}

}