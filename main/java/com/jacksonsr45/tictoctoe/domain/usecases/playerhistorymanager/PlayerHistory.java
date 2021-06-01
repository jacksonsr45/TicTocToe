package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager;

import java.util.UUID;

public class PlayerHistory {
    private String id;
    private String playerId;
    private int total, victories, defeats, ties;

    public PlayerHistory(String playerId) {
        this.setId(UUID.randomUUID().toString());
        this.setPlayerId(playerId);
        this.setTotal(0);
        this.setVictories(0);
        this.setDefeats(0);
        this.setTies(0);
    }

    public PlayerHistory(String id, String playerId, int victories, int defeats, int ties, int total) {
        this.setId(id);
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
