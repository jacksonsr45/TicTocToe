package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Match {
    public String id;
    public String playersHistoryId;
    public int level;
    public int result;
    public String createdAt;

    public Match(String playersHistoryId, int level) {
        this.setId(UUID.randomUUID().toString());
        this.setPlayersHistoryId(playersHistoryId);
        this.setLevel(level);
        this.setResult(0);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.setCreatedAt(formatter.format(new Date()));
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
