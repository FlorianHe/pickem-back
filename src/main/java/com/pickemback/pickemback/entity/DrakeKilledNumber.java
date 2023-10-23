package com.pickemback.pickemback.entity;

public class DrakeKilledNumber {
    private Drake drake;
    private Integer amount;

    public DrakeKilledNumber() {
    }
    public DrakeKilledNumber(Drake drake, Integer amount) {
        this.drake = drake;
        this.amount = amount;
    }

    public Drake getDrake() {
        return drake;
    }
    public void setDrake(Drake drake) {
        this.drake = drake;
    }

    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
