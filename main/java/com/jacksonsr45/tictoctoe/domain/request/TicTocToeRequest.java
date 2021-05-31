package com.jacksonsr45.tictoctoe.domain.request;

import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.*;

public class TicTocToeRequest {
    private Table table;
    private Player player;
    private Computer computer;
    private int move, stage, line, column, keyPlayer;

    public TicTocToeRequest(String id, String name, int stage) {
        this.setTable(new Table());
        this.setStage(stage);
        this.setPlayer(new Player(id, name));
        switch (stage) {
            case 1: this.setComputer(new ComputerB()); break;
            case 2: this.setComputer(new ComputerC()); break;
            default: this.setComputer(new ComputerA()); break;
        }
    }

    public TicTocToeRequest(int move, int line, int column, int keyPlayer) {
        this.setMove(move);
        this.setLine(line);
        this.setColumn(column);
        this.setKeyPlayer(keyPlayer);
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getKeyPlayer() {
        return keyPlayer;
    }

    public void setKeyPlayer(int keyPlayer) {
        this.keyPlayer = keyPlayer;
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

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
