package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Screen13Controller extends Screen19Login{
    @FXML
    private Button pay;

    public Button getPay() {
        return pay;
    }

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void pay(ActionEvent actionEvent) {

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String pay_employees = "call pay_employees();";


        try {

            //TODO: input examination? alert?
            //if invalid input, page will not return to admin menu.
            Statement statement1 = connectionDB.createStatement();
            String query = String.format(pay_employees);
            System.out.println(query);
            ResultSet queryOutput = statement1.executeQuery(query);
            previous = 23;

            root = FXMLLoader.load(getClass().getResource("screen23.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();



        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING, "This employee has already worked for this bank.");
            alert.show();

        }
    }


}
