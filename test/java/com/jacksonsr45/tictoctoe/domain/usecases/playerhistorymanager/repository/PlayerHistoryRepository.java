package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.repository;

import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerHistoryInterface;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;

import java.util.ArrayList;

public class PlayerHistoryRepository implements PlayerHistoryInterface {
    String playerId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    String playerId2 = "afa36c80-8172-4370-8914-d4a148fa3174";
    String playerId3 = "afa36c80-8172-4370-8914-d4a148fa3182";
    String historyId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    String historyId2 = "afa36c80-8172-4370-8914-d4a148fa3175";
    String historyId3 = "afa36c80-8172-4370-8914-d4a148fa3116";
    @Override
    public PlayerHistoryResponse createPlayerHistory(PlayerHistoryEntity playerHistory) {
        return new PlayerHistoryResponse(playerHistory);
    }

    @Override
    public PlayerHistoryResponse updatePlayerHistory(PlayerHistoryEntity playerHistory) {
        return new PlayerHistoryResponse(playerHistory);
    }

    @Override
    public PlayerHistoryResponse showPlayerHistory(String id) {
        PlayerHistoryRequest request = new PlayerHistoryRequest(playerId1);
        PlayerHistoryResponse response = new PlayerHistoryResponse(new PlayerHistoryEntity(request));
        if (response.playerId == id) return response;
        return null;
    }

    @Override
    public ArrayList<PlayerHistoryResponse> listPlayerHistories() {
        ArrayList<PlayerHistoryResponse> list = new ArrayList<>();
        PlayerHistoryRequest request1 = new PlayerHistoryRequest(playerId1);
        PlayerHistoryResponse response1 = new PlayerHistoryResponse(new PlayerHistoryEntity(request1));
        PlayerHistoryRequest request2 = new PlayerHistoryRequest(playerId2);
        PlayerHistoryResponse response2 = new PlayerHistoryResponse(new PlayerHistoryEntity(request2));
        PlayerHistoryRequest request3 = new PlayerHistoryRequest(playerId3);
        PlayerHistoryResponse response3 = new PlayerHistoryResponse(new PlayerHistoryEntity(request3));
        list.add(response1);
        list.add(response2);
        list.add(response3);
        return list;
    }
}
