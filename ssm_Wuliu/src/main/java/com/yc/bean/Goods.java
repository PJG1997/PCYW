package com.yc.bean;

import java.io.Serializable;

public class Goods implements Serializable{
	private static final long serialVersionUID = 6654135569000142393L;
	
	private Integer gid;		//货物编码
    private String gname;		//货物名称
    private String gcount;		//货物数量
    private Double gprice;		//货品价值
    private Double gweight;		//货物重量(kg)
    private Double gvolume;		//货物体积(m^3)
    private String gtype;		//货物类别
    private String gremark;		//备注
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
    
    private Double mingprice;
    private Double maxgprice;
    private Double mingweight;
    private Double maxgweight;
    private Double mingvolume;
    private Double maxgvolume;
    
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
	public Double getMingprice() {
		return mingprice;
	}
	public void setMingprice(Double mingprice) {
		this.mingprice = mingprice;
	}
	public Double getMaxgprice() {
		return maxgprice;
	}
	public void setMaxgprice(Double maxgprice) {
		this.maxgprice = maxgprice;
	}
	public Double getMingweight() {
		return mingweight;
	}
	public void setMingweight(Double mingweight) {
		this.mingweight = mingweight;
	}
	public Double getMaxgweight() {
		return maxgweight;
	}
	public void setMaxgweight(Double maxgweight) {
		this.maxgweight = maxgweight;
	}
	public Double getMingvolume() {
		return mingvolume;
	}
	public void setMingvolume(Double mingvolume) {
		this.mingvolume = mingvolume;
	}
	public Double getMaxgvolume() {
		return maxgvolume;
	}
	public void setMaxgvolume(Double maxgvolume) {
		this.maxgvolume = maxgvolume;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGcount() {
		return gcount;
	}
	public void setGcount(String gcount) {
		this.gcount = gcount;
	}
	public Double getGprice() {
		return gprice;
	}
	public void setGprice(Double gprice) {
		this.gprice = gprice;
	}
	public Double getGweight() {
		return gweight;
	}
	public void setGweight(Double gweight) {
		this.gweight = gweight;
	}
	public Double getGvolume() {
		return gvolume;
	}
	public void setGvolume(Double gvolume) {
		this.gvolume = gvolume;
	}
	public String getGtype() {
		return gtype;
	}
	public void setGtype(String gtype) {
		this.gtype = gtype;
	}
	public String getGremark() {
		return gremark;
	}
	public void setGremark(String gremark) {
		this.gremark = gremark;
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
		return "Goods [gid=" + gid + ", gname=" + gname + ", gcount=" + gcount + ", gprice=" + gprice + ", gweight="
				+ gweight + ", gvolume=" + gvolume + ", gtype=" + gtype + ", gremark=" + gremark + ", remark1="
				+ remark1 + ", remark2=" + remark2 + ", remark3=" + remark3 + ", remark4=" + remark4 + ", remark5="
				+ remark5 + ", mingprice=" + mingprice + ", maxgprice=" + maxgprice + ", mingweight=" + mingweight
				+ ", maxgweight=" + maxgweight + ", mingvolume=" + mingvolume + ", maxgvolume=" + maxgvolume
				+ ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}

}