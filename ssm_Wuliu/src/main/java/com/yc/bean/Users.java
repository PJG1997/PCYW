package com.yc.bean;

import java.io.Serializable;

public class Users implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2518213748331195249L;
	
	private Integer usid;		//用户ID
    private String uname;		//用户账号
    private String upwd;		//用户密码
    private String urealname;  	//用户真实姓名
    private String uaddress;	//用户地址
    private String uphone;		//用户手机
    private String utel;		//座机
    private String uemail;		//用户邮箱
    private Integer status;		//用户状态(0:表示用户封禁或删除状态,1:表示管理员)
    private String remark1;		//备用字段1
    private String remark2;		//备用字段2
    private String remark3;		//备用字段3
    private String remark4;		//备用字段4
    private String remark5;		//备用字段5
	public Integer getUsid() {
		return usid;
	}
	public void setUsid(Integer usid) {
		this.usid = usid;
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
	public String getUrealname() {
		return urealname;
	}
	public void setUrealname(String urealname) {
		this.urealname = urealname;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
		return "Users [usid=" + usid + ", uname=" + uname + ", upwd=" + upwd + ", urealname=" + urealname
				+ ", uaddress=" + uaddress + ", uphone=" + uphone + ", utel=" + utel + ", uemail=" + uemail
				+ ", status=" + status + ", remark1=" + remark1 + ", remark2=" + remark2 + ", remark3=" + remark3
				+ ", remark4=" + remark4 + ", remark5=" + remark5 + "]";
	}

}