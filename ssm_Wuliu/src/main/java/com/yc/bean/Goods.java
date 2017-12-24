package com.yc.bean;

public class Goods {
    private Integer gid;

    private String gname;

    private String gcount;

    private Double gprice;

    private Double gweight;

    private Double gvolume;

    private String gtype;

    private String gremark;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGcount() {
        return gcount;
    }

    public void setGcount(String gcount) {
        this.gcount = gcount == null ? null : gcount.trim();
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

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype == null ? null : gtype.trim();
    }

    public String getGremark() {
        return gremark;
    }

    public void setGremark(String gremark) {
        this.gremark = gremark == null ? null : gremark.trim();
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