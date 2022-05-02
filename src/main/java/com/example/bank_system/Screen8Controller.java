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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Screen8Controller extends Screen19Login implements Initializable{
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
    private ComboBox accessibleAccounts;
    public ComboBox getAccessibleAccounts() {
        return accessibleAccounts;
    }

    @FXML
    private ComboBox customer;
    public ComboBox getCustomer() {
        return customer;
    }


    @FXML
    private ComboBox bank;
    public ComboBox getbank() {
        return bank;
    }

    @FXML
    private TextField AccountID;
    public TextField getAccountID() {
        return AccountID;
    }

    @FXML
    private ComboBox accountType;
    public  ComboBox getaccountType() { return accountType; }

    @FXML
    private CheckBox addowner;
    public  CheckBox getAddowner() { return addowner; }


    @FXML
    private TextField balance;
    public TextField getbalance() { return balance; }
    @FXML
    private TextField minBalance;
    public TextField getminBalance() { return minBalance; }
    @FXML
    private TextField rate;
    public TextField getrate() { return rate; }
    @FXML
    private TextField withdrawals;
    public TextField getwithdrawals() { return withdrawals; }


    private String Accounts;
    private String ccustomer;
    private String ban;
    private String acctID;
    private String accttype;

    private Integer balan = null;
    private Integer mbala = null;
    private Integer rat = null;
    private Integer withdraw = null;



    private Stage stage;
    private Scene scene;
    private Parent root;

    public void accessibleAccounts(ActionEvent actionEvent) {
        Accounts = String.valueOf(accessibleAccounts.getValue());
        System.out.println(Accounts);

    }

    public void customer(ActionEvent actionEvent) {
        ccustomer = String.valueOf(customer.getValue());
        System.out.println(ccustomer);

    }

    public void bank(ActionEvent actionEvent) {
        ban = String.valueOf(bank.getValue());
        System.out.println(ban);

    }
    public void AccountID(ActionEvent actionEvent) {
        try {
            String acctID = AccountID.getText();
            System.out.println(acctID);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid Account ID");
            alert.show();
        }
        //acctID = String.valueOf(AccountID.getValue());
        //System.out.println(acctID);
    }

    public void accountType(ActionEvent actionEvent) {
        accttype = String.valueOf(accountType.getValue());
        System.out.println(accttype);
    }

    public void addowner(ActionEvent actionEvent) {
        System.out.println(addowner.isSelected());
        //OverDraftPolicy = !OverDraftPolicy;
        //System.out.println("OverDraftPolicy"+OverDraftPolicy);
    }




    public void back(ActionEvent actionEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("screen"+previous+".fxml"));
        previous = 8;
        System.out.println("after:" +previous);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void balance(ActionEvent actionEvent) {

        try {
            String salarytext = balance.getText();
            balan = Integer.parseInt(salarytext);
            System.out.println(balan);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid initial balance");
            alert.show();

        }
    }

    public void minBalance(ActionEvent actionEvent) {

        try {
            String salarytext = minBalance.getText();
            mbala = Integer.parseInt(salarytext);
            System.out.println(mbala);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid minimum balance");
            alert.show();

        }
    }

    public void rate(ActionEvent actionEvent) {

        try {
            String salarytext = rate.getText();
            rat = Integer.parseInt(salarytext);
            System.out.println(rat);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid rate");
            alert.show();

        }
    }

    public void withdrawals(ActionEvent actionEvent) {

        try {
            String salarytext = withdrawals.getText();
            withdraw = Integer.parseInt(salarytext);
            System.out.println(withdraw);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid withdrawls");
            alert.show();

        }
    }

    public void confirm(ActionEvent actionEvent) {
        //if (addowner.isSelected()) {
        /**
        try {
            String salarytext = balance.getText();
            balan = Integer.parseInt(salarytext);
            System.out.println(balan);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid initial balance");
            alert.show();
            return;

        }
        try {
            String salarytext = minBalance.getText();
            mbala = Integer.parseInt(salarytext);
            System.out.println(mbala);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid minimum balance");
            alert.show();
            return;

        }

        try {
            String salarytext = rate.getText();
            rat = Integer.parseInt(salarytext);
            System.out.println(rat);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid rate");
            alert.show();
            return;

        }

        try {
            String salarytext = withdrawals.getText();
            withdraw = Integer.parseInt(salarytext);
            System.out.println(withdraw);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid withdrawls");
            alert.show();
            return;

        }

        try {
            acctID = AccountID.getText();
            System.out.println(acctID);
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid Account ID");
            alert.show();
        }

        if (ccustomer == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose a customer");
            alert.show();
            return;
        }

        if (accttype == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose an account type");
            alert.show();
            return;
        }
***/
        if (ccustomer == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose a customer");
            alert.show();
            return;
        }



        String add_account_access;
        String remove_account_access;
        String query;
            //call start_overdraft('tjtalbot4', 'TD_Online', 'company_checking', 'WF_2','savings_A');
            try {
                DatabaseConnection connectionNow = new DatabaseConnection();
                Connection connectionDB = connectionNow.getConnection();

                //TODO: input examination? alert?
                //if invalid input, page will not return to admin menu.
                Statement statement1 = connectionDB.createStatement();




                if (addowner.isSelected()) {
                    try {
                        String salarytext = balance.getText();
                        balan = Integer.parseInt(salarytext);
                        System.out.println(balan);
                    } catch (RuntimeException e) {
                        //e.printStackTrace();
                        //balan = null;
                        //Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid initial balance");
                        //alert.show();
                        //return;

                    }
                    try {
                        String salarytext = minBalance.getText();
                        mbala = Integer.parseInt(salarytext);
                        System.out.println(mbala);
                    } catch (RuntimeException e) {
                        //e.printStackTrace();
                        //Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid minimum balance");
                        //alert.show();
                        //return;

                    }

                    try {
                        String salarytext = rate.getText();
                        rat = Integer.parseInt(salarytext);
                        System.out.println(rat);
                    } catch (RuntimeException e) {
                        //e.printStackTrace();
                        //Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid rate");
                        //alert.show();
                        //return;

                    }

                    try {
                        String salarytext = withdrawals.getText();
                        withdraw = Integer.parseInt(salarytext);
                        System.out.println(withdraw);
                    } catch (RuntimeException e) {
                        //e.printStackTrace();
                        //Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid withdrawls");
                        //alert.show();
                        //return;

                    }



                    try {
                        acctID = AccountID.getText();
                        System.out.println(acctID);
                    } catch (RuntimeException e) {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid Account ID");
                        alert.show();
                    }


                    if (accttype == null) {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose an account type");
                        alert.show();
                        return;
                    }
                    System.out.println("add");
                    String bi;
                    String ai;



                    if ((Accounts == null && ban == null && acctID == null) || (ban == null && Accounts == null) || (acctID== null && Accounts == null)) {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Please choose either accessibleAccounts or bankID AND accountID");
                        alert.show();
                        System.out.println("select dropdown");
                        return;
                    } else if(Accounts == null) {
                        System.out.println("createnew account");
                        bi = ban;
                        ai = acctID;
                    } else {
                        System.out.println("add access");
                        int comma = Accounts.indexOf(',');
                        String bankavaiID = Accounts.substring(0, comma);
                        String avaiaccountID = Accounts.substring(comma + 1);
                        bi = bankavaiID;
                        ai = avaiaccountID;
                    }
                    LocalDate currentDay = LocalDate.now();
                    String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(currentDay);
                    add_account_access = "call add_account_access('%s', '%s', '%s','%s','%s',%d,%d,%d,%d,%d,%d,'%s');";

                    query = String.format(add_account_access, ID, ccustomer, accttype,bi,ai,balan,rat,null,mbala,null,withdraw,date);

                    System.out.println(query);
                } else {
                    if(Accounts == null) {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Please choose from accessibleAccounts");
                        alert.show();
                    }
                    System.out.println("remove");
                    remove_account_access = "call remove_account_access('%s', '%s', '%s', '%s');";
                    int comma = Accounts.indexOf(',');
                    String bankavaiID = Accounts.substring(0, comma);
                    String avaiaccountID = Accounts.substring(comma + 1);
                    query = String.format(remove_account_access, ID, ccustomer,bankavaiID,avaiaccountID);
                    System.out.println(query);
                }


                ResultSet queryOutput = statement1.executeQuery(query);
/**
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "add/remove successfully.");
                alert.show();
 **/

                root = FXMLLoader.load(getClass().getResource("screen"+previous+".fxml"));
                previous = 8;
                System.out.println("after:" +previous);
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }catch (NullPointerException npe) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "you must choose a accessible account");
                    alert.show();


            } catch (Exception e ) {
                e.printStackTrace();

                Alert alert = new Alert(Alert.AlertType.WARNING, "This account has already been created/removed or the customer don't have the ability to create account");
                alert.show();

            }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String getBankID = "select bankID from bank;";
        String getAccountID = "select accountID from bank_account;";
        String getcustomer = "select perID from customer;";
        String getexistBank = "select bankID from bank_account;";

        try {
            Statement statement1 = connectionDB.createStatement();
            Statement statement2 = connectionDB.createStatement();
            Statement statement3 = connectionDB.createStatement();
            Statement statement4 = connectionDB.createStatement();
            ResultSet queryOutput1 = statement1.executeQuery(getBankID);
            ResultSet queryOutput2 = statement2.executeQuery(getAccountID);
            ResultSet queryOutput3 = statement3.executeQuery(getcustomer);
            ResultSet queryOutput4 = statement4.executeQuery(getexistBank);

            ArrayList<String> bankIDlist = new ArrayList<>();
            ArrayList<String> accountIDList = new ArrayList<>();
            ArrayList<String> customerList = new ArrayList<>();
            ArrayList<String> existingAccount = new ArrayList<>();
            while (queryOutput1.next()) {
                System.out.println("BBBB" + queryOutput1.getString("bankID"));

                bankIDlist.add(queryOutput1.getString("bankID") );
                //checkList.add(queryOutput2.getString("accountID"));

            }


            while (queryOutput2.next()) {
                accountIDList.add(queryOutput2.getString("accountID"));

            }



            int n = 0;
            while (queryOutput3.next()) {
                customerList.add(queryOutput3.getString("perID"));
            }

            while (queryOutput4.next()) {
                existingAccount.add(queryOutput4.getString("bankID") +","+accountIDList.get(n));
                n++;
            }
            ArrayList<String> typeList = new ArrayList<>();
            typeList.add("checking");
            typeList.add("savings");
            typeList.add("market");

            accountType.getItems().addAll(typeList);
            accessibleAccounts.getItems().addAll(existingAccount);
            customer.getItems().addAll(customerList);
            bank.getItems().addAll(bankIDlist);
            //AccountID.getItems().addAll(accountIDList);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
