package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo{
    public static void main(String[] args) {
        System.out.println(" program starts");
        String dbUrl="jdbc:mysql://localhost:3306/appusers";
        String username="root";
        String Password="Root@123";

        String insertSql="insert into appusers.users values "+"(0,'rohit','9876543210','pass887');";
        try {
            Connection con= DriverManager.getConnection(dbUrl,username,Password);
            System.out.println("connected to appusers db successfully");

            Statement stm1=con.createStatement();
            //execute updated(string sql ): executes DML statements and returns int
            int rowsAffected=stm1.executeUpdate(insertSql);
            System.out.println(rowsAffected+"row(s) added");


            }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to connect appusers database");
        }
        System.out.println("program ends");

    }
}