package com.example.gg;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public void showAddOrderPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddOrderPage.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Добавить заказ");
        stage.show();
    }

    @FXML
    public void showReportPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReportPage.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Посмотреть отчет");
        stage.show();
    }
}