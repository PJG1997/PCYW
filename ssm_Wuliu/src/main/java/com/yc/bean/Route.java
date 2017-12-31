package com.yc.bean;

import java.io.Serializable;

public class Route implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8032440985733757540L;
	
	private Integer rid;		//线路ID
    private String rname;		//线路名称、
    private String rvia;		//配送路线顺序
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
    
    
    //分页
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
		return "Route [rid=" + rid + ", rname=" + rname + ", rvia=" + rvia + ", remark1=" + remark1 + ", remark2="
				+ remark2 + ", remark3=" + remark3 + ", remark4=" + remark4 + ", remark5=" + remark5 + ", pageNo="
				+ pageNo + ", pageSize=" + pageSize + "]";
	}

}