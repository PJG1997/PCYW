package com.yc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class ShipPoint implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9086539212232887894L;
	private Integer spid ; 		//	配送ID
	private String spname;		//	配送点名称
	private String spperson;	//	联系人
	private String sptel;		//	配送点电话、
	private String spemail;		//	联系EMail、
	private String spaddress;	//	配送点地址、
	private Integer spType;		//	配送点类型、(0 配送点,1 代理点)
	private String sppersonTel;	//	联系人电话、
	private String spfax;		//	配送点传真
	private String sparea;		//	配送点范围
	private String spremark;	//	备注
	
	private List<Car> cars = new ArrayList<Car>();
	private List<Driver> drivers = new ArrayList<Driver>();
	private List<Order1> orders = new ArrayList<Order1>();
	private List<Proxy> proxy=new ArrayList<Proxy>();

	

	public Integer getSpid() {
		return spid;
	}
	
	public List<Car> getCars() {
		return cars;
	}
	
	public List<Driver> getDrivers() {
		return drivers;
	}
	
	public List<Order1> getOrders() {
		return orders;
	}
	public List<Proxy> getProxy() {
		return proxy;
	}

	public void setProxy(List<Proxy> proxy) {
		this.proxy = proxy;
	}

	public void setOrders(List<Order1> orders) {
		this.orders = orders;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
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

	public Integer getSpType() {
		return spType;
	}

	public void setSpType(Integer spType) {
		this.spType = spType;
	}

	public String getSppersonTel() {
		return sppersonTel;
	}

	public void setSppersonTel(String sppersonTel) {
		this.sppersonTel = sppersonTel;
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


	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public ShipPoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShipPoint(String spname, String spperson, String sptel,
			String spemail, String spaddress, Integer spType,
			String sppersonTel, String spfax, String sparea, String spremark) {
		super();
		this.spname = spname;
		this.spperson = spperson;
		this.sptel = sptel;
		this.spemail = spemail;
		this.spaddress = spaddress;
		this.spType = spType;
		this.sppersonTel = sppersonTel;
		this.spfax = spfax;
		this.sparea = sparea;
		this.spremark = spremark;
	}

	@Override
	public String toString() {
		return "ShipPoint [spid=" + spid + ", spname=" + spname + ", spperson="
				+ spperson + ", sptel=" + sptel + ", spemail=" + spemail
				+ ", spaddress=" + spaddress + ", spType=" + spType
				+ ", sppersonTel=" + sppersonTel + ", spfax=" + spfax
				+ ", sparea=" + sparea + ", spremark=" + spremark + "]";
	}

	public ShipPoint(Integer spid) {
		super();
		this.spid = spid;
	}
	
	
	
//	private String sp1;
//	private String sp2;
//	private String sp3;
//	private String sp4;
	
	
	
	
}
