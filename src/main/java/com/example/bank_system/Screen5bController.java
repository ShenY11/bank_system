package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Screen5bController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox customerIDCombo;
    public ComboBox getCustomerIDCombo() {
        return customerIDCombo;
    }

    @FXML
    private Button backButton;
    public Button getBackButton() {
        return backButton;
    }

    @FXML
    private Button confirmButton;
    public Button getConfirmButton() {
        return confirmButton;
    }

    public void goToManageUsers_back(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen21.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToManageUsers_confirm(ActionEvent actionEvent) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String stopCustomer = "call stop_customer_role('%s');";
        try {
            String perID = String.valueOf(customerIDCombo.getValue());
            String query = String.format(stopCustomer, perID);
            Statement statement1 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(query);
            root = FXMLLoader.load(getClass().getResource("screen21.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String selectUsers = "select perID from customer;";
        try {
            Statement statement1 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(selectUsers);

            ArrayList<String> userList = new ArrayList<>();
            while (queryOutput1.next()) {
                userList.add(queryOutput1.getString("perID"));
            }
            customerIDCombo.getItems().addAll(userList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
