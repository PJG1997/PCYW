package com.yc.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(value = {"handler"})
public class Order1 implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2727980301632331156L;

	private Integer osid;			//订单编号ID
    private Users users;			//用户对象
    private Shippoint shipPoint;	//配送点对象			
    private String osendname;		//寄件人姓名
    private String osendtel;		//寄件人电话、
    private String osendaddress;	//寄件人地址、
    private String orecname;		//收件人姓名，
    private String orectel;			//收件人电话、
    private String orecaddress;		//收件人地址
    private String oreccode;		//收件人邮编
    private String orecphone;		//收件人手机号码
    private Date otime;				//订单日期	(默认值)
    private Double oprice;			//配送费
    private Double oinsureprice;	//保价金额
    private Integer otype;			//订单类型（0快件，1慢件，2大宗）(默认值)
    private Integer ostatus;		//订单状态（0未发件，1已发件，2已送达，3已签收，4已召回，5已撤单）
    private Date ostarttime;		//要求启程时间
    private Date oendtime;			//要求到达时间
    private String orecspname;		//接收单位（配送点名）
    private String oremark;			//备注
    private String remark1;			//备用字段1
    private String remark2;			//备用字段2
    private String remark3;			//备用字段3
    private String remark4;			//备用字段4
    private String remark5;			//备用字段5
    
    private String ostarttimeString;
    private String oendtimeString;
    private String otimeString;
    
    private Integer pageNo=0;
    private Integer pageSize=5;
    
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
	private List<Orderinfo> orderinfoList;
    
    private Route route;
    
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public String getOtimeString() {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		if(this.otime!=null){
			this.otimeString=df.format(this.otime);
		}
		return otimeString;
	}
	public void setOtimeString(String otimeString) {
		this.otimeString = otimeString;
	}
	public List<Orderinfo> getOrderinfoList() {
		return orderinfoList;
	}
	public void setOrderinfoList(List<Orderinfo> orderinfoList) {
		this.orderinfoList = orderinfoList;
	}
	public String getOstarttimeString() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		if(this.ostarttime!=null){
			this.ostarttimeString=df.format(this.ostarttime);
		}
		return ostarttimeString;
	}
	public void setOstarttimeString(String ostarttimeString) {
		this.ostarttimeString = ostarttimeString;
	}
	public String getOendtimeString() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		if(this.oendtime!=null){
			this.oendtimeString=df.format(this.oendtime);
		}
		return oendtimeString;
	}
	public void setOendtimeString(String oendtimeString) {
		this.oendtimeString = oendtimeString;
	}
	public Integer getOsid() {
		return osid;
	}
	public void setOsid(Integer osid) {
		this.osid = osid;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Shippoint getShipPoint() {
		return shipPoint;
	}
	public void setShipPoint(Shippoint shipPoint) {
		this.shipPoint = shipPoint;
	}
	public String getOsendname() {
		return osendname;
	}
	public void setOsendname(String osendname) {
		this.osendname = osendname;
	}
	public String getOsendtel() {
		return osendtel;
	}
	public void setOsendtel(String osendtel) {
		this.osendtel = osendtel;
	}
	public String getOsendaddress() {
		return osendaddress;
	}
	public void setOsendaddress(String osendaddress) {
		this.osendaddress = osendaddress;
	}
	public String getOrecname() {
		return orecname;
	}
	public void setOrecname(String orecname) {
		this.orecname = orecname;
	}
	public String getOrectel() {
		return orectel;
	}
	public void setOrectel(String orectel) {
		this.orectel = orectel;
	}
	public String getOrecaddress() {
		return orecaddress;
	}
	public void setOrecaddress(String orecaddress) {
		this.orecaddress = orecaddress;
	}
	public String getOreccode() {
		return oreccode;
	}
	public void setOreccode(String oreccode) {
		this.oreccode = oreccode;
	}
	public String getOrecphone() {
		return orecphone;
	}
	public void setOrecphone(String orecphone) {
		this.orecphone = orecphone;
	}
	public Date getOtime() {
		return otime;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
	}
	public Double getOprice() {
		return oprice;
	}
	public void setOprice(Double oprice) {
		this.oprice = oprice;
	}
	public Double getOinsureprice() {
		return oinsureprice;
	}
	public void setOinsureprice(Double oinsureprice) {
		this.oinsureprice = oinsureprice;
	}
	public Integer getOtype() {
		return otype;
	}
	public void setOtype(Integer otype) {
		this.otype = otype;
	}
	public Integer getOstatus() {
		return ostatus;
	}
	public void setOstatus(Integer ostatus) {
		this.ostatus = ostatus;
	}
	public Date getOstarttime() {
		return ostarttime;
	}
	public void setOstarttime(Date ostarttime) {
		this.ostarttime = ostarttime;
	}
	public Date getOendtime() {
		return oendtime;
	}
	public void setOendtime(Date oendtime) {
		this.oendtime = oendtime;
	}
	public String getOrecspname() {
		return orecspname;
	}
	public void setOrecspname(String orecspname) {
		this.orecspname = orecspname;
	}
	public String getOremark() {
		return oremark;
	}
	public void setOremark(String oremark) {
		this.oremark = oremark;
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
		return "Order1 [osid=" + osid + ", users=" + users + ", shipPoint=" + shipPoint + ", osendname=" + osendname
				+ ", osendtel=" + osendtel + ", osendaddress=" + osendaddress + ", orecname=" + orecname + ", orectel="
				+ orectel + ", orecaddress=" + orecaddress + ", oreccode=" + oreccode + ", orecphone=" + orecphone
				+ ", otime=" + otime + ", oprice=" + oprice + ", oinsureprice=" + oinsureprice + ", otype=" + otype
				+ ", ostatus=" + ostatus + ", ostarttime=" + ostarttime + ", oendtime=" + oendtime + ", orecspname="
				+ orecspname + ", oremark=" + oremark + ", remark1=" + remark1 + ", remark2=" + remark2 + ", remark3="
				+ remark3 + ", remark4=" + remark4 + ", remark5=" + remark5 + ", ostarttimeString=" + ostarttimeString
				+ ", oendtimeString=" + oendtimeString + ", otimeString=" + otimeString + ", orderinfoList="
				+ orderinfoList + ", route=" + route + "]";
	}
	public Order1(Integer osid, Users users, Shippoint shipPoint, String osendname, String osendtel,
			String osendaddress, String orecname, String orectel, String orecaddress, String oreccode, String orecphone,
			Date otime, Double oprice, Double oinsureprice, Integer otype, Integer ostatus, Date ostarttime,
			Date oendtime, String orecspname, String oremark, String remark1, String remark2, String remark3,
			String remark4, String remark5, String ostarttimeString, String oendtimeString, String otimeString,
			Integer pageNo, Integer pageSize, List<Orderinfo> orderinfoList, Route route) {
		super();
		this.osid = osid;
		this.users = users;
		this.shipPoint = shipPoint;
		this.osendname = osendname;
		this.osendtel = osendtel;
		this.osendaddress = osendaddress;
		this.orecname = orecname;
		this.orectel = orectel;
		this.orecaddress = orecaddress;
		this.oreccode = oreccode;
		this.orecphone = orecphone;
		this.otime = otime;
		this.oprice = oprice;
		this.oinsureprice = oinsureprice;
		this.otype = otype;
		this.ostatus = ostatus;
		this.ostarttime = ostarttime;
		this.oendtime = oendtime;
		this.orecspname = orecspname;
		this.oremark = oremark;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.remark3 = remark3;
		this.remark4 = remark4;
		this.remark5 = remark5;
		this.ostarttimeString = ostarttimeString;
		this.oendtimeString = oendtimeString;
		this.otimeString = otimeString;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.orderinfoList = orderinfoList;
		this.route = route;
	}
	public Order1() {
		super();
	}

}