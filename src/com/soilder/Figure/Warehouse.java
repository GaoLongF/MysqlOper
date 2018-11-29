package com.soilder.Figure;

public class Warehouse
{
    //仓库包含仓库号，仓库管理员姓名，联系方式
    private int warId;
    private String warName;
    private int warTel;

    //直接利用构造函数初始化仓库的信息
    public Warehouse(int warId, String warName, int warTel) {
        this.warId = warId;
        this.warName = warName;
        this.warTel = warTel;
    }

    public int getWarId() {
        return warId;
    }

    public String getWarName() {
        return warName;
    }

    public int getWarTel() {
        return warTel;
    }
}
