package com.mysqld;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.window.Register;

import javax.swing.*;


public class Mysqld {
    public static Connection con = null;

    public Mysqld(String account, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("load success");
        } catch (Exception e) {
            System.out.println("fail");
        }
        String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf-8&useSSL=false";
        try {
            con = (Connection) DriverManager.getConnection(url, account, password);
            System.out.println("connect success");
        } catch (SQLException e) {
            System.out.println("connect fail");
        }
    }

    //注册信息写入
    public static boolean loginAccount(String account, String password) {
        Statement sql;
        ResultSet rs;
        String url = "select account,password from user";
        try {
            sql = con.createStatement();
            rs = sql.executeQuery(url);
            while (rs.next()) {
                String acc = rs.getString(1);
                String pass = rs.getString(2);
                if (acc.equals(account) && pass.equals((password))) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
    public static void addStudent(String name,String number){
        PreparedStatement preSql;
        String sqlStr="insert into stu(name,number) values(?,?)";
        try{
            preSql=con.prepareStatement(sqlStr);
            preSql.setString(1,name);
            preSql.setString(2,number);
            int ok=preSql.executeUpdate();
            JOptionPane.showMessageDialog(null,"添加成功","增加数据",JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"已经存在","增加数据",JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void delStudent(String number){
        PreparedStatement preSql;
        String sqlStr="delete from stu where number=?";

        try {
            preSql=con.prepareStatement(sqlStr);
            preSql.setString(1,number);
            int ok=preSql.executeUpdate();
            if(ok==0){
                JOptionPane.showMessageDialog(null,"已经删除",  "删除数据",JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"删除成功","删除数据",JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
