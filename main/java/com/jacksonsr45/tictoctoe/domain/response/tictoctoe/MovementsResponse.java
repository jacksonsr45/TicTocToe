package com.jacksonsr45.tictoctoe.domain.response.tictoctoe;

import android.database.Cursor;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.Table;

public class MovementsResponse {
    public Table table;
    public int id;
    public String matchId;
    public int line;
    public int column;
    public int value;

    public MovementsResponse(Cursor cursor, Table table) {
        this.table = table;
        this.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.matchId = cursor.getString(cursor.getColumnIndexOrThrow("match_id"));
        this.line = cursor.getInt(cursor.getColumnIndexOrThrow("table_line"));
        this.column = cursor.getInt(cursor.getColumnIndexOrThrow("table_column"));
        this.value = cursor.getInt(cursor.getColumnIndexOrThrow("value"));
    }

    public MovementsResponse(MovementEntity entity) {
        this.table = entity.table;
        this.id = entity.id;
        this.matchId = entity.matchId;
        this.line = entity.line;
        this.column = entity.column;
        this.value = entity.value;
    }
}
