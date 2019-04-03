package com.advancedexchange.api.Entities;

import javax.persistence.*;

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String ticker;

    private Long totalSupply;

    public Token() {

    }

    public Token(String ticker, Long totalSupply){
        this.ticker = ticker;
        this.totalSupply = totalSupply;
    }


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Long getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Long totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
