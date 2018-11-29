package com.soilder.Figure;

public class Department
{
    //超市有多个部门,如生鲜，熟食...每个部门有部门号，
    // 每月运营费用，主管姓名，联系方式，地址
    private String depName;
    private int depId;
    private double depPrice;
    private String depGorName;
    private int depGorTel;
    private String depGovAddress;

    //通过构造函数对部门信息初始化
    public Department(String depName, int depId, double depPrice, String depGorName, int depGorTel, String depGovAddress)
    {
        this.depName = depName;
        this.depId = depId;
        this.depPrice = depPrice;
        this.depGorName = depGorName;
        this.depGorTel = depGorTel;
        this.depGovAddress = depGovAddress;
    }

    public String getDepName() {
        return depName;
    }

    public int getDepId() {
        return depId;
    }

    public double getDepPrice() {
        return depPrice;
    }

    public String getDepGorName() {
        return depGorName;
    }

    public int getDepGorTel() {
        return depGorTel;
    }

    public String getDepGovAddress() {
        return depGovAddress;
    }
}
