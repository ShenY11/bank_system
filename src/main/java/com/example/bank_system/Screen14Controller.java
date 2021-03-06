package com.example.bank_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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

    private Stage stage;
    private Scene scene;
    private Parent root;

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
                String bank = rs.getString("name_of_bank");
                String accountID = rs.getString("account_identifier");
                Long balance = null;
                Integer numOwners = null;
                try {
                    balance = Long.parseLong(rs.getString("account_assets"));
                } catch (Exception e) {}

                try {
                    numOwners = Integer.parseInt(rs.getString("number_of_owners"));
                } catch (Exception e) {}
                observableList.add(new AccountStats14(bank, accountID, balance,numOwners));
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

    public void backToViewStats(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen22.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
