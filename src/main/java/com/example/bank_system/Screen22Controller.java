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

    public void displayCorporationStats(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen16.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayBankStats(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen15.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayCustomerStats(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen17.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayEmployeeStats(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen18.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void backToAdminMenu(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen20.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
