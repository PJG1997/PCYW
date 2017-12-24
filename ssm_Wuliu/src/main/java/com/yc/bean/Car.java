package com.yc.bean;

import java.io.Serializable;
import java.util.Date;



public class Car implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3964367260336633207L;
	private Integer cid ;		//1.	车辆编号
	private String cnumber ;	//2.	车牌号、
	private String ctype ;		//3.	车型、
	private Date cbuyDay ;	//4.	购买日期、
	private String crunNum ;	//5.	营运证号、
	private Double cvolume ;	//6.	容积(m^3)、
	private Double cton ;		//7.	吨位，
	private Integer cstatus ;	//9.	车辆状态(0空闲，1在途中)
	private Integer cisBox ;	//10.	是否箱式(0是 ，1不是)
	private String cremark ;	//11.	备注
	
	private ShipPoint shipPoint;		//8.	所属单位
	
	public Integer getCid() {
		return cid;
	}

	public ShipPoint getShipPoint() {
		return shipPoint;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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

	public Date getCbuyDay() {
		return cbuyDay;
	}

	public void setCbuyDay(Date cbuyDay) {
		this.cbuyDay = cbuyDay;
	}

	public String getCrunNum() {
		return crunNum;
	}

	public void setCrunNum(String crunNum) {
		this.crunNum = crunNum;
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

	public Integer getCisBox() {
		return cisBox;
	}

	public void setCisBox(Integer cisBox) {
		this.cisBox = cisBox;
	}

	public String getCremark() {
		return cremark;
	}

	public void setCremark(String cremark) {
		this.cremark = cremark;
	}

	public void setShipPoint(ShipPoint shipPoint) {
		this.shipPoint = shipPoint;
	}

	public Car() {
		super();
	}

	public Car(String cnumber, String ctype, Date cbuyDay, String crunNum,
			Double cvolume, Double cton, Integer cstatus, Integer cisBox,
			String cremark) {
		super();
		this.cnumber = cnumber;
		this.ctype = ctype;
		this.cbuyDay = cbuyDay;
		this.crunNum = crunNum;
		this.cvolume = cvolume;
		this.cton = cton;
		this.cstatus = cstatus;
		this.cisBox = cisBox;
		this.cremark = cremark;
	}

	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cnumber=" + cnumber + ", ctype=" + ctype
				+ ", cbuyDay=" + cbuyDay + ", crunNum=" + crunNum
				+ ", cvolume=" + cvolume + ", cton=" + cton + ", cstatus="
				+ cstatus + ", cisBox=" + cisBox + ", cremark=" + cremark + "]";
	}

	public Car(Integer cid) {
		super();
		this.cid = cid;
	}

	
	
	

	

}
