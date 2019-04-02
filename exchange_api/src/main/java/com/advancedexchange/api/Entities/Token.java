package com.advancedexchange.api.Entities;

import javax.persistence.*;

@Entity
public class Token {

    @Id
    private Integer id;

    private String ticker;
    private double price;
    private double priceChange;

    public Token() {

    }

    public Token(Integer id, String ticker, double priceChange, double price){
        this.id = id;
        this.ticker = ticker;
        this.price = price;
        this.priceChange = priceChange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

}
