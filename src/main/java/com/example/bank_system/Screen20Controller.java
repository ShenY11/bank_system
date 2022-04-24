package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Screen20Controller extends Screen19Login{
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void goToViewStatus(ActionEvent actionEvent) {
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
        try {
            root = FXMLLoader.load(getClass().getResource("screen9.fxml"));
            previous = 20;
            System.out.println("after:" +previous);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            root = FXMLLoader.load(getClass().getResource("screen10.fxml"));
            previous = 20;
            System.out.println("after:" +previous);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToHireWorker(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen6.fxml"));
            previous = 20;
            System.out.println("after:" +previous);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void goToPayEmployees(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen13.fxml"));
            previous = 20;
            System.out.println("after:" +previous);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToReplaceManager(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen7.fxml"));
            previous = 20;
            System.out.println("after:" +previous);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void goToManageAccounts(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen8.fxml"));
            previous = 20;
            System.out.println("after:" +previous);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
