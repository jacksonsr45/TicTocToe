package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

public class Player {
    private int line, column;

    public void move(Table table, int line, int column, int value) {
        boolean validation = false;
        do {
            if (table.isValid(line, column)) {
                table.setField(line, column, value);
                this.setLine(line);
                this.setColumn(column);
                validation = true;
            }
        } while (!validation);
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
}
