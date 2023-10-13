package com.pickemback.pickemback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Drake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Integer killed;

    public Drake() {
    }

    public Drake(String type, Integer killed) {
        this.type = type;
        this.killed = killed;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getKilled() {
        return killed;
    }

    public void setKilled(Integer killed) {
        this.killed = killed;
    }

}
