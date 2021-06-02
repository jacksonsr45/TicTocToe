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

    public final String TABLE_PLAYER_HISTORY = "player_history";
    public final String TABLE_MATCH = "match";
    public final String TABLE_MOVEMENTS = "movements";

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
        this.connection.insertOrThrow(TABLE_PLAYER_HISTORY, null, contentValues);
        return new PlayerHistoryResponse(playerHistory);
    }

    @Override
    public PlayerHistoryResponse deletePlayerHistory(String playerId) {
        PlayerHistoryResponse response = this.showPlayerHistory(playerId);
        String[] parameter = new String[1];
        parameter[0] = playerId;
        this.connection.delete(TABLE_PLAYER_HISTORY, "player_id = ?", parameter);
        return response;
    }

    @Override
    public PlayerHistoryResponse showPlayerHistory(String playerId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(TABLE_PLAYER_HISTORY);
        query.append(" WHERE player_id = ?");
        String[] parameter = new String[1];
        parameter[0] = playerId;
        Cursor result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0) return new PlayerHistoryResponse(result);
        return null;
    }

    @Override
    public ArrayList<MatchResponse> listMatch(String playerHistoryId) {
        ArrayList<MatchResponse> matches = new ArrayList<MatchResponse>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(TABLE_MATCH);
        query.append(" WHERE player_history_id = ?");
        String[] parameter = new String[1];
        parameter[0] = playerHistoryId;
        Cursor result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0) {
            do {
                matches.add(new MatchResponse(result));
            } while (result.moveToFirst());
        }
        return matches;
    }

    @Override
    public MatchResponse showMatch(String id) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(TABLE_MATCH);
        query.append(" WHERE id = ?");
        String[] parameter = new String[1];
        parameter[0] = id;
        Cursor result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0)  new MatchResponse(result);
        return new MatchResponse();
    }

    @Override
    public ArrayList<MovementsResponse> listMovements(String matchId) {
        ArrayList<MovementsResponse> movements = new ArrayList<MovementsResponse>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(TABLE_MOVEMENTS);
        query.append(" WHERE match_id = ?");
        String[] parameter = new String[1];
        parameter[0] = matchId;
        Cursor result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0) {
            do {
                movements.add(new MovementsResponse(result));
            } while (result.moveToFirst());
        }
        return movements;
    }
}
