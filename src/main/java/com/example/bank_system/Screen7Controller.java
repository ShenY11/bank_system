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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Screen7Controller extends Screen19Login implements Initializable {
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

    public TextField getNewsalary() {
        return newsalary;
    }

    private Integer salary;
    private String bankID;
    private String employeeName;


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void bank(ActionEvent actionEvent) {
        bankID = String.valueOf(bank.getValue());

    }

    public void employee(ActionEvent actionEvent) {
        employeeName = String.valueOf(employee.getValue());
    }

    public void salary(ActionEvent actionEvent) {
        try {
            String salarytext = newsalary.getText();
            salary = Integer.parseInt(salarytext);
            System.out.println(salary);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid salary");
            alert.show();

        }
    }


    public void back(ActionEvent actionEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("screen"+previous+".fxml"));
        previous = 7;
        System.out.println("after:" +previous);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void confirm(ActionEvent actionEvent) {
        try {
            String salarytext = newsalary.getText();
            salary = Integer.parseInt(salarytext);
            System.out.println(salary);

        } catch (RuntimeException e) {
            //Alert alert = new Alert(Alert.AlertType.WARNING, "Please set the salary for the employee");
            //alert.show();
            //return;
        }

        if (employeeName == null || bankID == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose both a bank and a employee");
            alert.show();
        }


        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String hire_worker = "call replace_manager('%s', '%s', %d);";



        try {

            //TODO: input examination? alert?
            //if invalid input, page will not return to admin menu.
            Statement statement1 = connectionDB.createStatement();
            String query = String.format(hire_worker, employeeName, bankID, salary);
            System.out.println(query);
            ResultSet queryOutput = statement1.executeQuery(query);
            /**
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "replace successfully.");
            alert.show();
             **/

            root = FXMLLoader.load(getClass().getResource("screen"+previous+".fxml"));
            previous = 7;
            System.out.println("after:" +previous);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose both a bank and a employee");
            alert.show();


        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.WARNING, "This employee has already worked for this bank.");
            alert.show();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String getBankID = "select bankID from bank;";
        String getEmployeeName = "select perID from employee where perID not in (SELECT perID FROM workFor) and perID not in (select manager from bank);";
        try {
            Statement statement1 = connectionDB.createStatement();
            //Statement statement2 = connectionDB.createStatement();
            Statement statement3 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(getBankID);
            //ResultSet queryOutput2 = statement2.executeQuery(getManagerName);
            ResultSet queryOutput3 = statement3.executeQuery(getEmployeeName);

            ArrayList<String> bankIDlist = new ArrayList<>();
            //ArrayList<String> managerNameList = new ArrayList<>();
            ArrayList<String> employeeNameList = new ArrayList<>();
            while (queryOutput1.next()) {
                bankIDlist.add(queryOutput1.getString("bankID"));
            }

            while (queryOutput3.next()) {
                employeeNameList.add(queryOutput3.getString("perID"));
            }
            bank.getItems().addAll(bankIDlist);
            employee.getItems().addAll(employeeNameList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
