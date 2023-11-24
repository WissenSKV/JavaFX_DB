// AddOrderPageController.java
package com.example.gg;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddOrderPageController {
    @FXML
    private TextField FName;
    @FXML
    private TextField LName;
    @FXML
    private TextField Order_n;
    @FXML
    private TextField Oplata;
    @FXML
    private TextField Date;

    // Your database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Customer";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    @FXML
    public void saveInDB() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "INSERT INTO Orders (FName, LName, ONomer, Oplata, Date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, FName.getText());
            preparedStatement.setString(2, LName.getText());
            preparedStatement.setString(3, Order_n.getText());
            preparedStatement.setString(4, Oplata.getText());
            preparedStatement.setString(5, Date.getText());

            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
