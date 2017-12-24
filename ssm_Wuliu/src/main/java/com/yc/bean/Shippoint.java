package com.yc.bean;

import java.io.Serializable;

public class Shippoint implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8413773576260310885L;
	
	private Integer spid;		//	配送ID
    private String spanme;		//	配送点名称
    private String spperson;	//	联系人
    private String sptel;		//	配送点电话、
    private String spemail;		//	联系EMail、
    private String spaddress;	//	配送点地址、
    private Integer sptype;		//	配送点类型、(0 配送点,1 代理点)
    private String sppersontel;	//	联系人电话、
    private String spfax;		//	配送点传真
    private String sparea;		//	配送点范围
    private String spremark;	//	备注
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
	public Integer getSpid() {
		return spid;
	}
	public void setSpid(Integer spid) {
		this.spid = spid;
	}
	public String getSpanme() {
		return spanme;
	}
	public void setSpanme(String spanme) {
		this.spanme = spanme;
	}
	public String getSpperson() {
		return spperson;
	}
	public void setSpperson(String spperson) {
		this.spperson = spperson;
	}
	public String getSptel() {
		return sptel;
	}
	public void setSptel(String sptel) {
		this.sptel = sptel;
	}
	public String getSpemail() {
		return spemail;
	}
	public void setSpemail(String spemail) {
		this.spemail = spemail;
	}
	public String getSpaddress() {
		return spaddress;
	}
	public void setSpaddress(String spaddress) {
		this.spaddress = spaddress;
	}
	public Integer getSptype() {
		return sptype;
	}
	public void setSptype(Integer sptype) {
		this.sptype = sptype;
	}
	public String getSppersontel() {
		return sppersontel;
	}
	public void setSppersontel(String sppersontel) {
		this.sppersontel = sppersontel;
	}
	public String getSpfax() {
		return spfax;
	}
	public void setSpfax(String spfax) {
		this.spfax = spfax;
	}
	public String getSparea() {
		return sparea;
	}
	public void setSparea(String sparea) {
		this.sparea = sparea;
	}
	public String getSpremark() {
		return spremark;
	}
	public void setSpremark(String spremark) {
		this.spremark = spremark;
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
		return "Shippoint [spid=" + spid + ", spanme=" + spanme + ", spperson=" + spperson + ", sptel=" + sptel
				+ ", spemail=" + spemail + ", spaddress=" + spaddress + ", sptype=" + sptype + ", sppersontel="
				+ sppersontel + ", spfax=" + spfax + ", sparea=" + sparea + ", spremark=" + spremark + ", remark1="
				+ remark1 + ", remark2=" + remark2 + ", remark3=" + remark3 + ", remark4=" + remark4 + ", remark5="
				+ remark5 + "]";
	}

}