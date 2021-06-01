package com.jacksonsr45.tictoctoe.domain.entity.tictoctoe;

import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MovementRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.Table;

public class MovementEntity {
    public Table table;
    public int id;
    public String matchId;
    public int line;
    public int column;
    public int value;

    public MovementEntity(MovementRequest request) {
        this.table = request.getTable();
        this.id = request.getId();
        this.matchId = request.getMatchId();
        this.line = request.getLine();
        this.column = request.getColumn();
        this.value = request.getValue();
    }
}
