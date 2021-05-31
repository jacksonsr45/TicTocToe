package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

import java.util.Random;

public abstract class Computer {
    private int line, column;
    private Random numberRandom = new Random();
    private int selected;
    private boolean valid = false;

    public abstract void move(Table table, int checker, int player);

    public void checkMovementByComputerWin(Table table, int checker, int player) {
        while (!this.isValid()) {
            if (this.checkMovedDiagonalOne(table,checker,player)) break;
            else if (this.checkMovedDiagonalTwo(table,checker,player)) break;
            else if (this.checkMovedLines(table,checker,player)) break;
            else if (this.checkMovedColumns(table,checker,player)) break;
            else break;
        }
    }

    public void checkMovementByPlayer(Table table, int checker, int player) {
        while (!this.isValid()) {
            if (this.checkMovedDiagonalOne(table,checker,player)) break;
            else if (this.checkMovedDiagonalTwo(table,checker,player)) break;
            else if (this.checkMovedLines(table,checker,player)) break;
            else if (this.checkMovedColumns(table,checker,player)) break;
            else if (this.movedRandom(table, player)) break;
        }
    }

    public boolean checkMovedDiagonalOne(Table table, int value, int player) {
        for (int i = 0; i < 3; i++) {
            if (table.getField()[i][i] == 0) {
                this.setLine(i);
                this.setColumn(i);
                if( (table.getField()[0][0] + table.getField()[1][1]
                        + table.getField()[2][2]) == value) {
                    if (this.updatedMove(table, player)) return true;
                }
            }
        }
        return false;
    }

    public boolean checkMovedDiagonalTwo(Table table, int value, int player) {
        for (int i = 2; i >= 0; i--) {
            if (table.getField()[0][2] == 0) {
                this.setLine(0);
                this.setColumn(2);
            }
            else if (table.getField()[1][1] == 0) {
                this.setLine(1);
                this.setColumn(1);
            }
            else if (table.getField()[2][0] == 0) {
                this.setLine(2);
                this.setColumn(0);
            }
            if( (table.getField()[0][2] + table.getField()[1][1]
                    + table.getField()[2][0]) == value) {
                if (this.updatedMove(table, player)) return true;
            }
        }
        return false;
    }

    public boolean checkMovedLines(Table table, int value, int player) {
        for(int line=0 ; line<3 ; line++){
            for (int column=0 ; column<3; column++) {
                if (table.getField()[line][column] == 0) {
                    this.setLine(line);
                    this.setColumn(column);
                }
            }
            if( (table.getField()[line][0] + table.getField()[line][1]
                    + table.getField()[line][2]) == value) {
                if (this.updatedMove(table, player)) return true;
            }
        }
        return false;
    }

    public boolean checkMovedColumns(Table table, int value, int player) {
        for(int column=0 ; column<3 ; column++){
            for (int line=0 ; line<3; line++) {
                if (table.getField()[line][column] == 0) {
                    this.setLine(line);
                    this.setColumn(column);
                }
            }
            if( (table.getField()[0][column] + table.getField()[1][column]
                    + table.getField()[2][column]) == value) {
                if (this.updatedMove(table, player)) return true;
            }
        }
        return false;
    }

    public boolean movedRandom(Table table, int player) {
        this.setLine(numberRandom.nextInt(3));
        this.setColumn(numberRandom.nextInt(3));
        if (this.updatedMove(table, player)) return true;
        return false;
    }

    private boolean updatedMove(Table table, int player) {
        if (table.isValid(this.getLine(), this.getColumn())) {
            this.setValid(true);
            this.setSelected(this.getLine(), this.getColumn());
            table.setField(this.getLine(), this.getColumn(), player);
            return true;
        }
        return false;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int line, int column) {
        String value = String.valueOf(line)+String.valueOf(column);
        switch (value) {
            case "01": this.selected = 2; break;
            case "02": this.selected = 3; break;
            case "10": this.selected = 4; break;
            case "11": this.selected = 5; break;
            case "12": this.selected = 6; break;
            case "20": this.selected = 7; break;
            case "21": this.selected = 8; break;
            case "22": this.selected = 9; break;
            default: this.selected = 1; break;
        }
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
