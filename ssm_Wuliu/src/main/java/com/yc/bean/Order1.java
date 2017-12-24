package com.yc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Order1 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8731030263572964318L;
	private Integer osid;//1.	订单编号ID
	private String osendName;//3.	寄件人姓名
	private String osendTel;//4.	寄件人电话、
	private String osendAddress;//5.	寄件人地址、
	private String orecName;//6.	收件人姓名，
	private String orecTel;//7.	收件人电话、
	private String orecAddress;//8.	收件人地址
	private String orecCode;//9.	收件人邮编
	private String orecPhone;//10.	收件人手机号码
	private Date otime;//12.	订单日期	(默认值)
	private Double oprice;//13.	配送费
	private Double oinsurePrice;//14.	保价金额
	private Integer otype;//15.	订单类型（0快件，1慢件，2大宗）(默认值)
	private Integer ostatus;//16.	订单状态（0未发件，1已发件，2已送达，3已签收，4已召回，5已撤单）
	private Date ostartTime;//17.	要求启程时间
	private Date oendTime;//18.	要求到达时间
	private String orecSpname;	//接收单位（配送点名）
	private String oremark;//19.	备注
	
    private Users user;
    private ShipPoint shipPoint;
	private List<Goods> goodss = new ArrayList<Goods>();
    private List<Handover> handover = new ArrayList<Handover>();
    
    //新加的字段，便于统计
	private double o1;
	private double o2;
	private double o3;
	private double o4;
	private double o5;
	private double o6;
    
    
	public Integer getOsid() {
		return osid;
	}

	public Users getUser() {
		return user;
	}
	
	public List<Goods> getGoodss() {
		return goodss;
	}
	
	/**
	 * 两个实体类的关联由order表中的osid来维护
	 * @return
	 */
	public List<Handover> getHandover() {
		return handover;
	}
	
    public ShipPoint getShipPoint() {
		return shipPoint;
	}
    
	public void setOsid(Integer osid) {
		this.osid = osid;
	}

	public String getOsendName() {
		return osendName;
	}

	public void setOsendName(String osendName) {
		this.osendName = osendName;
	}


	public void setShipPoint(ShipPoint shipPoint) {
		this.shipPoint = shipPoint;
	}

	public String getOrecName() {
		return orecName;
	}

	public void setOrecName(String orecName) {
		this.orecName = orecName;
	}

	public String getOrecTel() {
		return orecTel;
	}

	public void setOrecTel(String orecTel) {
		this.orecTel = orecTel;
	}

	public String getOrecAddress() {
		return orecAddress;
	}

	public void setOrecAddress(String orecAddress) {
		this.orecAddress = orecAddress;
	}

	public String getOrecCode() {
		return orecCode;
	}

	public void setOrecCode(String orecCode) {
		this.orecCode = orecCode;
	}

	public String getOrecPhone() {
		return orecPhone;
	}

	public void setOrecPhone(String orecPhone) {
		this.orecPhone = orecPhone;
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

	public Double getOinsurePrice() {
		return oinsurePrice;
	}

	public void setOinsurePrice(Double oinsurePrice) {
		this.oinsurePrice = oinsurePrice;
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

	public Date getOstartTime() {
		return ostartTime;
	}

	public void setOstartTime(Date ostartTime) {
		this.ostartTime = ostartTime;
	}

	public Date getOendTime() {
		return oendTime;
	}

	public void setOendTime(Date oendTime) {
		this.oendTime = oendTime;
	}

	public String getOremark() {
		return oremark;
	}

	public void setOremark(String oremark) {
		this.oremark = oremark;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setGoodss(List<Goods> goodss) {
		this.goodss = goodss;
	}

	public void setHandover(List<Handover> handover) {
		this.handover = handover;
	}
	
	public String getOrecSpname() {
		return orecSpname;
	}

	public void setOrecSpname(String orecSpname) {
		this.orecSpname = orecSpname;
	}

	public Order1() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [goodss=" + goodss + ", handover=" + handover
				+ ", oendTime=" + oendTime + ", oinsurePrice=" + oinsurePrice
				+ ", oprice=" + oprice + ", orecAddress=" + orecAddress
				+ ", orecCode=" + orecCode + ", orecName=" + orecName
				+ ", orecPhone=" + orecPhone + ", orecSpname=" + orecSpname
				+ ", orecTel=" + orecTel + ", oremark=" + oremark
				+ ", osendName=" + osendName + ", osid=" + osid
				+ ", ostartTime=" + ostartTime + ", ostatus=" + ostatus
				+ ", otime=" + otime + ", otype=" + otype + ", shipPoint="
				+ shipPoint + ", user=" + user + "]";
	}

	public Order1(String osendName, String orecName, String orecTel,
			String orecAddress, String orecCode, String orecPhone, Date otime,
			Double oprice, Double oinsurePrice, Integer otype, Integer ostatus,
			Date ostartTime, Date oendTime, String orecSpname, String oremark) {
		super();
		this.osendName = osendName;
		this.orecName = orecName;
		this.orecTel = orecTel;
		this.orecAddress = orecAddress;
		this.orecCode = orecCode;
		this.orecPhone = orecPhone;
		this.otime = otime;
		this.oprice = oprice;
		this.oinsurePrice = oinsurePrice;
		this.otype = otype;
		this.ostatus = ostatus;
		this.ostartTime = ostartTime;
		this.oendTime = oendTime;
		this.orecSpname = orecSpname;
		this.oremark = oremark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodss == null) ? 0 : goodss.hashCode());
		result = prime * result
				+ ((handover == null) ? 0 : handover.hashCode());
		result = prime * result
				+ ((oendTime == null) ? 0 : oendTime.hashCode());
		result = prime * result
				+ ((oinsurePrice == null) ? 0 : oinsurePrice.hashCode());
		result = prime * result + ((oprice == null) ? 0 : oprice.hashCode());
		result = prime * result
				+ ((orecAddress == null) ? 0 : orecAddress.hashCode());
		result = prime * result
				+ ((orecCode == null) ? 0 : orecCode.hashCode());
		result = prime * result
				+ ((orecName == null) ? 0 : orecName.hashCode());
		result = prime * result
				+ ((orecPhone == null) ? 0 : orecPhone.hashCode());
		result = prime * result
				+ ((orecSpname == null) ? 0 : orecSpname.hashCode());
		result = prime * result + ((orecTel == null) ? 0 : orecTel.hashCode());
		result = prime * result + ((oremark == null) ? 0 : oremark.hashCode());
		result = prime * result
				+ ((osendName == null) ? 0 : osendName.hashCode());
		result = prime * result + ((osid == null) ? 0 : osid.hashCode());
		result = prime * result
				+ ((ostartTime == null) ? 0 : ostartTime.hashCode());
		result = prime * result + ((ostatus == null) ? 0 : ostatus.hashCode());
		result = prime * result + ((otime == null) ? 0 : otime.hashCode());
		result = prime * result + ((otype == null) ? 0 : otype.hashCode());
		result = prime * result
				+ ((shipPoint == null) ? 0 : shipPoint.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order1 other = (Order1) obj;
		if (goodss == null) {
			if (other.goodss != null)
				return false;
		} else if (!goodss.equals(other.goodss))
			return false;
		if (handover == null) {
			if (other.handover != null)
				return false;
		} else if (!handover.equals(other.handover))
			return false;
		if (oendTime == null) {
			if (other.oendTime != null)
				return false;
		} else if (!oendTime.equals(other.oendTime))
			return false;
		if (oinsurePrice == null) {
			if (other.oinsurePrice != null)
				return false;
		} else if (!oinsurePrice.equals(other.oinsurePrice))
			return false;
		if (oprice == null) {
			if (other.oprice != null)
				return false;
		} else if (!oprice.equals(other.oprice))
			return false;
		if (orecAddress == null) {
			if (other.orecAddress != null)
				return false;
		} else if (!orecAddress.equals(other.orecAddress))
			return false;
		if (orecCode == null) {
			if (other.orecCode != null)
				return false;
		} else if (!orecCode.equals(other.orecCode))
			return false;
		if (orecName == null) {
			if (other.orecName != null)
				return false;
		} else if (!orecName.equals(other.orecName))
			return false;
		if (orecPhone == null) {
			if (other.orecPhone != null)
				return false;
		} else if (!orecPhone.equals(other.orecPhone))
			return false;
		if (orecSpname == null) {
			if (other.orecSpname != null)
				return false;
		} else if (!orecSpname.equals(other.orecSpname))
			return false;
		if (orecTel == null) {
			if (other.orecTel != null)
				return false;
		} else if (!orecTel.equals(other.orecTel))
			return false;
		if (oremark == null) {
			if (other.oremark != null)
				return false;
		} else if (!oremark.equals(other.oremark))
			return false;
		if (osendName == null) {
			if (other.osendName != null)
				return false;
		} else if (!osendName.equals(other.osendName))
			return false;
		if (osid == null) {
			if (other.osid != null)
				return false;
		} else if (!osid.equals(other.osid))
			return false;
		if (ostartTime == null) {
			if (other.ostartTime != null)
				return false;
		} else if (!ostartTime.equals(other.ostartTime))
			return false;
		if (ostatus == null) {
			if (other.ostatus != null)
				return false;
		} else if (!ostatus.equals(other.ostatus))
			return false;
		if (otime == null) {
			if (other.otime != null)
				return false;
		} else if (!otime.equals(other.otime))
			return false;
		if (otype == null) {
			if (other.otype != null)
				return false;
		} else if (!otype.equals(other.otype))
			return false;
		if (shipPoint == null) {
			if (other.shipPoint != null)
				return false;
		} else if (!shipPoint.equals(other.shipPoint))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public double getO1() {
		return o1;
	}

	public void setO1(double o1) {
		this.o1 = o1;
	}

	public double getO2() {
		return o2;
	}

	public void setO2(double o2) {
		this.o2 = o2;
	}

	public double getO3() {
		return o3;
	}

	public void setO3(double o3) {
		this.o3 = o3;
	}

	public double getO4() {
		return o4;
	}

	public void setO4(double o4) {
		this.o4 = o4;
	}

	public double getO5() {
		return o5;
	}

	public void setO5(double o5) {
		this.o5 = o5;
	}

	public double getO6() {
		return o6;
	}

	public void setO6(double o6) {
		this.o6 = o6;
	}

	public String getOsendTel() {
		return osendTel;
	}

	public void setOsendTel(String osendTel) {
		this.osendTel = osendTel;
	}

	public String getOsendAddress() {
		return osendAddress;
	}

	public void setOsendAddress(String osendAddress) {
		this.osendAddress = osendAddress;
	}

	
	
	

}
