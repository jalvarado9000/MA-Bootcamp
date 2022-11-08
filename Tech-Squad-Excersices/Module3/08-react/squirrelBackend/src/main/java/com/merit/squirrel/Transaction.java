package com.merit.squirrel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "transactions")
public class Transaction {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String date;
    private String object;
    private Double amount;

    public Transaction() {}
    public Transaction(String date, String object, Double amount) {
        this.date = date;
        this.object = object;
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
