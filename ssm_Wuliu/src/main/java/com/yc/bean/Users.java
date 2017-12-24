package com.yc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Users implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7275069496683180382L;
	private Integer usId;//1.	用户ID
	private String uname;//2.	用户账号
	private String upwd;//3.	用户密码
	private String urealName;//4.真实姓名
	private String uaddress;//5.地址
	private String uphone;//6.	手机
	private String utel;//7.	电话
	private String uemail;//8.	邮箱
	
	private List<Order> orders = new ArrayList<Order>();
	
	private Role role;
	
//	private String u1;
//	private String u2;
//	private String u3;
//	private String u4;
	
	public Integer getUsId() {
		return usId;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	//用户角色
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void setUsId(Integer usId) {
		this.usId = usId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUrealName() {
		return urealName;
	}
	public void setUrealName(String urealName) {
		this.urealName = urealName;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String uname, String upwd, String urealName, String uaddress,
			String uphone, String utel, String uemail) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.urealName = urealName;
		this.uaddress = uaddress;
		this.uphone = uphone;
		this.utel = utel;
		this.uemail = uemail;
	}

	@Override
	public String toString() {
		return "Users [usId=" + usId + ", uname=" + uname + ", upwd=" + upwd
				+ ", urealName=" + urealName + ", uaddress=" + uaddress
				+ ", uphone=" + uphone + ", utel=" + utel + ", uemail="
				+ uemail + "]";
	}
	

}
