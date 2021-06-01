package com.jacksonsr45.tictoctoe.domain.entity.tictoctoe;

import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MatchRequest;

public class MatchEntity {
    public String id;
    public String playersHistoryId;
    public int level;
    public int result;
    public String createdAt;

    public MatchEntity(MatchRequest request) {
        this.id = request.getId();
        this.playersHistoryId = request.getPlayersHistoryId();
        this.level = request.getLevel();
        this.result = request.getResult();
        this.createdAt = request.getCreatedAt();
    }
}
