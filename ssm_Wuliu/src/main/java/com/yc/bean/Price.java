package com.yc.bean;

import java.io.Serializable;

public class Price implements Serializable{
	private static final long serialVersionUID = -4364751437416888298L;
	
	private Integer pid;		//价格编号
    private String pfrom;		//起始地址
    private String pto;			//终点地址
    private Double pfirstwei;	//首重价格
    private Double prestwei;	//次重价格
    private Double pfirstvol;	//首立方价格
    private Double prestvol;	//次立方价格
    private String pretime;		//预计时间
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPfrom() {
		return pfrom;
	}
	public void setPfrom(String pfrom) {
		this.pfrom = pfrom;
	}
	public String getPto() {
		return pto;
	}
	public void setPto(String pto) {
		this.pto = pto;
	}
	public Double getPfirstwei() {
		return pfirstwei;
	}
	public void setPfirstwei(Double pfirstwei) {
		this.pfirstwei = pfirstwei;
	}
	public Double getPrestwei() {
		return prestwei;
	}
	public void setPrestwei(Double prestwei) {
		this.prestwei = prestwei;
	}
	public Double getPfirstvol() {
		return pfirstvol;
	}
	public void setPfirstvol(Double pfirstvol) {
		this.pfirstvol = pfirstvol;
	}
	public Double getPrestvol() {
		return prestvol;
	}
	public void setPrestvol(Double prestvol) {
		this.prestvol = prestvol;
	}
	public String getPretime() {
		return pretime;
	}
	public void setPretime(String pretime) {
		this.pretime = pretime;
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
		return "Price [pid=" + pid + ", pfrom=" + pfrom + ", pto=" + pto + ", pfirstwei=" + pfirstwei + ", prestwei="
				+ prestwei + ", pfirstvol=" + pfirstvol + ", prestvol=" + prestvol + ", pretime=" + pretime
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + ", remark3=" + remark3 + ", remark4=" + remark4
				+ ", remark5=" + remark5 + "]";
	}

}