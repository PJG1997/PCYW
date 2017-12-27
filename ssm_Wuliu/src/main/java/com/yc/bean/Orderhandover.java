package com.yc.bean;

import java.io.Serializable;

public class Orderhandover implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5535999907557184226L;

	private Integer ohid;		//订单与交接表的关联ID
    private Integer hid;		//交接表ID
    private Integer osid;		//订单ID
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
	public Integer getOhid() {
		return ohid;
	}
	public void setOhid(Integer ohid) {
		this.ohid = ohid;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public Integer getOsid() {
		return osid;
	}
	public void setOsid(Integer osid) {
		this.osid = osid;
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
		return "Orderhandover [ohid=" + ohid + ", hid=" + hid + ", osid=" + osid + ", remark1=" + remark1 + ", remark2="
				+ remark2 + ", remark3=" + remark3 + ", remark4=" + remark4 + ", remark5=" + remark5 + "]";
	}

}