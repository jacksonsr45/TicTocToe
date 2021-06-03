package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.TicTocToeInterface;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;
import com.jacksonsr45.tictoctoe.infrastructure.factory.DBFactory;

public class TicTocToeRepository implements TicTocToeInterface {
    private SQLiteDatabase connection;
    private final String TABLE_MATCH = "match";

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
    public MovementsResponse computerMove(MovementEntity entity) {
        return null;
    }

    @Override
    public MovementsResponse playerMove(MovementEntity entity) {
        return null;
    }

    @Override
    public PlayerHistoryResponse setPlayerHistory(PlayerHistoryEntity entity) {
        return null;
    }
}
