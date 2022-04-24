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

public class Screen18Controller implements Initializable {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn perIDColumn;
    @FXML
    private TableColumn taxIDColumn;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn dobColumn;
    @FXML
    private TableColumn dateJoinedColumn;
    @FXML
    private TableColumn streetColumn;
    @FXML
    private TableColumn cityColumn;
    @FXML
    private TableColumn stateColumn;
    @FXML
    private TableColumn zipColumn;
    @FXML
    private TableColumn numBanksColumn;
    @FXML
    private TableColumn bankAssetsColumn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static ObservableList<EmployeeStats18> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectionDB = connectionNow.getConnection();
            String employeeStatsQuery = "SELECT * FROM bank_management.display_employee_stats;";
            Statement statement = connectionDB.createStatement();
            ResultSet rs = statement.executeQuery(employeeStatsQuery);

            observableList = FXCollections.observableArrayList();

            while (rs.next()) {
                String perID = rs.getString("person_identification");
                String taxID = rs.getString("tax_identidication");
                String name = rs.getString("employee_name");
                String DOB = rs.getString("birthdate");
                String dateJoined = rs.getString("dtJoined");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");
                Integer numBanks = null;
                Integer bankAssets = null;
                try {
                    numBanks = Integer.parseInt(rs.getString("number_bank"));
                    bankAssets = Integer.parseInt(rs.getString("bank_assets"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                observableList.add(new EmployeeStats18(perID, taxID, name, DOB,
                        dateJoined, street, city, state, zip, numBanks, bankAssets));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        perIDColumn.setCellValueFactory(new PropertyValueFactory<>("perID"));
        taxIDColumn.setCellValueFactory(new PropertyValueFactory<>("taxID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        dateJoinedColumn.setCellValueFactory(new PropertyValueFactory<>("dateJoined"));
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
        zipColumn.setCellValueFactory(new PropertyValueFactory<>("zip"));
        numBanksColumn.setCellValueFactory(new PropertyValueFactory<>("numBanks"));
        bankAssetsColumn.setCellValueFactory(new PropertyValueFactory<>("bankAssets"));
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
