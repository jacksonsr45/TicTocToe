package com.jacksonsr45.tictoctoe.domain.response;

import android.database.Cursor;
import com.jacksonsr45.tictoctoe.domain.entity.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.PlayerHistoryEntity;

import java.util.ArrayList;

public class PlayerHistoryResponse {
    private String id;
    private String playerId;
    private ArrayList<MatchEntity> match = new ArrayList<MatchEntity>();
    private int total, victories, defeats, ties;

    public PlayerHistoryResponse(Cursor cursor) {
        this.setId(cursor.getString(cursor.getColumnIndexOrThrow("id")));
        this.setPlayerId(cursor.getString(cursor.getColumnIndexOrThrow("player_id")));
        this.setTotal(cursor.getInt(cursor.getColumnIndexOrThrow("total")));
        this.setVictories(cursor.getInt(cursor.getColumnIndexOrThrow("victories")));
        this.setDefeats(cursor.getInt(cursor.getColumnIndexOrThrow("defeats")));
        this.setTies(cursor.getInt(cursor.getColumnIndexOrThrow("ties")));
    }

    public PlayerHistoryResponse(PlayerHistoryEntity entity) {
        this.setId(entity.getId());
        this.setPlayerId(entity.getPlayerId());
        this.setMatch(entity.getMatch());
        this.setTotal(entity.getTotal());
        this.setVictories(entity.getVictories());
        this.setDefeats(entity.getDefeats());
        this.setTies(entity.getTies());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public ArrayList<MatchEntity> getMatch() {
        return match;
    }

    public void setMatch(ArrayList<MatchEntity> match) {
        this.match = match;
    }
}
