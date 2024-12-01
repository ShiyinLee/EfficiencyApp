package org.example.efficiencyapp;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class timetrackerController {

    @FXML
    private Label timeLabel;
    @FXML
    private Button startStopButton;
    @FXML
    private Button resetButton;

    private boolean running = false;
    private long startTime;
    private AnimationTimer timer;

    @FXML
    public void initialize(){
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedMillis=(System.currentTimeMillis() - startTime);
                updateLabel(elapsedMillis);
            }
        };
    }

    @FXML
    private void onStartStopClicked(){
        if(running){
            timer.stop();
            startStopButton.setText("Start");
        }else{
            startTime=System.currentTimeMillis();
            timer.start();
            startStopButton.setText("Stop");
        }
        running=!running;
    }

    @FXML
    private void onResetClicked(){
        timer.stop();
        running=false;
        startStopButton.setText("Start");
        updateLabel(0);
    }

    private void updateLabel(long elapsedMillis){
        long hours = elapsedMillis/3600000;
        long minutes = (elapsedMillis % 3600000) / 60000;
        long seconds=(elapsedMillis%60000)/1000;

        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
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
