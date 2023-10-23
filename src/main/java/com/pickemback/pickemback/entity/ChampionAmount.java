package com.pickemback.pickemback.entity;

import java.util.List;

public class ChampionAmount {
    private Champion champion;
    private int amount;
    private List<String> roles;
    
    public ChampionAmount() {
    }
    public ChampionAmount(Champion champion, int amount) {
        this.champion = champion;
        this.amount = amount;
    }

    public ChampionAmount(Champion champion, Integer amount, List<String> roles) {
        this.champion = champion;
        this.amount = amount;
        this.roles = roles;
    }

    public Champion getChampion() {
        return champion;
    }
    public void setChampion(Champion champion) {
        this.champion = champion;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
