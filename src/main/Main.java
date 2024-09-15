package main;

import interfaces.Pages;

import javax.swing.*;
import java.sql.Connection;

public class Main implements Pages {

    public static void main(String[] args) {
        DbFunctions db =new DbFunctions();
        Connection conn;
        conn = db.getConn();


        Login l = new Login();



//        db.createTable(conn,"Employees",);
    }
}