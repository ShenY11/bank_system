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

public class Screen15Controller implements Initializable {
    public TableView tableView;
    @FXML
    private TableColumn bankIDColumn;
    @FXML
    private TableColumn corporationColumn;
    @FXML
    private TableColumn bankColumn;
    @FXML
    private TableColumn streetColumn;
    @FXML
    private TableColumn zipColumn;
    @FXML
    private TableColumn cityColumn;
    @FXML
    private TableColumn stateColumn;
    @FXML
    private TableColumn numAccountColumn;
    @FXML
    private TableColumn bankAssetsColumn;
    @FXML
    private TableColumn totalAssetsColumn;

    private static ObservableList<BankStats15> observableList;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectionDB = connectionNow.getConnection();
            String bankStatsQuery = "SELECT * FROM bank_management.display_bank_stats;";
            Statement statement = connectionDB.createStatement();
            ResultSet rs = statement.executeQuery(bankStatsQuery);

            observableList = FXCollections.observableArrayList();

            while (rs.next()) {
                String bankID = rs.getString("bank_identifier");
                String corporationName = rs.getString("name_of_corporation");
                String bankName = rs.getString("name_of_bank");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");
                Integer numAccounts = null;
                Integer bankAssets = null;
                Integer totalAssets = null;
                try {
                    numAccounts = Integer.parseInt(rs.getString("number_of_account"));
                    bankAssets = Integer.parseInt(rs.getString("bank_assets"));
                    totalAssets = Integer.parseInt(rs.getString("total_assets"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                observableList.add(new BankStats15(bankID, corporationName, bankName, street, city, state, zip,
                        numAccounts, bankAssets, totalAssets));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        bankIDColumn.setCellValueFactory(new PropertyValueFactory<>("bankID"));
        corporationColumn.setCellValueFactory(new PropertyValueFactory<>("corporationName"));
        bankColumn.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
        zipColumn.setCellValueFactory(new PropertyValueFactory<>("zip"));
        numAccountColumn.setCellValueFactory(new PropertyValueFactory<>("numAccounts"));
        bankAssetsColumn.setCellValueFactory(new PropertyValueFactory<>("bankAssets"));
        totalAssetsColumn.setCellValueFactory(new PropertyValueFactory<>("totalAssets"));
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
