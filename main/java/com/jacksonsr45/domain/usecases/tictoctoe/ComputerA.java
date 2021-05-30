package com.jacksonsr45.domain.usecases.tictoctoe;

public class ComputerA extends Computer {
    @Override
    public void move(Table table, int checker, int player) {
        do {
            this.movedRandom(table, player);
        } while (!this.isValid());
    }
}
