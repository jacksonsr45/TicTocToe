package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

public class Movements {
    private Player player;
    private Computer computer;
    private Table table;
    private int id;
    private String matchId;
    private int line;
    private int column;
    private int value;

    public Movements(int id, String matchId, Table table, int level, int checker) {
        this.table = table;
        this.setId(id);
        this.setMatchId(matchId);
        switch (level) {
            case 1: this.computer = new ComputerB(); break;
            case 2: this.computer = new ComputerC(); break;
            default: this.computer = new ComputerA(); break;
        }
        this.computer.move(table, checker, -1);
        this.setLine(this.computer.getLine());
        this.setColumn(this.computer.getColumn());
        this.setValue(-1);
    }

    public Movements(int id, String matchId,Table table, int line, int column, int value) {
        this.table = table;
        this.player = new Player();
        this.player.move(table, line, column, value);
        this.setId(id);
        this.setMatchId(matchId);
        this.setColumn(this.player.getColumn());
        this.setLine(this.player.getLine());
        this.setValue(value);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
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
