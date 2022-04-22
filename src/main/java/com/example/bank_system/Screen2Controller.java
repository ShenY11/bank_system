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

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Screen2Controller extends Screen19Login implements Initializable {
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
    private TextField bankIDTextfield;
    public TextField getBankIDTextfield() {
        return bankIDTextfield;
    }

    @FXML
    private TextField bankNameTextfield;
    public TextField getBankNameTextfield() {
        return bankNameTextfield;
    }

    @FXML
    private TextField streetTextfield;
    public TextField getStreetTextfield() {
        return streetTextfield;
    }

    @FXML
    private TextField cityTextfield;
    public TextField getCityTextfield() {
        return cityTextfield;
    }

    @FXML
    private TextField stateTextfield;
    public TextField getStateTextfield() {
        return stateTextfield;
    }

    @FXML
    private TextField zipCodeTextfield;
    public TextField getZipCodeTextfield() {
        return zipCodeTextfield;
    }

    @FXML
    private TextField resAssetsTextfield;
    public TextField getResAssetsTextfield() {
        return resAssetsTextfield;
    }

    @FXML
    private ComboBox corpIDCombo;
    public ComboBox getCorpIDCombo() {
        return corpIDCombo;
    }

    @FXML
    private ComboBox managerIDCombo;
    public ComboBox getManagerIDCombo() {
        return managerIDCombo;
    }

    @FXML
    private ComboBox employeeNameCombo;
    public ComboBox getEmployeeNameCombo() {
        return employeeNameCombo;
    }


    public void goToAdminMenu_cancel(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen20.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToAdminMenu_create(ActionEvent actionEvent) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String createBank = "call create_bank('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s');";

        try {
            String bankID = bankIDTextfield.getText();
            String bankName = bankNameTextfield.getText();
            String street = streetTextfield.getText();
            String city = cityTextfield.getText();
            String state = stateTextfield.getText();
            String zip = zipCodeTextfield.getText();

            String corpID = String.valueOf(corpIDCombo.getValue());
            String manageId = String.valueOf(managerIDCombo.getValue());
            String employeeName = String.valueOf(employeeNameCombo.getValue());

            //TODO: input examination? alert?
            //if invalid input, page will not return to admin menu.
            boolean resProblem = false;
            for (char i : resAssetsTextfield.getText().toCharArray()) {
                if ((int)i > 57 || (int) i < 48) {
                    resProblem = true;
                    break;
                }
            }
            if (state.length() > 2 || resProblem || bankID == "" || corpID == "" || manageId == "" || employeeName == "") {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Please enter valid values");
                alert.show();
            }
            int resAssets = Integer.valueOf(resAssetsTextfield.getText());

            Statement statement1 = connectionDB.createStatement();
            String query = String.format(createBank, bankID, bankName, street, city, state, zip, resAssets, corpID, manageId, employeeName);
            System.out.println(query);
            ResultSet queryOutput = statement1.executeQuery(query);

            root = FXMLLoader.load(getClass().getResource("screen20.fxml"));
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
        String getCorpID = "select corpID from corporation;";
        String getManagerName = "select perID from employee where perID not in (select perID from employee join bank on manager = perID);";
        String getEmployeeName = "select perID from employee;";
        try {
            Statement statement1 = connectionDB.createStatement();
            Statement statement2 = connectionDB.createStatement();
            Statement statement3 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(getCorpID);
            ResultSet queryOutput2 = statement2.executeQuery(getManagerName);
            ResultSet queryOutput3 = statement3.executeQuery(getEmployeeName);

            ArrayList<String> corpIDlist = new ArrayList<>();
            ArrayList<String> managerNameList = new ArrayList<>();
            ArrayList<String> employeeNameList = new ArrayList<>();
            while (queryOutput1.next()) {
                corpIDlist.add(queryOutput1.getString("corpID"));
            }
            while (queryOutput2.next()) {
                managerNameList.add(queryOutput2.getString("perID"));
            }
            while (queryOutput3.next()) {
                employeeNameList.add(queryOutput3.getString("perID"));
            }
            corpIDCombo.getItems().addAll(corpIDlist);
            managerIDCombo.getItems().addAll(managerNameList);
            employeeNameCombo.getItems().addAll(employeeNameList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
