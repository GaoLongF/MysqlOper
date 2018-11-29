package com.soilder;

import com.soilder.Figure.Department;
import com.soilder.Figure.Employee;
import com.soilder.Figure.Goods;
import com.soilder.Figure.Warehouse;
import com.soilder.Jdbc.JDBCoper;

import java.sql.SQLException;

public class StorMsg
{
    public static void main(String[] args)
    {
        //假设的员工信息
        Employee zjl=new Employee(1,"周杰伦","杀鱼的",123455678,"中国.台湾",33);
        Employee xzq=new Employee(2,"薛之谦","买酒的",132546987,"中国.上海",32);
        Employee cyx=new Employee(3,"陈奕迅","买菜的",321546879,"中国.香港",31);
        Employee dzq=new Employee(4,"邓紫棋","收钱的",258169347,"中国.上海",28);
        Employee ftm=new Employee(5,"冯提莫","导购的",159372486,"中国.重庆",27);
        Employee lzl=new Employee(6,"林志玲","打电话的",158764921,"中国.台湾",44);
        Employee may=new Employee(7,"马云","进货的",14587965,"中国.杭州",50);
        Employee wjl=new Employee(8,"王健林","发钱的",12385796,"中国.大连",58);

        //假设的商品信息
        Goods shupian=new Goods(125,"薯片",2.5,4.0);
        Goods cola=new Goods(25,"可乐",2.2,3.0);
        Goods iPhone=new Goods(100,"手机",8000,9999);
        Goods xiangjiao=new Goods(15,"香蕉",2.0,3.99);
        Goods jichi=new Goods(27,"鸡翅",4.5,7.0);
        Goods guazi=new Goods(16,"瓜子",5.2,8.5);
        Goods fish=new Goods(58,"鱼",8.8,12.5);
        Goods alcohol=new Goods(43,"五粮液",500,666);
        //假设的厂库
        Warehouse cq=new Warehouse(400000,"重庆一分库",45897111);
        Warehouse bj=new Warehouse(100000,"北京一分库",35478222);
        Warehouse hz=new Warehouse(310000,"杭州一分库",68759333);
        Warehouse gz=new Warehouse(510000,"广州一分库",89745666);
        //假设的部门
        Department finance=new Department("财务部",01,3000000,"王健林",12385796,"中国.大连");
        Department sale=new Department("销售部",02,5000000,"陈奕迅",321546879,"中国.香港");
        Department purchase=new Department("采购部",03,1029874,"马云",14587965,"中国.杭州");
        Department publicity=new Department("宣传部",04,600000,"冯提莫",159372486,"中国.重庆");
        Department service=new Department("客服部",05,60000,"林志玲",158764921,"中国.台湾");
        JDBCoper coper=new JDBCoper();
        try {
            //创建相关表
            coper.createTable();

            //向表中插入相关数据
            coper.insert("Employees",zjl,xzq,cyx,dzq,ftm,lzl,may,wjl);
            coper.insert("Goods",shupian,cola,iPhone,xiangjiao,jichi,guazi,fish,alcohol);
            coper.insert("Departments",finance,sale,purchase,publicity,service);
            coper.insert("Warehouses",cq,bj,hz,gz);

            //删除员工表/商品信息表信息
            coper.delete(cyx);
            coper.delete(fish);

            //查找相关信息
            coper.selectNum("Goods");       //查找食品总数
            coper.selectNum("Employees");       //查找员工总数
            coper.selectMsg(guazi);         //查找某种食品详细信息
            coper.selectMsg(may);           //查找某员工的详细信息

            //更改信息
            coper.upDate(xiangjiao,6.1);
            coper.upDate(xzq,14025879);

            //商品模糊查询
            Goods maipian=new Goods(30,"麦片",20,35);
            coper.insert("Goods",maipian);
            coper.select("片");     //查找商品名字带有某个字的，并按价格升序返后查询结果
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            coper.close();
        }
    }
}
//yangjuanping@redrock.team
