package com.example.bank_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen24Controller extends Screen19Login{
    @FXML
    private Button toManageAccountBtn;
    @FXML
    private Button toDepositBtn;
    @FXML
    private Button toTransferBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void goToTransfer(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen12.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToDepositWithdrawal(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("screen11.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MangeAccount(ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(getClass().getResource("screen8.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previous = 24;
        System.out.println("after:" +previous);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MangeOverDraft(ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(getClass().getResource("screen10.fxml"));
        previous = 24;
        System.out.println("after:" +previous);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logOut(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("screen19.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
