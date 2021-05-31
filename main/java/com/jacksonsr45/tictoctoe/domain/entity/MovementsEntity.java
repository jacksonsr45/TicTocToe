package com.jacksonsr45.tictoctoe.domain.entity;

import com.jacksonsr45.tictoctoe.domain.request.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.Match;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.Movements;

public class MovementsEntity {
    private int id;
    private int line;
    private int column;
    private int value;

    public MovementsEntity(PlayerHistoryRequest request) {
        for (Match match : request.getMatch()) {
            for (Movements movements : match.getMovements()) {
                this.setId(movements.getId());
                this.setLine(movements.getLine());
                this.setColumn(movements.getColumn());
                this.setValue(movements.getValue());
            }
        }
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
