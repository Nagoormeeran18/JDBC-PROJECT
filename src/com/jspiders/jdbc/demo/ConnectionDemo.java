package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) {
        System.out.println(" program starts");
        String dbUrl="jdbc:mysql://localhost:3306/db1";
        String username="root";
        String Password="Root@123";
        try {
           Connection connection= DriverManager.getConnection(dbUrl,username,Password);
            System.out.println("connected to database successfully");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to connect to the database");
        }
        System.out.println("program ends");
    }
}
