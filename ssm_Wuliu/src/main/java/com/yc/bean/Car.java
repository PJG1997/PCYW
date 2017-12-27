package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable{
	private static final long serialVersionUID = -4324820907252232217L;
	
	
	private Integer cid;			//汽车id
    private Shippoint shipPoint;	//配送点的对象
    private String cnumber;			//车牌号
    private String ctype;			//汽车类型
    private Date cbuyday;			//购买日期、
    private String crunnum;			//营运证号、
    private Double cvolume;			//容积(m^3)、
    private Double cton;			//吨位
    private Integer cstatus;		//车辆状态(0空闲，1在途中)
    private Integer cisbox;			//是否箱式(0是 ，1不是)
    private String cremake;			//备注
    private String remark1;			//备用字段1
    private String remark2;			//备用字段2
    private String remark3;			//备用字段3
    private String remark4;			//备用字段4
    private String remark5;			//备用字段5
    
    private Double mincvolume;     //最小容量
    private Double maxcvolume;     //最大容量
    private Double mincton;        //最小吨位
    private Double maxcton;        //最大吨位
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Shippoint getShipPoint() {
		return shipPoint;
	}
	public void setShipPoint(Shippoint shipPoint) {
		this.shipPoint = shipPoint;
	}
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public Date getCbuyday() {
		return cbuyday;
	}
	public void setCbuyday(Date cbuyday) {
		this.cbuyday = cbuyday;
	}
	public String getCrunnum() {
		return crunnum;
	}
	public void setCrunnum(String crunnum) {
		this.crunnum = crunnum;
	}
	public Double getCvolume() {
		return cvolume;
	}
	public void setCvolume(Double cvolume) {
		this.cvolume = cvolume;
	}
	public Double getCton() {
		return cton;
	}
	public void setCton(Double cton) {
		this.cton = cton;
	}
	public Integer getCstatus() {
		return cstatus;
	}
	public void setCstatus(Integer cstatus) {
		this.cstatus = cstatus;
	}
	public Integer getCisbox() {
		return cisbox;
	}
	public void setCisbox(Integer cisbox) {
		this.cisbox = cisbox;
	}
	public String getCremake() {
		return cremake;
	}
	public void setCremake(String cremake) {
		this.cremake = cremake;
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
	public Double getMincvolume() {
		return mincvolume;
	}
	public void setMincvolume(Double mincvolume) {
		this.mincvolume = mincvolume;
	}
	public Double getMaxcvolume() {
		return maxcvolume;
	}
	public void setMaxcvolume(Double maxcvolume) {
		this.maxcvolume = maxcvolume;
	}
	public Double getMincton() {
		return mincton;
	}
	public void setMincton(Double mincton) {
		this.mincton = mincton;
	}
	public Double getMaxcton() {
		return maxcton;
	}
	public void setMaxcton(Double maxcton) {
		this.maxcton = maxcton;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Car [cid=" + cid + ", shipPoint=" + shipPoint + ", cnumber=" + cnumber + ", ctype=" + ctype
				+ ", cbuyday=" + cbuyday + ", crunnum=" + crunnum + ", cvolume=" + cvolume + ", cton=" + cton
				+ ", cstatus=" + cstatus + ", cisbox=" + cisbox + ", cremake=" + cremake + ", remark1=" + remark1
				+ ", remark2=" + remark2 + ", remark3=" + remark3 + ", remark4=" + remark4 + ", remark5=" + remark5
				+ ", mincvolume=" + mincvolume + ", maxcvolume=" + maxcvolume + ", mincton=" + mincton + ", maxcton="
				+ maxcton + "]";
	}
	
	
}