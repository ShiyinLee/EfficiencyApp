package org.example.efficiencyapp;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class budgettrackerController {
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField amountField;
    @FXML
    private TableView<Expense> expenseTable;
    @FXML
    private TableColumn<Expense, String> descriptionColumn;
    @FXML
    private TableColumn<Expense, Double> amountColumn;
    @FXML
    private Label totalExpenseLabel;

    private final ObservableList<Expense> expenses = FXCollections.observableArrayList();

    private double totalExpense = 0.0;

    @FXML
    public void initialize(){
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        expenseTable.setItems(expenses);

        updateTotalExpense();
    }

    @FXML
    private void handleAddExpense(){
        String description = descriptionField.getText();
        String amountText = amountField.getText();

        if(description.isEmpty()||amountText.isEmpty()){
            showAlert("Error", "Both fields are required!", Alert.AlertType.ERROR);
            return;
        }
        try{
            double amount = Double.parseDouble(amountText);

            expenses.add(new Expense(description, amount));
            totalExpense += amount;

            updateTotalExpense();

            descriptionField.clear();
            amountField.clear();
        }catch (NumberFormatException e){
            showAlert("Error", "Amount must be a valid number!", Alert.AlertType.ERROR);
        }
    }

    private void updateTotalExpense(){
        totalExpenseLabel.setText(String.format("Total Expense: $%.2f", totalExpense));
    }

    private void showAlert(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class Expense{
        private final SimpleStringProperty description;
        private final SimpleDoubleProperty amount;

        public Expense(String description, double amount){
            this.description=new SimpleStringProperty(description);
            this.amount = new SimpleDoubleProperty(amount);
        }

        public String getDescription(){
            return description.get();
        }
        public void setDescription(String description){
            this.description.set(description);
        }
        public double getAmount(){
            return amount.get();
        }
        public void setAmount(double amount){
            this.amount.set(amount);
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
