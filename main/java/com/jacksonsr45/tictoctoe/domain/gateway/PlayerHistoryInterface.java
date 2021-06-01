package com.jacksonsr45.tictoctoe.domain.gateway;

import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;

import java.util.ArrayList;

public interface PlayerHistoryInterface {
    public PlayerHistoryResponse createPlayerHistory(PlayerHistoryEntity playerHistory);

    public PlayerHistoryResponse updatePlayerHistory(PlayerHistoryEntity playerHistory);

    public PlayerHistoryResponse showPlayerHistory(String id);

    public ArrayList<PlayerHistoryResponse> listPlayerHistories();
}
