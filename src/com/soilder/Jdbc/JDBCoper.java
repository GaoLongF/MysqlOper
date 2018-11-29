package com.soilder.Jdbc;

import com.soilder.Figure.Department;
import com.soilder.Figure.Employee;
import com.soilder.Figure.Goods;
import com.soilder.Figure.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCoper {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Connection getConn() {
        return conn;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public JDBCoper() {
        this.conn = JDBC.getConnection();
    }
    public void close(){
        JDBC.close(rs,ps,conn);
    }

    //创建表
    public void createTable() throws SQLException {
        String sqlde = "create table if not exists Departments" +
                "(depName varchar(20),depId int,depPrice double,depGorName varchar(20),depGorTel int,depGovAddress varchar(50));";
        String sqlem = "create table if not exists Employees" +
                "(emId int,emName varchar(20),emPosition varchar(20),emTel int,emAddress varchar(50),emAge int);";
        String sqlwh = "create table if not exists Warehouses" +
                "(warId int,warName varchar(30),warTel int);";
        String sqlgs = "create table if not exists Goods" +
                "(gsId int,gsName varchar(20),gsPrice double,gsRelPrice double);";
        String[] table = {sqlde, sqlem, sqlwh, sqlgs};
        for (int i = 0; i < table.length; i++) {
            ps = conn.prepareStatement(table[i]);
            ps.executeUpdate();
        }
    }

    //插入操作通过创建可变参数插入学生对象
    public void insert(String table, Object... obj) throws SQLException {
        if (table == "Employees") {
            String sql = "insert into Employees(emId,emName,emPosition,emTel,emAddress,emAge) values (?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                Employee employee = (Employee) obj[i];
                ps.setObject(1, employee.getEmId());
                ps.setObject(2, employee.getEmName());
                ps.setObject(3, employee.getEmPosition());
                ps.setObject(4, employee.getEmTel());
                ps.setObject(5, employee.getEmAddress());
                ps.setObject(6, employee.getEmAge());
                ps.executeUpdate();
            }
        }

        if (table == "Departments") {
            String sql = "insert into Departments(depName,depId,depPrice,depGorName,depGorTel,depGovAddress)values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                Department department = (Department) obj[i];
                ps.setObject(1, department.getDepName());
                ps.setObject(2, department.getDepId());
                ps.setObject(3, department.getDepPrice());
                ps.setObject(4, department.getDepGorName());
                ps.setObject(5, department.getDepGorTel());
                ps.setObject(6, department.getDepGovAddress());
                ps.executeUpdate();
            }
        }

        if (table == "Warehouses") {
            String sql = "insert into Warehouses(warId,warName,warTel)values(?,?,?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                Warehouse warehouse = (Warehouse) obj[i];
                ps.setObject(1, warehouse.getWarId());
                ps.setObject(2, warehouse.getWarName());
                ps.setObject(3, warehouse.getWarTel());
                ps.executeUpdate();
            }
        }

        if (table == "Goods") {
            String sql = "insert into Goods(gsId,gsName,gsPrice,gsRelPrice)values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                Goods goods = (Goods) obj[i];
                ps.setObject(1, goods.getGsId());
                ps.setObject(2, goods.getGsName());
                ps.setObject(3, goods.getGsPrice());
                ps.setObject(4, goods.getGsRelPrice());
                ps.executeUpdate();
            }
        }
    }

    //删除操作(只包含删除员工，商品信息)
    public void delete(Object obj) throws SQLException {
        if (obj instanceof Goods) {
            Goods gs = (Goods) obj;
            String sql = "delete from Goods where gsId=? ";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, gs.getGsId());
            ps.executeUpdate();
        }

        if (obj instanceof Employee) {
            Employee employee = (Employee) obj;
            String sql = "delete from Employees where emId=?;";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, employee.getEmId());
            ps.executeUpdate();
        }
    }

    //查找数据
    //1.查询员工人数/商品总数
    public void selectNum(String str) throws SQLException
    {
        if (str == "Employees") {
            String sql = "select COUNT(*) totalCount from Employees";
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()) {
                System.out.println("员工人数为：" + rs.getInt("totalCount"));
            }
        }
        if (str == "Goods") {
            String sql = "select COUNT(*) totalCount from Goods";
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()) {
                System.out.println("食品总数为：" + rs.getInt("totalCount"));
            }
        }
    }
    //2.查找某个详细信息
    public void selectMsg(Object obj) throws SQLException
    {
        if (obj instanceof Employee)
        {
            Employee employee = (Employee) obj;
            String sql = "select * from Employees where emId=? ";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, employee.getEmId());
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getObject("emName")
                        +"，年龄为："+rs.getObject("emAge")
                        +"，编号为："+rs.getObject("emId")
                        +"，职位为："+rs.getObject("emPosition")
                        +",电话为："+rs.getObject("emTel")
                        +",住址为："+rs.getObject("emAddress"));
            }
        }
        if (obj instanceof Goods)
        {
            Goods gs = (Goods) obj;
            String sql = "select * from Goods where gsId=? ";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, gs.getGsId());
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getObject("gsName")
                        +"，编号为："+rs.getObject("gsId")
                        +"，进价为："+rs.getObject("gsPrice")
                        +",售价为："+rs.getObject("gsRelPrice"));
            }
        }
    }

    //更改信息
    public  void upDate(Goods gs,double price) throws SQLException {
        String sql="update Goods set gsRelPrice='" + price + "' where gsRelPrice='" +  gs.getGsRelPrice()+ "'";
        ps=conn.prepareStatement(sql);
        ps.executeUpdate();
    }

    public  void upDate(Employee employee,int tel) throws SQLException {
        String sql="update Employees set emTel='" + tel + "' where emId='" +  employee.getEmId()+ "'";
        ps=conn.prepareStatement(sql);
        ps.executeUpdate();
    }

    //模糊查询商品信息
    public void select(String str) throws SQLException {
        String sql="select gsName,gsRelPrice from Goods where gsName LIKE '%"+str+"%' order by gsRelPrice ";
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getObject("gsName")+"售价为"+rs.getObject("gsRelPrice"));
        }

    }
}