package com.jacksonsr45.domain.usecases.tictoctoe;

public class ComputerC extends Computer {
    @Override
    public void move(Table table, int checker, int player) {
        int validWin;
        if (checker == -2) validWin = 2;
        else validWin = -2;
        do {
            this.checkMovementByComputerWin(table, validWin, player);
            if (this.isValid()) break;
            else {
                this.checkMovementByPlayer(table, checker, player);
                break;
            }
        } while (true);

        this.setValid(false);
    }
}
