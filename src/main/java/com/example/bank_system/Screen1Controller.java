package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Screen1Controller extends Screen19Login{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button cancelButton;
    public Button getCancelButton() {
        return cancelButton;
    }

    @FXML
    private Button createButton;
    public Button getCreateButton() {
        return createButton;
    }

    @FXML
    private TextField corpIDTextfield;
    public TextField getCorpIDTextfield() {
        return corpIDTextfield;
    }

    @FXML
    private TextField longNameTextfield;
    public TextField getLongNameTextfield() {
        return longNameTextfield;
    }

    @FXML
    private TextField shortNameTextfield;
    public TextField getShortNameTextfield() {
        return shortNameTextfield;
    }

    @FXML
    private TextField resAssetsTextfield;
    public TextField getResAssetsTextfield() {
        return resAssetsTextfield;
    }

    public void goToAdminMenu_cancel(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen20.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void goToAdminMenu_create(ActionEvent actionEvent) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String createCorporation = "call create_corporation('%s', '%s', '%s', %d);";
        try {
            corpID = corpIDTextfield.getText();
            longName = longNameTextfield.getText();
            shortName = shortNameTextfield.getText();
            boolean resProblem = false;
            for (char i : resAssetsTextfield.getText().toCharArray()) {
                if ((int)i > 57 || (int) i < 48) {
                    resProblem = true;
                    break;
                }
            }
            if (corpID == "" || longName == "" || shortName == "" || resProblem) {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Please enter valid inputs");
                alert.show();
            }
            resAssets = Integer.valueOf(resAssetsTextfield.getText());
            Statement statement1 = connectionDB.createStatement();
            ResultSet queryOutput = statement1.executeQuery(String.format(createCorporation, corpID, shortName, longName, resAssets));
            //TODO: input examination? alert?
            //if invalid input, page will not return to admin menu.
            root = FXMLLoader.load(getClass().getResource("screen20.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
