package com.yc.bean;

import java.util.Date;

public class Handover {
    private Integer hid;

    private Integer cid;

    private Integer did;

    private Integer osid;

    private Integer rid;

    private String hfromspname;

    private String htospname;

    private Date hstarttime;

    private Date hendtime;

    private Integer hstatus;

    private String hremark;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getOsid() {
        return osid;
    }

    public void setOsid(Integer osid) {
        this.osid = osid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getHfromspname() {
        return hfromspname;
    }

    public void setHfromspname(String hfromspname) {
        this.hfromspname = hfromspname == null ? null : hfromspname.trim();
    }

    public String getHtospname() {
        return htospname;
    }

    public void setHtospname(String htospname) {
        this.htospname = htospname == null ? null : htospname.trim();
    }

    public Date getHstarttime() {
        return hstarttime;
    }

    public void setHstarttime(Date hstarttime) {
        this.hstarttime = hstarttime;
    }

    public Date getHendtime() {
        return hendtime;
    }

    public void setHendtime(Date hendtime) {
        this.hendtime = hendtime;
    }

    public Integer getHstatus() {
        return hstatus;
    }

    public void setHstatus(Integer hstatus) {
        this.hstatus = hstatus;
    }

    public String getHremark() {
        return hremark;
    }

    public void setHremark(String hremark) {
        this.hremark = hremark == null ? null : hremark.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5 == null ? null : remark5.trim();
    }
}