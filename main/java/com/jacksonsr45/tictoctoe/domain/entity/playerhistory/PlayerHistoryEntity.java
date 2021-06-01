package com.jacksonsr45.tictoctoe.domain.entity.playerhistory;

import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;

public class PlayerHistoryEntity {
    public String id;
    public String playerId;
    public int total, victories, defeats, ties;

    public PlayerHistoryEntity(PlayerHistoryRequest request) {
        this.id = request.getId();
        this.playerId = request.getPlayerId();
        this.total = request.getTotal();
        this.victories = request.getVictories();
        this.defeats = request.getDefeats();
        this.ties = request.getTies();
    }
}
