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
            root = FXMLLoader.load(getClass().getResource("screen21.fxml"));
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
        String createCustomer = "call start_customer_role('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');";
        //perID, taxID, fN, lN, bDate, street, city, state, zip, dtJoined, cus_password
        try {
            String perID = String.valueOf(selectUserCombo.getValue());
            String taxID = "";
            String fN = "";
            String lN = "";
            String bDate = "";
            String street = "";
            String city = "";
            String state = "";
            String zip = "";
            String dtJoined = "";
            String cus_password = "";

            String getInfo = "select * from bank_user where bank_user.perID = '%s';";
            Statement statement1 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(String.format(getInfo, perID));
            queryOutput1.next();
            taxID = queryOutput1.getString("taxID");
            fN = queryOutput1.getString("firstName");
            lN = queryOutput1.getString("lastName");
            bDate = queryOutput1.getString("birthdate");
            street = queryOutput1.getString("street");
            city = queryOutput1.getString("city");
            state = queryOutput1.getString("state");
            zip = queryOutput1.getString("zip");
            dtJoined = queryOutput1.getString("dtJoined");
            String getInfo2 = "select pwd from person where person.perID = perID;";
            Statement statement2 = connectionDB.createStatement();
            ResultSet queryOutput2 = statement2.executeQuery(getInfo2);
            queryOutput2.next();
            cus_password = queryOutput2.getString("pwd");

            String query = String.format(createCustomer, perID, taxID, fN, lN, bDate, street, city, state, zip,
                    dtJoined, cus_password);
            Statement statement3 = connectionDB.createStatement();
            ResultSet queryOutput3 = statement3.executeQuery(query);

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
