// ReportPageController.java
package com.example.gg;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.gg.Order;

public class ReportPageController {
    @FXML
    private TextField FNameF;

    @FXML
    public void giveOtchet() {
        String fNameFilter = FNameF.getText();

        try (Connection connection = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM Orders WHERE FName LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, "%" + fNameFilter + "%");

                ResultSet resultSet = preparedStatement.executeQuery();

                // Load OrderDisplay.fxml with the result data
                FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderDisplay.fxml"));
                Parent root = loader.load();
                OrderDisplayController orderDisplayController = loader.getController();
                orderDisplayController.loadDataFromDatabase(resultSet);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Отобразить заказы");
                stage.show();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
