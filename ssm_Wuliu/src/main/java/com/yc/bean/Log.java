package com.yc.bean;

import java.io.Serializable;
import java.sql.Date;

public class Log implements Serializable{

	
	private static final long serialVersionUID = -6259039293194918031L;
	
	private Integer lid;
	private Integer lusid;
	private String luname;
	private Date ldate;
	private String lopreation;
	
	
	private Integer pageNo;
	private Integer pageSize;
	
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getLusid() {
		return lusid;
	}
	public void setLusid(Integer lusid) {
		this.lusid = lusid;
	}
	public String getLuname() {
		return luname;
	}
	public void setLuname(String luname) {
		this.luname = luname;
	}
	public Date getLdate() {
		return ldate;
	}
	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}
	public String getLopreation() {
		return lopreation;
	}
	public void setLopreation(String lopreation) {
		this.lopreation = lopreation;
	}
	
	
	
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
	@Override
	public String toString() {
		return "Log [lid=" + lid + ", lusid=" + lusid + ", luname=" + luname + ", ldate=" + ldate + ", lopreation="
				+ lopreation + "]";
	}
	
	
	

}
