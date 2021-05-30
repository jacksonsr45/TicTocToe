package com.jacksonsr45.domain.response;

import com.jacksonsr45.domain.entity.ComputerEntity;
import com.jacksonsr45.domain.entity.PlayerEntity;
import com.jacksonsr45.domain.entity.TableEntity;
import com.jacksonsr45.domain.entity.TicTocToeEntity;

public class TicTocToeResponse {
    private TableEntity table;
    private PlayerEntity player;
    private ComputerEntity computer;
    private int move, stage, line, column, keyPlayer;

    public TicTocToeResponse(TicTocToeEntity entity) {
        this.setTable(entity.getTable());
        this.setKeyPlayer(entity.getKeyPlayer());
        this.setLine(entity.getLine());
        this.setColumn(entity.getColumn());
        this.setStage(entity.getStage());
        this.setPlayer(entity.getPlayer());
        this.setComputer(entity.getComputer());
        this.setMove(entity.getMove());
    }

    public TableEntity getTable() { return table; }

    public void setTable(TableEntity table) { this.table = table; }

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
}
