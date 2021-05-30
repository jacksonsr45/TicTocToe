package com.jacksonsr45.domain.usecases.tictoctoe;

public class ComputerB extends Computer {
    @Override
    public void move(Table table, int checker, int player) {
        this.checkMovementByPlayer(table, checker, player);
        this.setValid(false);
    }
}
