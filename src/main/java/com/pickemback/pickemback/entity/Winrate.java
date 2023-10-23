package com.pickemback.pickemback.entity;

public class Winrate {
    private Champion champion;
    private int totalGame;
    private int victory;
    private int defeat;
    private float winrate;

    public Winrate() {
    }

    public Winrate(Champion champion, int totalGame, int victory, int defeat, float winrate) {
        this.champion = champion;
        this.totalGame = totalGame;
        this.victory = victory;
        this.defeat = defeat;
        this.winrate = winrate;
    }

    public Champion getChampion() {
        return champion;
    }
    public void setChampion(Champion champion) {
        this.champion = champion;
    }
    public int getTotalGame() {
        return totalGame;
    }
    public void setTotalGame(int totalGame) {
        this.totalGame = totalGame;
    }
    public int getWin() {
        return victory;
    }
    public void setWin(int victory) {
        this.victory = victory;
    }
    public int getDefeat() {
        return defeat;
    }
    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }
    public float getWinrate() {
        return winrate;
    }
    public void setWinrate(float winrate) {
        this.winrate = winrate;
    }
}
