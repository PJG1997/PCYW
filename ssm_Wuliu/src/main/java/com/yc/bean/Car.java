package com.yc.bean;

import java.util.Date;

public class Car {
    private Integer cid;

    private Integer spid;

    private String cnumber;

    private String ctype;

    private Date cbuyday;

    private String crunnum;

    private Double cvolume;

    private Double cton;

    private Integer cstatus;

    private Integer cisbox;

    private String cremake;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber == null ? null : cnumber.trim();
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype == null ? null : ctype.trim();
    }

    public Date getCbuyday() {
        return cbuyday;
    }

    public void setCbuyday(Date cbuyday) {
        this.cbuyday = cbuyday;
    }

    public String getCrunnum() {
        return crunnum;
    }

    public void setCrunnum(String crunnum) {
        this.crunnum = crunnum == null ? null : crunnum.trim();
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

    public Integer getCisbox() {
        return cisbox;
    }

    public void setCisbox(Integer cisbox) {
        this.cisbox = cisbox;
    }

    public String getCremake() {
        return cremake;
    }

    public void setCremake(String cremake) {
        this.cremake = cremake == null ? null : cremake.trim();
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