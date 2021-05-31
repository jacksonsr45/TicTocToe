package com.jacksonsr45.tictoctoe.domain.request;

import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.Match;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerHistoryRequest {
    private String id;
    private String playerId;
    private ArrayList<Match> match = new ArrayList<Match>();
    private int total, victories, defeats, ties;

    public PlayerHistoryRequest(String playerId) {
        this.setId(UUID.randomUUID().toString());
        this.setPlayerId(playerId);
    }

    public PlayerHistoryRequest(String id, String playerId, int level, int victories, int defeats, int ties, int total) {
        this.setId(id);
        this.match.add(new Match(level));
        this.setPlayerId(playerId);
        this.setTotal(total);
        this.setVictories(victories);
        this.setDefeats(defeats);
        this.setTies(ties);
    }

    public PlayerHistoryRequest(String id, String matchId, String playerId, int victories, int defeats, int ties, int total) {
        this.setId(id);
        this.match.add(new Match(matchId));
        this.setPlayerId(playerId);
        this.setTotal(total);
        this.setVictories(victories);
        this.setDefeats(defeats);
        this.setTies(ties);
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

    public ArrayList<Match> getMatch() {
        return match;
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
