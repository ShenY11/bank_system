package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class Screen21Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void createEmployee(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen3.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen4.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopEmployee(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen5a.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopCustomer(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen5b.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToAdminMenu(ActionEvent actionEvent) {
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
}
