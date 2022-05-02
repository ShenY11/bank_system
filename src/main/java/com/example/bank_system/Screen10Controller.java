package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Screen10Controller extends Screen19Login implements Initializable{
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
    private ComboBox avaiableCheckingAccounts;
    public ComboBox getAvaiableCheckingAccounts() {
        return avaiableCheckingAccounts;
    }

    @FXML
    private ComboBox AvailableSavingsAccounts;
    public ComboBox getAvailableSavingsAccounts() {
        return AvailableSavingsAccounts;
    }

    @FXML
    private CheckBox overDraftPolicy;
    public  CheckBox getaddingOverDraftPolicy() { return overDraftPolicy; }

    private boolean OverDraftPolicy = false;

    private String  CheckingAccounts;
    private String SavingsAccounts;


    private Stage stage;
    private Scene scene;
    private Parent root;
    public void availableCheckingAccounts(ActionEvent actionEvent) {
        CheckingAccounts = String.valueOf(avaiableCheckingAccounts.getValue());
        System.out.println(CheckingAccounts);

    }

    public void AvailableSavingsAccounts(ActionEvent actionEvent) {
        SavingsAccounts = String.valueOf(AvailableSavingsAccounts.getValue());
        System.out.println(SavingsAccounts);
    }

    public void addingOverDraftPolicy(ActionEvent actionEvent) {
        System.out.println(overDraftPolicy.isSelected());
        OverDraftPolicy = !OverDraftPolicy;
        System.out.println("OverDraftPolicy"+OverDraftPolicy);
    }


    public void back(ActionEvent actionEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("screen"+previous+".fxml"));
        previous = 10;
        System.out.println("after:" +previous);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void confirm(ActionEvent actionEvent) {
        String start_overdraft;
        String stop_overdraft;
        String query;
            //call start_overdraft('tjtalbot4', 'TD_Online', 'company_checking', 'WF_2','savings_A');
            try {
                DatabaseConnection connectionNow = new DatabaseConnection();
                Connection connectionDB = connectionNow.getConnection();
                if (CheckingAccounts == null || SavingsAccounts == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose both a checking account and a saving account");
                    alert.show();
                }

                //TODO: input examination? alert?
                //if invalid input, page will not return to admin menu.
                Statement statement1 = connectionDB.createStatement();
                int comma = CheckingAccounts.indexOf(',');
                String bankcheckID = CheckingAccounts.substring(0, comma);
                String checkID = CheckingAccounts.substring(comma + 1);
                int comma2 = SavingsAccounts.indexOf(',');
                String banksavingsID = SavingsAccounts.substring(0, comma2);
                String savingsID = SavingsAccounts.substring(comma2 + 1);


                if (overDraftPolicy.isSelected()) {
                    start_overdraft = "call start_overdraft('%s', '%s', '%s','%s','%s');";
                    query = String.format(start_overdraft, ID, bankcheckID, checkID, banksavingsID, savingsID);
                    System.out.println(query);
                } else {
                    stop_overdraft = "call stop_overdraft('%s', '%s', '%s');";
                    query = String.format(stop_overdraft, ID, bankcheckID, checkID);
                    System.out.println(query);
                }


                ResultSet queryOutput = statement1.executeQuery(query);
/**
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "create new fee successfully.");
                alert.show();
 **/

                root = FXMLLoader.load(getClass().getResource("screen"+previous+".fxml"));
                previous = 10;
                System.out.println("after:" +previous);
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }catch (NullPointerException npe) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose both a checking account and a saving account");
                    alert.show();


            } catch (Exception e ) {
                e.printStackTrace();

                Alert alert = new Alert(Alert.AlertType.WARNING, "This overdraft has already been created/removed or either one of the savings or checking doesn't exist");
                alert.show();

            }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String getBankID = "select bankID from bank;";
        String bankchecking = "select bankID from checking;";
        String check = "select accountID from checking;";
        String banksavings = "select bankID from savings;";
        String savings = "select accountID from savings;";
        try {
            Statement statement1 = connectionDB.createStatement();
            Statement statement2 = connectionDB.createStatement();
            Statement statement3 = connectionDB.createStatement();
            Statement statement4 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(bankchecking);
            ResultSet queryOutput2 = statement2.executeQuery(check);
            ResultSet queryOutput3 = statement3.executeQuery(banksavings);
            ResultSet queryOutput4 = statement4.executeQuery(savings);

            ArrayList<String> bankcheckinglist = new ArrayList<>();
            ArrayList<String> checkList = new ArrayList<>();
            ArrayList<String> banksavingsList = new ArrayList<>();
            ArrayList<String> savingsList = new ArrayList<>();
            while (queryOutput1.next()) {
                System.out.println("BBBB" + queryOutput1.getString("bankID"));

                bankcheckinglist.add(queryOutput1.getString("bankID") );
                //checkList.add(queryOutput2.getString("accountID"));

            }
            int i = 0;

            while (queryOutput2.next()) {
                checkList.add(bankcheckinglist.get(i)+","+queryOutput2.getString("accountID"));
                i++;
            }



            int n = 0;
            while (queryOutput3.next()) {
                banksavingsList.add(queryOutput3.getString("bankID"));
            }

            while (queryOutput4.next()) {
                savingsList.add(banksavingsList.get(n)+","+queryOutput4.getString("accountID"));
                n++;
            }


            avaiableCheckingAccounts.getItems().addAll(checkList);
            AvailableSavingsAccounts.getItems().addAll(savingsList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
