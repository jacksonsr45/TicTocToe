package com.jacksonsr45.tictoctoe.domain.response.playerhistory;

import com.jacksonsr45.tictoctoe.domain.entity.playermanager.MovementsEntity;

public class MovementsResponse {
    public int id;
    public String matchId;
    public int line;
    public int column;
    public int value;

    public MovementsResponse(MovementsEntity entity) {
        this.id = entity.id;
        this.matchId = entity.matchId;
        this.line = entity.line;
        this.column = entity.column;
        this.value = entity.value;
    }
}
