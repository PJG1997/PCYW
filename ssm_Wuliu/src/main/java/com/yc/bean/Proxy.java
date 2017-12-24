package com.yc.bean;

import java.io.Serializable;


public class Proxy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8247372104663009791L;
	private Integer prid; 
	private String  prname; 
	private String  prtime; //工作时间
	private Double  prprice; 
	private String  prremark; 
	
	private ShipPoint shipPoint;

	public Integer getPrid() {
		return prid;
	}
	
	public ShipPoint getShipPoint() {
		return shipPoint;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public String getPrname() {
		return prname;
	}

	public void setPrname(String prname) {
		this.prname = prname;
	}
	public String getPrtime() {
		return prtime;
	}

	public void setPrtime(String prtime) {
		this.prtime = prtime;
	}

	public Double getPrprice() {
		return prprice;
	}

	public void setPrprice(Double prprice) {
		this.prprice = prprice;
	}

	public String getPrremark() {
		return prremark;
	}

	public void setPrremark(String prremark) {
		this.prremark = prremark;
	}


	public void setShipPoint(ShipPoint shipPoint) {
		this.shipPoint = shipPoint;
	}

	@Override
	public String toString() {
		return "Proxy [prid=" + prid + ", prname=" + prname + ", prprice="
				+ prprice + ", prremark=" + prremark + ", prtime=" + prtime
				+ ", shipPoint=" + shipPoint + "]";
	}

	public Proxy( String prname, String prtime, Double prprice,
			String prremark) {
		super();
		this.prname = prname;
		this.prtime = prtime;
		this.prprice = prprice;
		this.prremark = prremark;
		
	}

	public Proxy() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prid == null) ? 0 : prid.hashCode());
		result = prime * result + ((prname == null) ? 0 : prname.hashCode());
		result = prime * result + ((prprice == null) ? 0 : prprice.hashCode());
		result = prime * result
				+ ((prremark == null) ? 0 : prremark.hashCode());
		result = prime * result + ((prtime == null) ? 0 : prtime.hashCode());
		result = prime * result
				+ ((shipPoint == null) ? 0 : shipPoint.hashCode());
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
		Proxy other = (Proxy) obj;
		if (prid == null) {
			if (other.prid != null)
				return false;
		} else if (!prid.equals(other.prid))
			return false;
		if (prname == null) {
			if (other.prname != null)
				return false;
		} else if (!prname.equals(other.prname))
			return false;
		if (prprice == null) {
			if (other.prprice != null)
				return false;
		} else if (!prprice.equals(other.prprice))
			return false;
		if (prremark == null) {
			if (other.prremark != null)
				return false;
		} else if (!prremark.equals(other.prremark))
			return false;
		if (prtime == null) {
			if (other.prtime != null)
				return false;
		} else if (!prtime.equals(other.prtime))
			return false;
		if (shipPoint == null) {
			if (other.shipPoint != null)
				return false;
		} else if (!shipPoint.equals(other.shipPoint))
			return false;
		return true;
	}
	
	
	 
	
	
	
}
