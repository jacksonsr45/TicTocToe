package com.jacksonsr45.tictoctoe.domain.entity;

import com.jacksonsr45.tictoctoe.domain.request.TicTocToeRequest;

public class ComputerEntity {
    private int level;
    private int line, column;
    private int selected;

    public ComputerEntity(TicTocToeRequest request) {
        this.setLine(request.getComputer().getLine());
        this.setColumn(request.getComputer().getColumn());
        this.setSelected(request.getComputer().getSelected());
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
