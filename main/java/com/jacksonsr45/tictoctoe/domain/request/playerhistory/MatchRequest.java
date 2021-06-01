package com.jacksonsr45.tictoctoe.domain.request.playerhistory;

import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.Match;


public class MatchRequest {
    private Match match;
    private String id;
    private String playersHistoryId;
    private int level;
    private int result;
    private String createdAt;

    public MatchRequest(String playersHistoryId, int level) {
        this.match = new Match(playersHistoryId, level);
        this.setId(this.match.getId());
        this.setPlayersHistoryId(this.match.getPlayersHistoryId());
        this.setLevel(this.match.getLevel());
        this.setResult(this.match.getResult());
        this.setCreatedAt(this.match.getCreatedAt());
    }

    public MatchRequest(String id, String playersHistoryId, int level, int result, String createdAt) {
        this.match = new Match(id, playersHistoryId, level, result, createdAt);
        this.setId(this.match.getId());
        this.setPlayersHistoryId(this.match.getPlayersHistoryId());
        this.setLevel(this.match.getLevel());
        this.setResult(this.match.getResult());
        this.setCreatedAt(this.match.getCreatedAt());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayersHistoryId() {
        return playersHistoryId;
    }

    public void setPlayersHistoryId(String playersHistoryId) {
        this.playersHistoryId = playersHistoryId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
