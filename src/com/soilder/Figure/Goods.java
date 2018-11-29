package com.soilder.Figure;

public class Goods
{
    //商品编号，名字，采购成本，零售价
    private int gsId;
    private String gsName;
    private double gsPrice;
    private double gsRelPrice;

    //通过构造函数初始化商品信息；
    public Goods(int gsId, String gsName, double gsPrice, double gsRelPrice) {
        this.gsId = gsId;
        this.gsName = gsName;
        this.gsPrice = gsPrice;
        this.gsRelPrice = gsRelPrice;
    }

    public int getGsId() {
        return gsId;
    }

    public String getGsName() {
        return gsName;
    }

    public double getGsPrice() {
        return gsPrice;
    }

    public double getGsRelPrice() {
        return gsRelPrice;
    }
}
