package com.jacksonsr45.tictoctoe.domain.request.tictoctoe;

import androidx.annotation.Nullable;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.Movements;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.Table;

public class MovementRequest {
    private Movements movements;
    private Table table;
    private int id;
    private String matchId;
    private int line;
    private int column;
    private int value;

    public MovementRequest(int id, String matchId,Table table, int level, int checker) {
        if (table == null) this.setTable(new Table());
        else this.setTable(table);
        this.movements = new Movements(id, matchId, this.table, level, checker);
        this.setId(this.movements.getId());
        this.setMatchId(this.movements.getMatchId());
        this.setLine(this.movements.getLine());
        this.setColumn(this.movements.getColumn());
        this.setValue(this.movements.getValue());
    }

    public MovementRequest(int id, String matchId,@Nullable Table table, int line, int column, int value) {
        if (table == null) this.setTable(new Table());
        else this.setTable(table);
        this.movements = new Movements(id, matchId, this.table, line, column, value);
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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
