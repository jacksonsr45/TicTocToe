package com.jacksonsr45.tictoctoe.domain.entity;

import com.jacksonsr45.tictoctoe.domain.request.TicTocToeRequest;

public class TicTocToeEntity {
    private TableEntity table;
    private PlayerEntity player;
    private ComputerEntity computer;
    private int move, stage, line, column, keyPlayer;

    public TicTocToeEntity(TicTocToeRequest request) {
        this.table = new TableEntity(request);
        this.player = new PlayerEntity(request);
        this.computer = new ComputerEntity(request);
        this.setMove(request.getMove());
        this.setStage(request.getStage());
        this.setLine(request.getLine());
        this.setColumn(request.getColumn());
        this.setKeyPlayer(request.getKeyPlayer());
    }

    public TableEntity getTable() {
        return table;
    }

    public void setTable(TableEntity table) {
        this.table = table;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public ComputerEntity getComputer() {
        return computer;
    }

    public void setComputer(ComputerEntity computer) {
        this.computer = computer;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
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

    public int getKeyPlayer() {
        return keyPlayer;
    }

    public void setKeyPlayer(int keyPlayer) {
        this.keyPlayer = keyPlayer;
    }
}
