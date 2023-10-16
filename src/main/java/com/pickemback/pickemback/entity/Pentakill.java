package com.pickemback.pickemback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pentakill {
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

    public Pentakill() {
    }

    public Pentakill(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    public Long getId() {
        return id;
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

}
