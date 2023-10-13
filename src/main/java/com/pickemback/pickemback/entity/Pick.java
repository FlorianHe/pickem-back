package com.pickemback.pickemback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "champion_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Champion champion;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Player player;

    public Pick() {
    }
    
    public Pick(Champion champion, Player player) {
        this.champion = champion;
        this.player = player;
    }

    public Long getId() {
        return id;
    }
    
    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
