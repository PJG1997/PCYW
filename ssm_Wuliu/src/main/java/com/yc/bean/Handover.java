package com.yc.bean;

import java.io.Serializable;
import java.util.Date;



public class Handover  implements Serializable {		//交接表

	/**
	 * 
	 */
	private static final long serialVersionUID = 2545682752390473818L;
	private Integer hid;
	private String hfromSpname;	//起始配送点名称
	private String htoSpname;	//到达配送点名称
	private Date hstartTime;     //起始时间
	private Date hendTime;   	//到达时间
	private Integer hstatus;	//交接单状态（默认状态0）。0未发车，1已发车，2已完成
	private String hremark;//备注
	
	private Car car;
	private Driver driver;
	private Order order;
	private Route route;
	public Integer getHid() {
		return hid;
	}
	
	public Car getCar() {
		return car;
	}
	
	public Driver getDriver() {
		return driver;
	}

	//由交接单维护关联
	public Order getOrder() {
		return order;
	}
	
	public Route getRoute() {
		return route;
	}
	
	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getHremark() {
		return hremark;
	}

	public void setHremark(String hremark) {
		this.hremark = hremark;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Handover() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getHfromSpname() {
		return hfromSpname;
	}

	public void setHfromSpname(String hfromSpname) {
		this.hfromSpname = hfromSpname;
	}

	public String getHtoSpname() {
		return htoSpname;
	}

	public void setHtoSpname(String htoSpname) {
		this.htoSpname = htoSpname;
	}

	public Date getHstartTime() {
		return hstartTime;
	}

	public void setHstartTime(Date hstartTime) {
		this.hstartTime = hstartTime;
	}

	public Date getHendTime() {
		return hendTime;
	}

	public void setHendTime(Date hendTime) {
		this.hendTime = hendTime;
	}
	
	public Integer getHstatus() {
		return hstatus;
	}

	public void setHstatus(Integer hstatus) {
		this.hstatus = hstatus;
	}

	public Handover(String hfromSpname, String htoSpname, Date hstartTime,
			Date hendTime, Integer hstatus, String hremark) {
		super();
		this.hfromSpname = hfromSpname;
		this.htoSpname = htoSpname;
		this.hstartTime = hstartTime;
		this.hendTime = hendTime;
		this.hstatus = hstatus;
		this.hremark = hremark;
	}

	@Override
	public String toString() {
		return "Handover [hendTime=" + hendTime + ", hfromSpname="
				+ hfromSpname + ", hid=" + hid + ", hremark=" + hremark
				+ ", hstartTime=" + hstartTime + ", hstatus=" + hstatus
				+ ", htoSpname=" + htoSpname + "]";
	}
	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((driver == null) ? 0 : driver.hashCode());
		result = prime * result
				+ ((hendTime == null) ? 0 : hendTime.hashCode());
		result = prime * result
				+ ((hfromSpname == null) ? 0 : hfromSpname.hashCode());
		result = prime * result + ((hid == null) ? 0 : hid.hashCode());
		result = prime * result + ((hremark == null) ? 0 : hremark.hashCode());
		result = prime * result
				+ ((hstartTime == null) ? 0 : hstartTime.hashCode());
		result = prime * result + ((hstatus == null) ? 0 : hstatus.hashCode());
		result = prime * result
				+ ((htoSpname == null) ? 0 : htoSpname.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Handover other = (Handover) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (driver == null) {
			if (other.driver != null)
				return false;
		} else if (!driver.equals(other.driver))
			return false;
		if (hendTime == null) {
			if (other.hendTime != null)
				return false;
		} else if (!hendTime.equals(other.hendTime))
			return false;
		if (hfromSpname == null) {
			if (other.hfromSpname != null)
				return false;
		} else if (!hfromSpname.equals(other.hfromSpname))
			return false;
		if (hid == null) {
			if (other.hid != null)
				return false;
		} else if (!hid.equals(other.hid))
			return false;
		if (hremark == null) {
			if (other.hremark != null)
				return false;
		} else if (!hremark.equals(other.hremark))
			return false;
		if (hstartTime == null) {
			if (other.hstartTime != null)
				return false;
		} else if (!hstartTime.equals(other.hstartTime))
			return false;
		if (hstatus == null) {
			if (other.hstatus != null)
				return false;
		} else if (!hstatus.equals(other.hstatus))
			return false;
		if (htoSpname == null) {
			if (other.htoSpname != null)
				return false;
		} else if (!htoSpname.equals(other.htoSpname))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		return true;
	}

	
	
}
