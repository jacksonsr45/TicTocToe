package com.jacksonsr45.tictoctoe.domain.entity.playermanager;

import android.database.Cursor;
import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;

public class PlayerEntity {
    public String id;
    public String name;

    public PlayerEntity(PlayerRequest request) {
        this.id = request.getId();
        this.name = request.getName();
    }

    public PlayerEntity(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
        this.name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
    }

}
