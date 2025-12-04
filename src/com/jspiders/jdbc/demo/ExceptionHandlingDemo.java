//package com.jspiders.jdbc.demo;
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class ExceptionHandlingDemo {
//    public static Connection getDbConnection(){
//        Connection con=null;
//
//        String dbUrl="jdbc:mysql://localhost:3306/appusers";
//        String username="root";
//        String Password="Root@123";
//        try {
//            con= DriverManager.getConnection(dbUrl,username,Password);
//            System.out.println("connected to appusers db successfully");
//        }
//        catch (SQLException e){
//            System.err.println("ERROR while connecting to Database");
//            throw new DBConnectionException(e.getMessage());
//        }
//        return con;
//    }
//    public static void adduser(){
//        String insertSql="insert into appusers.users values "+"(0,'rohit','9876547780','pass887');";
//        try {
//            Connection con=getDbConnection();
//            Statement stm1=con.createStatement();
//            int rowsAffected=stm1.executeUpdate(insertSql);
//            System.out.println(rowsAffected+"row(s) added");
//        }
//        catch (SQLException e){
//            throw new DuplicateNumberException("user with mobile number already exist");
//        }
//
//    }
//}
