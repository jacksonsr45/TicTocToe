package com.jacksonsr45.tictoctoe.domain.response.tictoctoe;

import android.database.Cursor;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;

public class MatchResponse {
    public String id;
    public String playersHistoryId;
    public int level;
    public int result;
    public String createdAt;

    public MatchResponse(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
        this.playersHistoryId = cursor.getString(cursor.getColumnIndexOrThrow("player_history_id"));
        this.level = cursor.getInt(cursor.getColumnIndexOrThrow("level"));
        this.result = cursor.getInt(cursor.getColumnIndexOrThrow("result"));
        this.createdAt = cursor.getString(cursor.getColumnIndexOrThrow("created_at"));;
    }

    public MatchResponse(MatchEntity entity) {
        this.id = entity.id;
        this.playersHistoryId = entity.playersHistoryId;
        this.level = entity.level;
        this.result = entity.result;
        this.createdAt = entity.createdAt;
    }
}
