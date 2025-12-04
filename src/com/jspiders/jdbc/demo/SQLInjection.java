package com.jspiders.jdbc.demo;

import java.sql.*;

public class SQLInjection {

    static  String dbUrl="jdbc:mysql://localhost:3306/appusers";
  static  final  String username="root";
  static  final  String Password="Root@123";

    public static void loginV2(String mobile ,String password) {
        String selectSQl="select * from users where mobile=? and password=?;";

        try {
            Connection con= DriverManager.getConnection(dbUrl,username,Password);

            PreparedStatement psm1= con.prepareStatement(selectSQl);
            psm1.setString(1,mobile);
            psm1.setString(2,password);

            System.out.println("query :" +psm1);
            ResultSet rs =psm1.executeQuery();
            if(rs.next()){
                System.out.println("login succes");
            }
            else{
                System.out.println("login failed");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void login(String mobile ,String password) {
        String selectSQl="select * from users where mobile='"+mobile+"' and password='"+password+"';";

        try {
            Connection con= DriverManager.getConnection(dbUrl,username,Password);

            Statement stm1= con.createStatement();
            System.out.println("query :" +selectSQl);


            ResultSet rs =stm1.executeQuery(selectSQl);
            if(rs.next()){
                System.out.println("login succes");
            }
            else{
                System.out.println("login failed");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String mobile="'or '1'='1'";
        String password="'or '1'='1'";
        login(mobile,password);
    }
}
