package com.jacksonsr45.tictoctoe.domain.gateway;

import com.jacksonsr45.tictoctoe.domain.entity.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.response.PlayerHistoryResponse;

import java.util.ArrayList;

public interface PlayerHistoryInterface {
    public PlayerHistoryResponse createPlayerHistory(PlayerHistoryEntity playerHistory);

    public PlayerHistoryResponse updatePlayerHistory(PlayerHistoryEntity playerHistory);

    public PlayerHistoryResponse showPlayerHistory(String id);

    public ArrayList<PlayerHistoryResponse> listPlayerHistories();
}
