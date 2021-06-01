package com.jacksonsr45.tictoctoe.domain.response.playerhistory;

import android.database.Cursor;
import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;

public class PlayerHistoryResponse {
    public String id;
    public String playerId;
    public int total, victories, defeats, ties;

    public PlayerHistoryResponse(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
        this.playerId = cursor.getString(cursor.getColumnIndexOrThrow("player_id"));
        this.total = cursor.getInt(cursor.getColumnIndexOrThrow("total"));
        this.victories = cursor.getInt(cursor.getColumnIndexOrThrow("victories"));
        this.defeats = cursor.getInt(cursor.getColumnIndexOrThrow("defeats"));
        this.ties = cursor.getInt(cursor.getColumnIndexOrThrow("ties"));
    }

    public PlayerHistoryResponse(PlayerHistoryEntity entity) {
        this.id = entity.id;
        this.playerId = entity.playerId;
        this.total = entity.total;
        this.victories = entity.victories;
        this.defeats = entity.defeats;
        this.ties = entity.ties;
    }
}
