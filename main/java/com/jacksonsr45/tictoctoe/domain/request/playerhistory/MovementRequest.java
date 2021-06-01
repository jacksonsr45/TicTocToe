package com.jacksonsr45.tictoctoe.domain.request.playerhistory;

import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.Movements;

public class MovementRequest {
    private Movements movements;
    private int id;
    private String matchId;
    private int line;
    private int column;
    private int value;

    public MovementRequest(int id, String matchId, int line, int column, int value) {
        this.movements = new Movements(id, matchId, line, column, value);
        this.setId(this.movements.getId());
        this.setMatchId(this.movements.getMatchId());
        this.setLine(this.movements.getLine());
        this.setColumn(this.movements.getColumn());
        this.setValue(this.movements.getValue());
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
