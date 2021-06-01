package com.jacksonsr45.tictoctoe.domain.response.playermanager;

import android.database.Cursor;
import com.jacksonsr45.tictoctoe.domain.entity.playermanager.PlayerEntity;

public class PlayerResponse {
    public String id;
    public String name;

    public PlayerResponse(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
        this.name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
    }

    public PlayerResponse(PlayerEntity player) {
        this.id = player.id;
        this.name = player.name;
    }
}
