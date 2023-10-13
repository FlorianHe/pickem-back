package com.pickemback.pickemback.entity;

public class PentakillAmount {
    private Player player;
    private Integer amount;

    public PentakillAmount(Player player, Integer amount) {
        this.player = player;
        this.amount = amount;
    }

    public PentakillAmount() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getAmount() {
        return amount;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
