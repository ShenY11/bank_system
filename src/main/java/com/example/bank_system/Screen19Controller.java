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

public class Screen19Controller extends Screen19Login{

    @FXML
    private Button loginButton;
    public Button getLoginButton() {
        return loginButton;
    }

    @FXML
    private TextField idTextfield;
    public TextField getIdTextfield() {
        return idTextfield;
    }

    @FXML
    private TextField passwordTextfield;
    public TextField getPasswordTextfield() {
        return passwordTextfield;
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void submitLogin(javafx.event.ActionEvent event) throws IOException {
        ID = idTextfield.getText() == null ? "" : idTextfield.getText();
        password = passwordTextfield.getText() == null ? "" : passwordTextfield.getText();
        System.out.println(ID);
        System.out.println(password);
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String adminQuery = "select person.perID, pwd from person join system_admin on person.perID = system_admin.perID;";
        String employeeQuery = "select person.perID, pwd from person join bank on person.perID = bank.manager;";
        String customerQuery = "select person.perID, pwd from person join customer on person.perID = customer.perID;";

        try {
            Statement statement1 = connectionDB.createStatement();
            Statement statement2 = connectionDB.createStatement();
            Statement statement3 = connectionDB.createStatement();
            ResultSet adminQueryOutput = statement1.executeQuery(adminQuery);
            ResultSet employeeQueryOutput = statement2.executeQuery(employeeQuery);
            ResultSet customerQueryOutput = statement3.executeQuery(customerQuery);

            //Authorization check -- valid person?
            boolean matchAdmin = false;
            boolean matchEmployee = false;
            boolean matchCustomer = false;
            while (adminQueryOutput.next()) {
                String queryIDNow = adminQueryOutput.getString("perID");
                String queryPWDNow = adminQueryOutput.getString("pwd");
                if (ID.compareTo(queryIDNow) == 0 && password.compareTo(queryPWDNow) == 0) {
                    matchAdmin = true;
                    break;
                }
            }
            while (customerQueryOutput.next()) {
                String queryIDNow = customerQueryOutput.getString("perID");
                String queryPWDNow = customerQueryOutput.getString("pwd");
                if (ID.compareTo(queryIDNow) == 0 && password.compareTo(queryPWDNow) == 0) {
                    matchCustomer = true;
                    break;
                }
            }
            while (employeeQueryOutput.next()) {
                String queryIDNow = employeeQueryOutput.getString("perID");
                String queryPWDNow = employeeQueryOutput.getString("pwd");
                if (ID.compareTo(queryIDNow) == 0 && password.compareTo(queryPWDNow) == 0) {
                    matchEmployee = true;
                    break;
                }
            }

            //TODO: what if employee and customer at the same time, which panel shows up after log in
            if (matchAdmin) {
                root = FXMLLoader.load(getClass().getResource("screen20.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else if (matchEmployee) {
                root = FXMLLoader.load(getClass().getResource("screen23.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else if (matchCustomer) {
                root = FXMLLoader.load(getClass().getResource("screen24.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Please enter valid ID and password");
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}