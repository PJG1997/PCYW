package com.yc.bean;

public class Proxy {
    private Integer prid;

    private String prname;

    private String prtime;

    private Double prprice;

    private Integer spid;

    private String prremark;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname == null ? null : prname.trim();
    }

    public String getPrtime() {
        return prtime;
    }

    public void setPrtime(String prtime) {
        this.prtime = prtime == null ? null : prtime.trim();
    }

    public Double getPrprice() {
        return prprice;
    }

    public void setPrprice(Double prprice) {
        this.prprice = prprice;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getPrremark() {
        return prremark;
    }

    public void setPrremark(String prremark) {
        this.prremark = prremark == null ? null : prremark.trim();
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