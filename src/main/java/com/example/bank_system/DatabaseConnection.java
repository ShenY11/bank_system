package com.example.bank_system;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databseLink;

    public Connection getConnection() {
        String databseName = "bank_management";
        String databseUser = "root";
        String databsePassword = "password";
<<<<<<< HEAD
        //String databsePassword = "84703636Lmq";
=======
        //String databsePassword = "WangQian-112";
>>>>>>> f2f3f980ddd9b360fb848a82b0c7e14860c6265e
        String url = "jdbc:mysql://localhost/" + databseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databseLink = DriverManager.getConnection(url, databseUser, databsePassword);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return databseLink;
    }
}
