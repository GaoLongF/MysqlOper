package com.soilder.Figure;

public class Employee
{
    //员工号，姓名，职位，联系方式，地址，年龄
    private int emId;
    private String emName;
    private String emPosition;
    private int emTel;
    private String emAddress;
    private int emAge;

    //通过构造函数初始化员工信息
    public Employee(int emId, String emName, String emPosition, int emTel, String emAddress, int emAge) {
        this.emId = emId;
        this.emName = emName;
        this.emPosition = emPosition;
        this.emTel = emTel;
        this.emAddress = emAddress;
        this.emAge = emAge;
    }

    public int getEmId() {
        return emId;
    }

    public String getEmName() {
        return emName;
    }

    public String getEmPosition() {
        return emPosition;
    }

    public int getEmTel() {
        return emTel;
    }

    public String getEmAddress() {
        return emAddress;
    }

    public int getEmAge() {
        return emAge;
    }
}
