package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.sql.Connection;
import java.util.ResourceBundle;

public class Screen12Controller implements Initializable {
    @FXML
    private ComboBox bankToCombo;
    @FXML
    private ComboBox accountToCombo;
    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox accountFromCombo;
    @FXML
    private ComboBox bankFromCombo;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void backToMenu(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen24.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void confirmTransfer(ActionEvent actionEvent) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String accountTransfer = "call account_transfer('%s', %d, '%s', '%s', '%s', '%s', '%s');";

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(date);

        String bankAccountQuery = "select perID, bankID, accountID from access;";
        try {
            int amount = 0;
            try{
                amount = Integer.parseInt(amountTextField.getText());
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Please enter a valid integer for AMOUNT.");
                alert.show();
            }

            String bankFrom = String.valueOf(bankFromCombo.getValue());
            String accountFrom = String.valueOf(accountFromCombo.getValue());
            String bankTo = String.valueOf(bankToCombo.getValue());
            String accountTo = String.valueOf(accountToCombo.getValue());
            Screen19Login controller19 = new Screen19Login();
            String perID = controller19.getID();

            Statement statement1 = connectionDB.createStatement();
            ResultSet bankAccountQueryOutput = statement1.executeQuery(bankAccountQuery);
            boolean validFromAccess = false;
            boolean validToAccess = false;

            while (bankAccountQueryOutput.next() ) {
                String queryIDNow = bankAccountQueryOutput.getString("perID");
                String queryBankIDNow = bankAccountQueryOutput.getString("bankID");
                String queryAccountIDNow = bankAccountQueryOutput.getString("accountID");

                if (perID.compareTo(queryIDNow) == 0 && bankFrom.compareTo(queryBankIDNow) == 0
                        && accountFrom.compareTo(queryAccountIDNow) == 0) {
                    validFromAccess = true;
                }
                if (perID.compareTo(queryIDNow) == 0 && bankTo.compareTo(queryBankIDNow) == 0
                        && accountTo.compareTo(queryAccountIDNow) == 0) {
                    validToAccess = true;
                }
                if (validFromAccess && validToAccess) break;
            }

            if (!(validFromAccess && validToAccess)) {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "You don't have access to at least one bank account.");
                alert.show();
            }

            Statement statement = connectionDB.createStatement();
            String query = String.format(accountTransfer, perID, amount, bankFrom, accountFrom, bankTo, accountTo, strDate);
            ResultSet queryOutput = statement.executeQuery(query);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Transfer successfully.");
            alert.show();

        } catch (Exception e) {
            e.printStackTrace();
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
            bankFromCombo.getItems().addAll(bankIDlist);
            bankToCombo.getItems().addAll(bankIDlist);
            accountFromCombo.getItems().addAll(accountIDList);
            accountToCombo.getItems().addAll(accountIDList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}