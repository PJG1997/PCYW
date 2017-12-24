package com.yc.bean;

public class Price {
    private Integer pid;

    private String pfrom;

    private String pto;

    private Double pfirstwei;

    private Double prestwei;

    private Double pfirstvol;

    private Double prestvol;

    private String pretime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPfrom() {
        return pfrom;
    }

    public void setPfrom(String pfrom) {
        this.pfrom = pfrom == null ? null : pfrom.trim();
    }

    public String getPto() {
        return pto;
    }

    public void setPto(String pto) {
        this.pto = pto == null ? null : pto.trim();
    }

    public Double getPfirstwei() {
        return pfirstwei;
    }

    public void setPfirstwei(Double pfirstwei) {
        this.pfirstwei = pfirstwei;
    }

    public Double getPrestwei() {
        return prestwei;
    }

    public void setPrestwei(Double prestwei) {
        this.prestwei = prestwei;
    }

    public Double getPfirstvol() {
        return pfirstvol;
    }

    public void setPfirstvol(Double pfirstvol) {
        this.pfirstvol = pfirstvol;
    }

    public Double getPrestvol() {
        return prestvol;
    }

    public void setPrestvol(Double prestvol) {
        this.prestvol = prestvol;
    }

    public String getPretime() {
        return pretime;
    }

    public void setPretime(String pretime) {
        this.pretime = pretime == null ? null : pretime.trim();
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