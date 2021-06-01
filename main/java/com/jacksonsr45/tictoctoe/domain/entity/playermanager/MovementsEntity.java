package com.jacksonsr45.tictoctoe.domain.entity.playermanager;

import android.database.Cursor;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.MovementRequest;

public class MovementsEntity {
    public int id;
    public String matchId;
    public int line;
    public int column;
    public int value;

    public MovementsEntity(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.matchId = cursor.getString(cursor.getColumnIndexOrThrow("match_id"));
        this.line = cursor.getInt(cursor.getColumnIndexOrThrow("table_line"));
        this.column = cursor.getInt(cursor.getColumnIndexOrThrow("table_column"));
        this.value = cursor.getInt(cursor.getColumnIndexOrThrow("value"));
    }

    public MovementsEntity(MovementRequest request) {
        this.id = request.getId();
        this.matchId = request.getMatchId();
        this.line = request.getLine();
        this.column = request.getColumn();
        this.value = request.getValue();
    }
}
