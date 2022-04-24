package com.example.bank_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Screen14Controller implements Initializable {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn bankColumn;
    @FXML
    private TableColumn accountIDColumn;
    @FXML
    private TableColumn accountBalanceColumn;
    @FXML
    private TableColumn numOwnersColumn;

    private static ObservableList<AccountStats14> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectionDB = connectionNow.getConnection();
            String accountStatsQuery = "SELECT * FROM bank_management.display_account_stats;";
            Statement statement = connectionDB.createStatement();
            ResultSet rs = statement.executeQuery(accountStatsQuery);

            observableList = FXCollections.observableArrayList();

            while (rs.next()) {
                //rs.getString("name_of_bank") == null ? "" :
                String bank = rs.getString("name_of_bank");
                //rs.getString("account_identifier") == null ? "" :
                String accountID = rs.getString("account_identifier");
                Integer balance = null;
                Integer numOwners = null;
                try {
                    balance = Integer.parseInt(rs.getString("account_assets"));
                    numOwners = Integer.parseInt(rs.getString("number_of_owners"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                observableList.add(new AccountStats14(bank, accountID, balance,numOwners));
                System.out.println(bank + " " + accountID + " " + balance + " " + numOwners);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        bankColumn.setCellValueFactory(new PropertyValueFactory<>("bank"));
        accountIDColumn.setCellValueFactory(new PropertyValueFactory<>("accountID"));
        accountBalanceColumn.setCellValueFactory(new PropertyValueFactory<>("acountBalance"));
        numOwnersColumn.setCellValueFactory(new PropertyValueFactory<>("numOwners"));
        tableView.setItems(observableList);
    }
}
