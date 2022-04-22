package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Screen4Controller extends Screen19Login implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button cancelButton;
    public Button getCancelButton() {
        return cancelButton;
    }

    @FXML
    private Button createButton;
    public Button getCreateButton() {
        return createButton;
    }

    @FXML
    private ComboBox selectUserCombo;
    public ComboBox getSelectUserCombo() {
        return selectUserCombo;
    }

    public void goToManageUsers_cancel(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen1.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToManageUsers_create(ActionEvent actionEvent) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String createCustomer = ";";
        try {
            //TODO

            root = FXMLLoader.load(getClass().getResource("screen1.fxml"));
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
        String selectUsers = "select perID from person;";
        try {
            Statement statement1 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(selectUsers);

            ArrayList<String> userList = new ArrayList<>();
            while (queryOutput1.next()) {
                userList.add(queryOutput1.getString("perID"));
            }
            selectUserCombo.getItems().addAll(userList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
