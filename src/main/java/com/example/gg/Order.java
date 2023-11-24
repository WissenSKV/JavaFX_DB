// Order.java
package com.example.gg;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {
    private final StringProperty fName;
    private final StringProperty lName;
    private final StringProperty orderNomer;
    private final StringProperty oplata;

    public Order(String fName, String lName, String orderNomer, String oplata) {
        this.fName = new SimpleStringProperty(fName);
        this.lName = new SimpleStringProperty(lName);
        this.orderNomer = new SimpleStringProperty(orderNomer);
        this.oplata = new SimpleStringProperty(oplata);
    }

    public String getFName() {
        return fName.get();
    }

    public StringProperty fNameProperty() {
        return fName;
    }

    public String getLName() {
        return lName.get();
    }

    public StringProperty lNameProperty() {
        return lName;
    }

    public String getOrderNomer() {
        return orderNomer.get();
    }

    public StringProperty orderNomerProperty() {
        return orderNomer;
    }

    public String getOplata() {
        return oplata.get();
    }

    public StringProperty oplataProperty() {
        return oplata;
    }
}
