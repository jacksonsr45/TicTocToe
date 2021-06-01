package com.jacksonsr45.tictoctoe.domain.entity.playermanager;

import android.database.Cursor;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.MatchRequest;

public class MatchEntity {
    public String id;
    public String playersHistoryId;
    public int level;
    public int result;
    public String createdAt;

    public MatchEntity(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
        this.playersHistoryId = cursor.getString(cursor.getColumnIndexOrThrow("player_id"));
        this.level = cursor.getInt(cursor.getColumnIndexOrThrow("level"));
        this.result = cursor.getInt(cursor.getColumnIndexOrThrow("result"));
        this.createdAt = cursor.getString(cursor.getColumnIndexOrThrow("created_at"));
    }

    public MatchEntity(MatchRequest request) {
        this.id = request.getId();
        this.playersHistoryId = request.getPlayersHistoryId();
        this.level = request.getLevel();
        this.result = request.getResult();
        this.createdAt = request.getCreatedAt();
    }
}
