package com.jacksonsr45.domain.entity;

import com.jacksonsr45.domain.request.PlayerHistoryRequest;
import com.jacksonsr45.domain.usecases.playerhistorymanager.Match;

import java.util.ArrayList;

public class PlayerHistoryEntity {
    private String id;
    private String playerId;
    private ArrayList<MatchEntity> match = new ArrayList<MatchEntity>();
    private int total, victories, defeats, ties;

    public PlayerHistoryEntity(PlayerHistoryRequest request) {
        this.setId(request.getId());
        this.setPlayerId(request.getPlayerId());
        for (Match newMatch : request.getMatch()) {
            this.match.add(new MatchEntity(newMatch));
        }
        this.setTotal(request.getTotal());
        this.setVictories(request.getVictories());
        this.setDefeats(request.getDefeats());
        this.setTies(request.getTies());
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

    public ArrayList<MatchEntity> getMatch() {
        return match;
    }
}
