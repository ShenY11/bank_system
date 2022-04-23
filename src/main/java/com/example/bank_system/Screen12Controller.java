package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.Connection;

public class Screen12Controller {
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

    public void selectBankFrom(ActionEvent actionEvent) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String accountTransfer = "call account_transfer('%s', %d, '%s', '%s', '%s', '%s', %d);";
    }

    public void selectAccountFrom(ActionEvent actionEvent) {
    }

    public void selectBankTo(ActionEvent actionEvent) {
    }

    public void selectAccountTo(ActionEvent actionEvent) {
    }
}
