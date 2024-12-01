package org.example.efficiencyapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.Event;


import java.io.IOException;

public class dashboardController {
    @FXML
    public void ShowToDoList(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("todolist.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void ShowBudgetTracker(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("budgettracker.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void ShowTimeTracker(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("timetracker.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}