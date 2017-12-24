package com.yc.bean;

import java.io.Serializable;



public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7871679087920040707L;
	private Integer gid;// 1. 货物编码
	private String gname;// 2. 货物名称
	private Integer gcount;// 3. 货物数量
	private String gunit;// 4. 单位
	private Double gprice;// 5. 货品价值
	private Double gweight;// 6. 货物重量(kg)
	private Double gvolume;// 7. 货物体积(m^3)
	private String gtype;// 8. 货物类别
	private String gremark;// 9. 备注

//	private Order order;

	public Integer getGid() {
		return gid;
	}

//	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })	// 双向
//	@JoinColumn(name = "osId")
//	public Order getOrder() {
//		return order;
//	}

	public Goods(Integer gid) {
		super();
		this.gid = gid;
	}

	public Goods(String gname, Integer gcount, String gunit, Double gprice,
			Double gweight, Double gvolume, String gtype, String gremark) {
		super();
		this.gname = gname;
		this.gcount = gcount;
		this.gunit = gunit;
		this.gprice = gprice;
		this.gweight = gweight;
		this.gvolume = gvolume;
		this.gtype = gtype;
		this.gremark = gremark;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getGcount() {
		return gcount;
	}

	public void setGcount(Integer gcount) {
		this.gcount = gcount;
	}

	public String getGunit() {
		return gunit;
	}

	public void setGunit(String gunit) {
		this.gunit = gunit;
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

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gcount=" + gcount
				+ ", gunit=" + gunit + ", gprice=" + gprice + ", gweight="
				+ gweight + ", gvolume=" + gvolume + ", gtype=" + gtype
				+ ", gremark=" + gremark + "]";
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

	public void setGid(Integer gid) {
		this.gid = gid;
	}

//	public void setOrder(Order order) {
//		this.order = order;
//	}


	// private String g1;
	// private String g2;
	// private String g3;
	// private String g4;

}
