// OrderDisplayController.java
package com.example.gg;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDisplayController {
    @FXML
    private TableView<Order> orderTableView;

    @FXML
    private TableColumn<Order, String> fNameColumn;

    @FXML
    private TableColumn<Order, String> lNameColumn;

    @FXML
    private TableColumn<Order, String> orderNomerColumn;

    @FXML
    private TableColumn<Order, String> oplataColumn;

    @FXML
    private Label totalSumLabel;

    public void initialize() {
        fNameColumn.setCellValueFactory(cellData -> cellData.getValue().fNameProperty());
        lNameColumn.setCellValueFactory(cellData -> cellData.getValue().lNameProperty());
        orderNomerColumn.setCellValueFactory(cellData -> cellData.getValue().orderNomerProperty());
        oplataColumn.setCellValueFactory(cellData -> cellData.getValue().oplataProperty());

        // You don't need to load data here. It will be loaded when giveOtchet is called.
    }

    public void loadDataFromDatabase(ResultSet resultSet) throws SQLException {
        double totalSum = 0;

        while (resultSet.next()) {
            Order order = new Order(
                    resultSet.getString("FName"),
                    resultSet.getString("LName"),
                    resultSet.getString("ONomer"),
                    resultSet.getString("Oplata")
            );
            orderTableView.getItems().add(order);

            // Calculate total sum
            totalSum += Double.parseDouble(order.getOplata());
        }

        // Display total sum
        totalSumLabel.setText("Итоговая сумма: " + totalSum);
    }
}
