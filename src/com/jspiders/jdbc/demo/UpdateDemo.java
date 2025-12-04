package com.jspiders.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
    public static void main(String[] args) {
        System.out.println("program starts");
        String dbUrl="jdbc:mysql://localhost:3306/appusers";
        String username="root";
        String password="Root@123";

        String UpdateSql="update appusers.users set mobile = '9876542222' where userid = 1;";

        try{
            Connection con=DriverManager.getConnection(dbUrl,username,password);
            System.out.println("connected to appusers db successfully");

            Statement stm1=con.createStatement();
            int rowsAffected=stm1.executeUpdate(UpdateSql);
            System.out.println(rowsAffected+"row(s) updated");

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to connect database");
        }
        System.out.println("program ends");
    }

}
