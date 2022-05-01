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

public class Screen17Controller implements Initializable {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn customerID;
    @FXML
    private TableColumn tAXID;
    @FXML
    private TableColumn customerName;
    @FXML
    private TableColumn dOB;
    @FXML
    private TableColumn joinedDate;
    @FXML
    private TableColumn street;

    @FXML
    private TableColumn city;
    @FXML
    private TableColumn state;
    @FXML
    private TableColumn zip;
    @FXML
    private TableColumn numberOfAccounts;
    @FXML
    private TableColumn customerAssets;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static ObservableList<CustomerStats17> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectionDB = connectionNow.getConnection();
            String corporationStatsQuery = "SELECT * FROM bank_management.display_customer_stats;";
            Statement statement = connectionDB.createStatement();
            ResultSet rs = statement.executeQuery(corporationStatsQuery);

            observableList = FXCollections.observableArrayList();

            while (rs.next()) {
                //System.out.println(run);
                String person_identification = rs.getString("person_identification");
                System.out.println(person_identification);
                String tax_identification = rs.getString("tax_identification");
                System.out.println(tax_identification);
                String constomer_name = rs.getString("constomer_name");
                System.out.println(constomer_name);
                String street = rs.getString("street");
                System.out.println(street);
                String city = rs.getString("city");
                System.out.println(city);
                String state = rs.getString("state");
                System.out.println(state);
                String date_of_birth = rs.getString("date_of_birth");
                System.out.println(date_of_birth);
                String joined_system = rs.getString("joined_system");
                System.out.println(joined_system);
                //Long date_of_birth = null;
                //Long joined_system = null;
                String zip = rs.getString("zip");
                System.out.println(zip);
                Long number_of_account = null;
                System.out.println(number_of_account);
                Long customer_asset= null;
                System.out.println(customer_asset);
/**

                try {
                    date_of_birth = Long.parseLong(rs.getString("date_of_birth"));
                } catch (Exception e) {}

                try {
                    joined_system = Long.parseLong(rs.getString("joined_system"));
                } catch (Exception e) {}
**/

                try {
                    number_of_account = Long.parseLong(rs.getString("number_of_account"));
                } catch (Exception e) {}

                try {
                    customer_asset = Long.parseLong(rs.getString("customer_asset"));
                } catch (Exception e) {}
                System.out.println(person_identification+" "+tax_identification+" "+constomer_name+" "+street+" "+city+" "+state+" "+date_of_birth+" "+joined_system+" "+zip+" "+number_of_account+" "+customer_asset);

                observableList.add(new CustomerStats17(person_identification,tax_identification, constomer_name,street,city,state,
                        date_of_birth, joined_system,zip,number_of_account,customer_asset));
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

        customerID.setCellValueFactory(new PropertyValueFactory<>("person_identification1"));
        //System.out.println("1");
        tAXID.setCellValueFactory(new PropertyValueFactory<>("tax_identification1"));
        //System.out.println("2");
        customerName.setCellValueFactory(new PropertyValueFactory<>("constomer_name1"));
        //System.out.println("3");
        dOB.setCellValueFactory(new PropertyValueFactory<>("date_of_birth1"));
        joinedDate.setCellValueFactory(new PropertyValueFactory<>("joined_system1"));
        street.setCellValueFactory(new PropertyValueFactory<>("street1"));
        city.setCellValueFactory(new PropertyValueFactory<>("city1"));
        state.setCellValueFactory(new PropertyValueFactory<>("state1"));
        zip.setCellValueFactory(new PropertyValueFactory<>("zip1"));
        numberOfAccounts.setCellValueFactory(new PropertyValueFactory<>("number_of_account1"));
        customerAssets.setCellValueFactory(new PropertyValueFactory<>("customer_asset1"));
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
