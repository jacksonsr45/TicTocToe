package com.jacksonsr45.domain.usecases.playerhistorymanager;

public class Movements {
    private int id;
    private int line;
    private int column;
    private int value;

    public Movements(int id, int line, int column, int value) {
        this.setId(id);
        this.setLine(line);
        this.setColumn(column);
        this.setValue(value);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
