package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Screen3Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox selectUserCombo;
    public ComboBox getSelectUserCombo() {
        return selectUserCombo;
    }

    @FXML
    private TextField salaryTextfield;
    public TextField getSalaryTextfield() {
        return salaryTextfield;
    }

    @FXML
    private TextField numOfPaymentsTextfield;
    public TextField getNumOfPaymentsTextfield() {
        return numOfPaymentsTextfield;
    }

    @FXML
    private TextField accuEarningsTextfield;
    public TextField getAccuEarningsTextfield() {
        return accuEarningsTextfield;
    }

    @FXML
    private TextField perIDText;
    public TextField getPerIDText() {
        return perIDText;
    }

    @FXML
    private TextField taxIDText;
    public TextField getTaxIDText() {
        return taxIDText;
    }

    @FXML
    private TextField fNameText;
    public TextField getfNameText() {
        return fNameText;
    }

    @FXML
    private TextField lNameText;
    public TextField getlNameText() {
        return lNameText;
    }

    @FXML
    private TextField bDateText;
    public TextField getbDateText() {
        return bDateText;
    }

    @FXML
    private TextField streetText;
    public TextField getStreetText() {
        return streetText;
    }

    @FXML
    private TextField cityText;
    public TextField getCityText() {
        return cityText;
    }

    @FXML
    private TextField stateText;
    public TextField getStateText() {
        return stateText;
    }

    @FXML
    private TextField zipText;
    public TextField getZipText() {
        return zipText;
    }

    @FXML
    private TextField dtJoinedText;
    public TextField getDtJoinedText() {
        return dtJoinedText;
    }

    @FXML
    private TextField passwordText;
    public TextField getPasswordText() {
        return passwordText;
    }

    @FXML
    private CheckBox alreadyCheck;
    public CheckBox getAlreadyCheck() {
        return alreadyCheck;
    }

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
        String createEmployee = "call start_employee_role('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',%d,%d,%d,'%s');";
                                                    //perID, taxID, fN, lN, bDate, street, city, state, zip, dtJoined, salary, payments, earned,  emp_password
        try {
            String perID = "";
            String taxID = "";
            String fN = "";
            String lN = "";
            String bDate = "";
            String street = "";
            String city = "";
            String state = "";
            String zip = "";
            String dtJoined = "";
            int salary = Integer.valueOf(salaryTextfield.getText());
            int payments = Integer.valueOf(numOfPaymentsTextfield.getText());
            int earned = Integer.valueOf(accuEarningsTextfield.getText());
            if (salary == 0 || payments == 0 || earned == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Please enter valid inputs");
                alert.show();
            }
            String password = "";
            System.out.println(alreadyCheck.isSelected());
            if (alreadyCheck.isSelected()) {
                perID = String.valueOf(selectUserCombo.getValue());
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
                password = queryOutput2.getString("pwd");

                String query = String.format(createEmployee, perID, taxID, fN, lN, bDate, street, city, state, zip,
                        dtJoined, salary,payments,earned,password);
                Statement statement3 = connectionDB.createStatement();
                ResultSet queryOutput3 = statement3.executeQuery(query);
            } else {
                perID = perIDText.getText();
                taxID = taxIDText.getText();
                fN = fNameText.getText();
                lN = lNameText.getText();
                bDate = bDateText.getText();
                street = streetText.getText();
                city = cityText.getText();
                state = stateText.getText();
                zip = zipText.getText();
                dtJoined = dtJoinedText.getText();
                password = passwordText.getText();

                String query = String.format(createEmployee, perID, taxID, fN, lN, bDate, street, city, state, zip,
                        dtJoined, salary,payments,earned,password);
                Statement statement3 = connectionDB.createStatement();
                ResultSet queryOutput3 = statement3.executeQuery(query);
            }

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
