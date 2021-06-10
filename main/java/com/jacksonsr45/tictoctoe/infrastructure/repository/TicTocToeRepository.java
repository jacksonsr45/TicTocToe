package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.TicTocToeInterface;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;
import com.jacksonsr45.tictoctoe.infrastructure.factory.DBFactory;

public class TicTocToeRepository implements TicTocToeInterface {
    private SQLiteDatabase connection;
    private final String TABLE_MATCH = "match";
    private final String TABLE_MOVEMENTS = "movements";
    private final String TABLE_PLAYER_HISTORY = "player_history";

    public TicTocToeRepository(Context context) {
        DBFactory dbFactory = new DBFactory(context);
        this.connection = dbFactory.getConnection();
    }

    @Override
    public MatchResponse startMatch(MatchEntity entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", entity.id);
        contentValues.put("player_history_id", entity.playersHistoryId);
        contentValues.put("level", entity.level);
        contentValues.put("result", entity.result);
        contentValues.put("created_at", entity.createdAt);
        this.connection.insertOrThrow(TABLE_MATCH, null, contentValues);
        return new MatchResponse(entity);
    }

    @Override
    public MatchResponse updateMatch(String matchID, int result) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("result", result);
        String[] parameter = new String[1];
        parameter[0] = matchID;
        this.connection.update(TABLE_MATCH, contentValues, "id = ?", parameter);
        return null;
    }

    @Override
    public MatchResponse deleteMatch(String matchID) {
        String[] parameter = new String[1];
        parameter[0] = matchID;
        this.connection.delete(TABLE_MATCH, "id = ?", parameter);
        return null;
    }

    @Override
    public MovementsResponse computerMove(MovementEntity entity) {
        this.setMovements(entity);
        return new MovementsResponse(entity);
    }

    @Override
    public MovementsResponse playerMove(MovementEntity entity) {
        this.setMovements(entity);
        return new MovementsResponse(entity);
    }

    private void setMovements(MovementEntity entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", entity.id);
        contentValues.put("match_id", entity.matchId);
        contentValues.put("table_line", entity.line);
        contentValues.put("table_column", entity.column);
        contentValues.put("value", entity.value);
        this.connection.insertOrThrow(TABLE_MOVEMENTS, null, contentValues);
    }

    @Override
    public PlayerHistoryResponse setPlayerHistory(PlayerHistoryEntity entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("player_id", entity.playerId);
        contentValues.put("total", entity.total);
        contentValues.put("victories", entity.victories);
        contentValues.put("defeats", entity.defeats);
        contentValues.put("ties", entity.ties);
        String[] parameter = new String[1];
        parameter[0] = entity.id;
        this.connection.update( TABLE_PLAYER_HISTORY, contentValues, "id = ?", parameter);
        return new PlayerHistoryResponse(entity);
    }

    @Override
    public PlayerHistoryResponse getPlayerHistory(String playerHistoryID) {
        Cursor result = null;
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(TABLE_PLAYER_HISTORY);
        query.append(" WHERE id = ?");
        String[] parameter = new String[1];
        parameter[0] = playerHistoryID;
        result = this.connection.rawQuery(query.toString(), parameter);
        result.moveToFirst();
        if (result.getCount() > 0) return new PlayerHistoryResponse(result);
        return null;
    }
}
