//package com.jspiders.jdbc.demo;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TransactionDemo {
//     private  static  final String dbUrl="jdbc:mysql://localhost:3306/appusers";
//    private  static  final  String username="root";
//    private  static  final  String password="Root@123";
//    private static Connection con =null;
//
//
//    public static void main(String[] args) {
//        System.out.println("program starts");
//
//        try {
//            con= DriverManager.getConnection(dbUrl,username,password);
//            con.setAutoCommit(false);
//            //sql
//            System.out.println("addind user");
//            String insertSql="insert into appusers.users values "+"(0,'ram','9876543432','ram887');";
//            Statement stm1=con.createStatement();
//            stm1.executeUpdate(insertSql);
//            System.out.println("Adding user Successfull ");
//
//            System.out.println("update user");
//            String UpdateSql="update appusers.users set mobile = '9876542222' where mobile = 9876543432;";
//            Statement stm2=con.createStatement();
//             int rowsAffected= stm2.executeUpdate(UpdateSql);
//             if(rowsAffected==0){
//                 throw new SQLException("user with mobile number not found")
//             }
//            System.out.println("update user successfull for "+rowsAffected+" user(s)");
//             con.commit();//save all
//        }
//
//        System.out.println("program ends");
//
//    }
//}
