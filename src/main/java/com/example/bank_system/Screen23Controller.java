package com.example.bank_system;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Screen23Controller extends Screen19Login{

    @FXML
    private Button Pay_Employee;

    public Button Pay_Employee() {
        return Pay_Employee;
    }

    @FXML
    private Button Hire_Worker;

    public Button Hire_Worker() {
        return Hire_Worker;
    }


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void PayEmployee(javafx.event.ActionEvent event) throws IOException {

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();


        System.out.println("before:" +previous);
        root = FXMLLoader.load(getClass().getResource("screen13.fxml"));
        previous = 23;
        System.out.println("after:" +previous);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void HireWorker(javafx.event.ActionEvent event) throws IOException {

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        System.out.println("before:" +previous);

        root = FXMLLoader.load(getClass().getResource("screen6.fxml"));
        previous = 23;
        System.out.println("after:" +previous);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}


