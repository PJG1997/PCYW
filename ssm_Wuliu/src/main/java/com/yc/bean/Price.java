package com.yc.bean;

import java.io.Serializable;


public class Price implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8040008736997713654L;
	private Integer pid;		//价格编号
	private String pfrom;		//起始地址
	private String pto;			//终点地址
	private Double pfirstwei;	//首重价格
	private Double prestwei;	//次重价格
	private Double pfirstvol;	//首立方价格
	private Double prestvol;	//次立方价格
	private String pretime;		//预计时间

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
	
	
//	private String p1;
//	private String p2;
//	private String p3;
//	private String p4;
	
	
	
}
