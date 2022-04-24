package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Screen20Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void goToViewStatus(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen22.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToCreateCorporation(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen1.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void goToCreateFee(ActionEvent actionEvent) {
    }


    public void goToManageUsers(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen21.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void goToManageOverdraft(ActionEvent actionEvent) {
    }

    public void goToHireWorker(ActionEvent actionEvent) {
    }


    public void goToPayEmployees(ActionEvent actionEvent) {
    }

    public void goToReplaceManager(ActionEvent actionEvent) {
    }


    public void goToManageAccounts(ActionEvent actionEvent) {
    }


    public void goToCreateBank(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen2.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
