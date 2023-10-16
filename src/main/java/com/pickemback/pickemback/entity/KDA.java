package com.pickemback.pickemback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class KDA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Game game;

    private Integer kills;

    private Integer death;

    private Integer assist;

    private double kda;

    public KDA() {
    }
    
    public KDA(Player player, Game game, Integer kills, Integer death, Integer assist, double kda) {
        this.player = player;
        this.game = game;
        this.kills = kills;
        this.death = death;
        this.assist = assist;
        this.kda = kda;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeath() {
        return death;
    }

    public void setDeath(Integer death) {
        this.death = death;
    }

    public Integer getAssist() {
        return assist;
    }

    public void setAssist(Integer assist) {
        this.assist = assist;
    }

    public double getKda() {
        return kda;
    }

    public void setKda(double kda) {
        this.kda = kda;
    }

}
