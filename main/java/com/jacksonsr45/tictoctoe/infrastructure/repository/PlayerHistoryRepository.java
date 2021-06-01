package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerHistoryInterface;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;
import com.jacksonsr45.tictoctoe.infrastructure.factory.DBFactory;

import java.util.ArrayList;

public class PlayerHistoryRepository implements PlayerHistoryInterface {
    private SQLiteDatabase connection;

    public PlayerHistoryRepository(Context context) {
        DBFactory dbFactory = new DBFactory(context);
        this.connection = dbFactory.getConnection();
    }

    @Override
    public PlayerHistoryResponse createPlayerHistory(PlayerHistoryEntity playerHistory) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", playerHistory.id);
        contentValues.put("player_id", playerHistory.playerId);
        contentValues.put("total", playerHistory.total);
        contentValues.put("victories", playerHistory.victories);
        contentValues.put("defeats", playerHistory.defeats);
        contentValues.put("ties", playerHistory.ties);
        this.connection.insertOrThrow("player_history", null, contentValues);
        return new PlayerHistoryResponse(playerHistory);
    }

    @Override
    public PlayerHistoryResponse updatePlayerHistory(PlayerHistoryEntity playerHistory) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("player_id", playerHistory.playerId);
        contentValues.put("total", playerHistory.total);
        contentValues.put("victories", playerHistory.victories);
        contentValues.put("defeats", playerHistory.defeats);
        contentValues.put("ties", playerHistory.ties);
        String[] parameter = new String[1];
        parameter[0] = playerHistory.id;
        this.connection.update("player_history", contentValues, "id = ?", parameter);
        return new PlayerHistoryResponse(playerHistory);
    }

    @Override
    public PlayerHistoryResponse showPlayerHistory(String id) {
        Cursor result = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM player_history WHERE id = ?");
        String[] parameter = new String[1];
        parameter[0] = id;
        result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0) return new PlayerHistoryResponse(result);
        return null;
    }

    @Override
    public ArrayList<PlayerHistoryResponse> listPlayerHistories() {
        ArrayList<PlayerHistoryResponse> players = new ArrayList<PlayerHistoryResponse>();
        if (players == null) return null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM player_history");
        Cursor result = this.connection.rawQuery(query.toString(), null);
        if (result.getCount() > 0) {
            result.moveToFirst();
            do {
                players.add(new PlayerHistoryResponse(result));
            } while (result.moveToNext());
        }
        return players;
    }
}
