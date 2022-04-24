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

public class Screen16Controller implements Initializable {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn corporationColumn;
    @FXML
    private TableColumn shortNameColumn;
    @FXML
    private TableColumn formalNameColumn;
    @FXML
    private TableColumn numBanksColumn;
    @FXML
    private TableColumn corporationAssetsColumn;
    @FXML
    private TableColumn totalAssetsColumn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static ObservableList<CorporationStats16> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectionDB = connectionNow.getConnection();
            String corporationStatsQuery = "SELECT * FROM bank_management.display_corporation_stats;";
            Statement statement = connectionDB.createStatement();
            ResultSet rs = statement.executeQuery(corporationStatsQuery);

            observableList = FXCollections.observableArrayList();

            while (rs.next()) {
                String corporationID = rs.getString("corporation_identifier");
                String shortName = rs.getString("short_name");
                String formalName = rs.getString("formal_name");
                Integer numBanks = null;
                Integer corporationAssets = null;
                Integer totalAssets = null;
                try {
                    numBanks = Integer.parseInt(rs.getString("number_of_banks"));
                    corporationAssets = Integer.parseInt(rs.getString("corporation_assets"));
                    totalAssets = Integer.parseInt(rs.getString("total_assets"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                observableList.add(new CorporationStats16(corporationID, shortName, formalName, numBanks,
                        corporationAssets, totalAssets));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        corporationColumn.setCellValueFactory(new PropertyValueFactory<>("corporationID"));
        shortNameColumn.setCellValueFactory(new PropertyValueFactory<>("shortName"));
        formalNameColumn.setCellValueFactory(new PropertyValueFactory<>("formalName"));
        numBanksColumn.setCellValueFactory(new PropertyValueFactory<>("numBanks"));
        corporationAssetsColumn.setCellValueFactory(new PropertyValueFactory<>("corporationAssets"));
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
