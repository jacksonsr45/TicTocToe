package com.jacksonsr45.tictoctoe.domain.response.playerhistory;

import com.jacksonsr45.tictoctoe.domain.entity.playermanager.MatchEntity;

public class MatchResponse {
    public String id;
    public String playersHistoryId;
    public int level;
    public int result;
    public String createdAt;

    public MatchResponse(MatchEntity entity) {
        this.id = entity.id;
        this.playersHistoryId = entity.playersHistoryId;
        this.level = entity.level;
        this.result = entity.result;
        this.createdAt = entity.createdAt;
    }
}
