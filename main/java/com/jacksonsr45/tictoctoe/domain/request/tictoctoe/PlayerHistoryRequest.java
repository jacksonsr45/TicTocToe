package com.jacksonsr45.tictoctoe.domain.request.tictoctoe;

import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.PlayerHistory;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.Table;

public class PlayerHistoryRequest {
    private PlayerHistory playerHistory;
    private String id;
    private String playerId;
    private int total, victories, defeats, ties;

    public PlayerHistoryRequest(int result, String id, String playerId, int total, int victories, int defeats, int ties) {
        this.playerHistory = new PlayerHistory(result, id, playerId, total, victories, defeats, ties);
        this.setId(this.playerHistory.getId());
        this.setPlayerId(this.playerHistory.getPlayerId());
        this.setTotal(this.playerHistory.getTotal());
        this.setVictories(this.playerHistory.getVictories());
        this.setDefeats(this.playerHistory.getDefeats());
        this.setTies(this.playerHistory.getTies());
    }

    public PlayerHistoryRequest(Table table, String id, String playerId, int total, int victories, int defeats, int ties) {
        this.playerHistory = new PlayerHistory(table, id, playerId, total, victories, defeats, ties);
        this.setId(this.playerHistory.getId());
        this.setPlayerId(this.playerHistory.getPlayerId());
        this.setTotal(this.playerHistory.getTotal());
        this.setVictories(this.playerHistory.getVictories());
        this.setDefeats(this.playerHistory.getDefeats());
        this.setTies(this.playerHistory.getTies());
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

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
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
}
