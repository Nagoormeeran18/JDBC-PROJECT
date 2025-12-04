package com.jspiders.jdbc.demo;

import com.mysql.cj.util.DnsSrv;

import java.sql.*;
import java.util.Scanner;

public class Demo {

   private static final Scanner sc1=new Scanner(System.in);
   static String url="jdbc:mysql://localhost:3306/appusers";
   static String username="root";
   static String Password="Root@123";

    public static void adduser(){

        String name="NAGOOR";
        String mobile="9988776655";
        String password="pass123";

        String insertSql= "insert into appusers.users values(0,"+" ' "+name+"',"+"'"+mobile+"',"+"'"+password+"');";

        System.out.println(insertSql);
    }

    public static void adduser1(){
        //Scanner sc1=new Scanner(System.in);
        System.out.println("enter user name");
        String name=sc1.next();

        System.out.println("enter user mobile number");
        String mobile=sc1.next();

        System.out.println("enter user password");
        String password=sc1.next();

        String insertsql="insert into appusers.users values(0,?,?,?);";

       try{
           Connection con = DriverManager.getConnection(url,username,Password);
           System.out.println("connected");
           PreparedStatement ps=con.prepareStatement(insertsql);
           System.out.println("statement obj created");
           ps.setString(1,name);//ps.setString(parameterIndex,vaule);
           ps.setString(2,mobile);
           ps.setString(3,password);
           ps.executeUpdate();
       }
       catch (SQLException e){
           e.printStackTrace();
           System.out.println("unable to connect");
       }
    }

    public static void updateuserMobile(){
        System.out.println("enter current mobile number");
        String currMobile=sc1.next();

        System.out.println("enter new mobile number");
        String newMobile=sc1.next();

        String updateSql="update appusers.users set mobile=? where mobile=?";
        try{
            Connection con = DriverManager.getConnection(url,username,Password);
            PreparedStatement ps=con.prepareStatement(updateSql);
            ps.setString(1,newMobile);//ps.setString(parameterIndex,vaule);
            ps.setString(2,currMobile);
            ps.executeUpdate();
            System.out.println("updated");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to update");
        }
    }
    public static void DeleteUser(){
        System.out.println("enter mobile number ");
        String newMobile=sc1.next();
        String deleteSql="Delete from appusers.users where mobile=?";
        try{
            Connection con = DriverManager.getConnection(url,username,Password);
            PreparedStatement ps=con.prepareStatement(deleteSql);
            ps.setString(1,newMobile);//ps.setString(parameterIndex,vaule);

            ps.executeUpdate();
            System.out.println("user deleted");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to delete user");
        }
    }

    public static void Getusers(){
        String SelectSql="select * from appusers.users";
        try{
            Connection con = DriverManager.getConnection(url,username,Password);
            Statement stm1=con.createStatement();
             ResultSet rs=stm1.executeQuery(SelectSql);
                    while (rs.next()==true) {


                        int userId = rs.getInt("userid");
                        String Name = rs.getString("name");
                        String Mobile = rs.getString("mobile");
                        String Password = rs.getString("password");

                        System.out.println(userId + " " + Name + " " + Mobile + " " + Password);
                    }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void GetuserByMobile(){
        String SelectSQL="select *from appusers.users where mobile=?";
        try{
            Connection con = DriverManager.getConnection(url,username,Password);
            PreparedStatement pstm=con.prepareStatement(SelectSQL);
            System.out.println("enter the mobile number");
            String Mobile=sc1.next();
            pstm.setString(1,Mobile);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()==true){
                String mobile=rs.getString("name");
                System.out.println(mobile);
            }
            else {
                System.out.println("user not found");
            }
        }
        catch (SQLException e){
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        System.out.println("program starts ");
       // adduser1();
       // updateuserMobile();
       // DeleteUser();
         // Getusers();
        GetuserByMobile();
        System.out.println("program ends");
    }
}
