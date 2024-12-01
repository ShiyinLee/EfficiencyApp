package org.example.efficiencyapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class todolistController {

    @FXML
    private VBox dashboard;

    @FXML
    private VBox taskScreen;

    @FXML
    private TextField titleField;

    @FXML
    private TextField taskField;

    @FXML
    private ListView<CheckBox> taskListView;

    @FXML
    private void handleGoalButtonClick(){
        dashboard.setVisible(false);
        taskScreen.setVisible(true);
    }

    @FXML
    private void handleBackButtonClick(){
        dashboard.setVisible(true);
        taskScreen.setVisible(false);
    }

    @FXML
    private void handleAddTask(){
        String taskText = taskField.getText().trim();
        if(!taskText.isEmpty()){
            CheckBox task = new CheckBox(taskText);
            task.setStyle("-fx-text-fill: red;");
            task.setOnAction(e->toggleTaskCompletion(task));
            taskListView.getItems().add(task);
            taskField.clear();
        }
    }

    @FXML
    private void toggleTaskCompletion(CheckBox task){
        if(task.isSelected()){
            task.setStyle("-fx-text-fill: green; -fx-text-decoration: line-through;");
        }else{
            task.setStyle("-fx-text-fill: red; ");
        }
    }
    @FXML
    public void GoToMenu(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
