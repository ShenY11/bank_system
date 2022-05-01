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
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Screen9Controller extends Screen19Login implements Initializable{
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
    private ComboBox account;
    public ComboBox getAccount() {
        return account;
    }

    @FXML
    private TextField feetype;
    public TextField getFeetype() { return feetype; }

    private String feetext;
    private String bankID ;
    private String accountName;


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void bank(ActionEvent actionEvent) {
        bankID = String.valueOf(bank.getValue());

    }

    public void account(ActionEvent actionEvent) {
       accountName = String.valueOf(account.getValue());
    }

    public void feetype(ActionEvent actionEvent) {
        try {
            feetext = feetype.getText();

            System.out.println(feetext);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid fee type");
            alert.show();

        }

    }


    public void back(ActionEvent actionEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("screen"+previous+".fxml"));
        previous = 9;
        System.out.println("after:" +previous);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void confirm(ActionEvent actionEvent) {


        try {
            feetext = feetype.getText();
            //System.out.println(feetext);
            if (feetext.isEmpty()) {
                System.out.println(feetext);
                Alert alert = new Alert(Alert.AlertType.WARNING, "please enter the fee type for the account");
                alert.show();
                return;

            }
            System.out.println(bankID+accountName);
            if (bankID == null || accountName == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING, "please choose both the bank and the account");
                alert.show();
                return;

            }



        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please choose both bankID and accountID or enter valid fee type for the account");
            alert.show();
            return;

        }

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String new_fee = "call create_fee ('%s', '%s', '%s');";


        try {

            //TODO: input examination? alert?
            //if invalid input, page will not return to admin menu.
            Statement statement1 = connectionDB.createStatement();
            String query = String.format(new_fee,bankID,accountName,feetext);
            System.out.println(query);
            ResultSet queryOutput = statement1.executeQuery(query);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "create fee successfully.");
            alert.show();
/**
            root = FXMLLoader.load(getClass().getResource("screen"+previous+".fxml"));
            previous = 9;
            System.out.println("after:" +previous);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
 **/
        }catch (NullPointerException npe) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose both a bank and a account");
            alert.show();


        } catch (Exception e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.WARNING, "This fee has already been created or the account doesn't exist");
            alert.show();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String getBankID = "select bankID from bank;";
        String getAccountName = "select accountID from bank_account;";
        try {
            Statement statement1 = connectionDB.createStatement();
            //Statement statement2 = connectionDB.createStatement();
            Statement statement3 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(getBankID);
            //ResultSet queryOutput2 = statement2.executeQuery(getManagerName);
            ResultSet queryOutput3 = statement3.executeQuery(getAccountName);

            ArrayList<String> bankIDlist = new ArrayList<>();
            //ArrayList<String> managerNameList = new ArrayList<>();
            ArrayList<String> accountNameList = new ArrayList<>();
            while (queryOutput1.next()) {
                bankIDlist.add(queryOutput1.getString("bankID"));
            }

            while (queryOutput3.next()) {
                accountNameList.add(queryOutput3.getString("accountID"));
            }
            bank.getItems().addAll(bankIDlist);
            account.getItems().addAll(accountNameList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
