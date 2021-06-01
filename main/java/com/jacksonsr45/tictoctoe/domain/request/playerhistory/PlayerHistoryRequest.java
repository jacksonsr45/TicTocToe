package com.jacksonsr45.tictoctoe.domain.request.playerhistory;

import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.Match;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.PlayerHistory;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerHistoryRequest {
    private PlayerHistory playerHistory;
    private String id;
    private String playerId;
    private int total, victories, defeats, ties;

    public PlayerHistoryRequest(String playerId) {
        this.playerHistory = new PlayerHistory(playerId);
        this.setId(this.playerHistory.getId());
        this.setPlayerId(this.playerHistory.getPlayerId());
        this.setTotal(this.playerHistory.getTotal());
        this.setVictories(this.playerHistory.getVictories());
        this.setDefeats(this.playerHistory.getDefeats());
        this.setTies(this.playerHistory.getTies());
    }

    public PlayerHistoryRequest(String id, String playerId, int victories, int defeats, int ties, int total) {
        this.playerHistory = new PlayerHistory(id, playerId, victories, defeats, ties, total);
        this.setId(this.playerHistory.getId());
        this.setPlayerId(this.playerHistory.getPlayerId());
        this.setTotal(this.playerHistory.getTotal());
        this.setVictories(this.playerHistory.getVictories());
        this.setDefeats(this.playerHistory.getDefeats());
        this.setTies(this.playerHistory.getTies());
    }

    public PlayerHistory getPlayerHistory() {
        return playerHistory;
    }

    public void setPlayerHistory(PlayerHistory playerHistory) {
        this.playerHistory = playerHistory;
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
