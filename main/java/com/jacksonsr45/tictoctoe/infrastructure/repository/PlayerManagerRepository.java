package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jacksonsr45.tictoctoe.domain.entity.playermanager.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerManagerInterface;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;
import com.jacksonsr45.tictoctoe.infrastructure.factory.DBFactory;

import java.util.ArrayList;

public class PlayerManagerRepository implements PlayerManagerInterface {
    private SQLiteDatabase connection;

    public PlayerManagerRepository(Context context) {
        DBFactory dbFactory = new DBFactory(context);
        this.connection = dbFactory.getConnection();
    }

    @Override
    public PlayerResponse addPlayer(PlayerEntity player) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", player.id);
        contentValues.put("name", player.name);
        this.connection.insertOrThrow("player", null, contentValues);
        return new PlayerResponse(player);
    }

    @Override
    public PlayerResponse updatedPlayer(PlayerEntity player) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", player.name);
        String[] parameter = new String[1];
        parameter[0] = player.id;
        this.connection.update("player", contentValues, "id = ?", parameter);
        return new PlayerResponse(player);
    }

    @Override
    public PlayerResponse deletePlayer(String id) {
        PlayerResponse player = this.showPlayer(id);
        String[] parameter = new String[1];
        parameter[0] = id;
        this.connection.delete("player", "id = ?", parameter);
        return player;
    }

    @Override
    public ArrayList<PlayerResponse> listPlayers() {
        ArrayList<PlayerResponse> players = new ArrayList<PlayerResponse>();
        if (players == null) return null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM player");
        Cursor result = this.connection.rawQuery(query.toString(), null);
        if (result.getCount() > 0) {
            result.moveToFirst();
            do {
                players.add(new PlayerResponse(result));
            }while (result.moveToNext());
        }
        return players;
    }

    @Override
    public PlayerResponse showPlayer(String id) {
        Cursor result = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM player WHERE id = ?");
        String[] parameter = new String[1];
        parameter[0] = id;
        result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0) return new PlayerResponse(result);
        return null;
    }
}
