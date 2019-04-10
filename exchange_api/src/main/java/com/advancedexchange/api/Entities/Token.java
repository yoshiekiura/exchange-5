package com.advancedexchange.api.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Token implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Integer id;

    private String ticker;

    private Long supply;

    private String createdBy;

    public Token() {

    }

    public Token(String ticker, Long supply, String createdBy){
        this.ticker = ticker;
        this.supply = supply;
        this.createdBy = createdBy;
    }


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Long getSupply() {
        return supply;
    }

    public void setSupply(Long supply) {
        this.supply = supply;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
