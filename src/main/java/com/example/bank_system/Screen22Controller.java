package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen22Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void displayAccountStats(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen14.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayCorporationStats(ActionEvent actionEvent) {
    }

    public void displayBankStats(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen15.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayCustomerStats(ActionEvent actionEvent) {
    }

    public void displayEmployeeStats(ActionEvent actionEvent) {
    }
}
