package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jacksonsr45.tictoctoe.domain.entity.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerManagerInterface;
import com.jacksonsr45.tictoctoe.domain.response.PlayerManagerResponse;
import com.jacksonsr45.tictoctoe.infrastructure.factory.DBFactory;

import java.util.ArrayList;

public class PlayerManagerRepository implements PlayerManagerInterface {
    private SQLiteDatabase connection;

    public PlayerManagerRepository(Context context) {
        DBFactory dbFactory = new DBFactory(context);
        this.connection = dbFactory.getConnection();
    }

    @Override
    public PlayerManagerResponse addPlayer(PlayerEntity player) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", player.getId());
        contentValues.put("name", player.getName());
        this.connection.insertOrThrow("player", null, contentValues);
        return new PlayerManagerResponse(player);
    }

    @Override
    public PlayerManagerResponse updatedPlayer(PlayerEntity player) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", player.getId());
        contentValues.put("name", player.getName());
        String[] parameter = new String[1];
        parameter[0] = player.getId();
        this.connection.update("player", contentValues, "id = ?", parameter);
        return new PlayerManagerResponse(player);
    }

    @Override
    public PlayerManagerResponse deletePlayer(String id) {
        PlayerManagerResponse player = this.showPlayer(id);
        String[] parameter = new String[1];
        parameter[0] = id;
        this.connection.delete("player", "id = ?", parameter);
        return player;
    }

    @Override
    public ArrayList<PlayerManagerResponse> listPlayers() {
        ArrayList<PlayerManagerResponse> players = new ArrayList<PlayerManagerResponse>();
        if (players == null) return null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM player");
        Cursor result = this.connection.rawQuery(query.toString(), null);
        if (result.getCount() > 0) {
            result.moveToFirst();
            do {
                players.add(new PlayerManagerResponse(result));
            }while (result.moveToNext());
        }
        return players;
    }

    @Override
    public PlayerManagerResponse showPlayer(String id) {
        Cursor result = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM player WHERE id = ?");
        String[] parameter = new String[1];
        parameter[0] = id;
        result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0) return new PlayerManagerResponse(result);
        return null;
    }
}
