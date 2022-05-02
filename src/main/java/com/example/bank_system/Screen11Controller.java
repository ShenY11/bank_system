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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class Screen11Controller  implements Initializable {
    @FXML
    private TextField amountDepositTextField;
    @FXML
    private ComboBox bankDepositCombo;
    @FXML
    private ComboBox accountDepositCombo;
    @FXML
    private ComboBox bankWithdrawCombo;
    @FXML
    private ComboBox accountWithdrawCombo;
    @FXML
    private TextField amountWithdrawTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void backToCustomerScreen(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen24.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toCustomerMenu(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen24.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private String getDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public void deposit(ActionEvent actionEvent) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String accountDeposit = "call account_deposit('%s', %d, '%s', '%s', '%s');";

        String date = getDate();

        try {
            int amount = 0;
            try{
                amount = Integer.parseInt(amountDepositTextField.getText());
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Please enter a valid integer for deposit AMOUNT.");
                alert.show();
            }
            String bankID = String.valueOf(bankDepositCombo.getValue());
            String accountID = String.valueOf(accountDepositCombo.getValue());
            Screen19Login controller19 = new Screen19Login();
            String perID = controller19.getID();

            Statement statement = connectionDB.createStatement();
            String query = String.format(accountDeposit, perID, amount, bankID, accountID, date);
            ResultSet queryOutput = statement.executeQuery(query);

            root = FXMLLoader.load(getClass().getResource("screen24.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Please enter valid inputs");
            alert.show();
        }
    }

    public void withdraw(ActionEvent actionEvent) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String accountWithdrawal = "call account_withdrawal('%s', %d, '%s', '%s', '%s');";

        String date = getDate();

        try {
            int amount = 0;
            try{
                amount = Integer.parseInt(amountWithdrawTextField.getText());
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Please enter a valid integer for deposit AMOUNT.");
                alert.show();
            }
            String bankID = String.valueOf(bankWithdrawCombo.getValue());
            String accountID = String.valueOf(accountWithdrawCombo.getValue());
            Screen19Login controller19 = new Screen19Login();
            String perID = controller19.getID();

            Statement statement = connectionDB.createStatement();
            String query = String.format(accountWithdrawal, perID, amount, bankID, accountID, date);
            ResultSet queryOutput = statement.executeQuery(query);

            root = FXMLLoader.load(getClass().getResource("screen24.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Please enter valid inputs");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String getBankID = "select distinct bankID as bankID from access;";
        String getAccountID = "select distinct accountID as accountID from access;";
        try {
            Statement statement1 = connectionDB.createStatement();
            Statement statement2 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(getBankID);
            ResultSet queryOutput2 = statement2.executeQuery(getAccountID);

            ArrayList<String> bankIDlist = new ArrayList<>();
            ArrayList<String> accountIDList = new ArrayList<>();

            while (queryOutput1.next()) {
                bankIDlist.add(queryOutput1.getString("bankID"));
            }
            while (queryOutput2.next()) {
                accountIDList.add(queryOutput2.getString("accountID"));
            }
            bankDepositCombo.getItems().addAll(bankIDlist);
            bankWithdrawCombo.getItems().addAll(bankIDlist);
            accountDepositCombo.getItems().addAll(accountIDList);
            accountWithdrawCombo.getItems().addAll(accountIDList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
