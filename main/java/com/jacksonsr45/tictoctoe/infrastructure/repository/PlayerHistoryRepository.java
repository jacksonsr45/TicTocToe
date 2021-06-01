package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerHistoryInterface;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MovementsResponse;
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
    public PlayerHistoryResponse showPlayerHistory(String playerId) {
        Cursor result = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM player_history WHERE player_id = ?");
        String[] parameter = new String[1];
        parameter[0] = playerId;
        result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0) return new PlayerHistoryResponse(result);
        return null;
    }

    @Override
    public ArrayList<MatchResponse> listMatch() {
        return null;
    }

    @Override
    public MatchResponse showMatch(String id) {
        return null;
    }

    @Override
    public ArrayList<MovementsResponse> listMovements() {
        return null;
    }
}
