package com.example.bank_system;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import javafx.event.ActionEvent;

public class Screen6Controller {
    @FXML
    private Button back;

    public Button getBack() {
        return back;
    }

    @FXML
    private Button confirm;

    public Button getConfirm() {
        return confirm;
    }

    @FXML
    private ComboBox bank;
    public ComboBox getBank() {
        return bank;
    }

    @FXML
    private ComboBox employee;
    public ComboBox getEmployee() {
        return employee;
    }

    @FXML
    private TextField newsalary;
    public TextField getNewsalary() { return newsalary; }

    private int salary;


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void bank(ActionEvent actionEvent) {
    }

    public void employee(ActionEvent actionEvent) {
    }

    public void salary(ActionEvent actionEvent) {
        String salarytext = newsalary.getText();
        salary = Integer.parseInt(salarytext);
        System.out.println(salary);
    }

    public void back(ActionEvent actionEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("screen23.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void confirm(ActionEvent actionEvent) {
    }
}
