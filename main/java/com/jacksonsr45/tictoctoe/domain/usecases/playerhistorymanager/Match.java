package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Match {
    private String id;
    private String playersHistoryId;
    private int level;
    private int result;
    private String createdAt;

    public Match(String playersHistoryId, int level) {
        this.setId(UUID.randomUUID().toString());
        this.setPlayersHistoryId(playersHistoryId);
        this.setLevel(level);
        this.setResult(0);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        this.createdAt = formatter.format(new Date());
    }

    public Match(String id, String playersHistoryId, int level, int result, String createdAt) {
        this.setId(id);
        this.setPlayersHistoryId(playersHistoryId);
        this.setLevel(level);
        this.setResult(result);
        this.setCreatedAt(createdAt);
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
