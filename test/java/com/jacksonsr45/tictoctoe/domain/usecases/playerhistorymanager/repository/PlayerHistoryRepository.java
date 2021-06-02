package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.repository;

import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.entity.playermanager.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.playermanager.MovementsEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerHistoryInterface;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.MatchRequest;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.MovementRequest;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;

import java.util.ArrayList;

public class PlayerHistoryRepository implements PlayerHistoryInterface {
    String matchId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    String matchId2 = "afa36c80-8172-4370-8914-d4a148fa3987";
    String matchId3 = "afa36c80-8172-4370-8914-d4a148fa3456";
    String historyId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    String historyId2 = "afa36c80-8172-4370-8914-d4a148fa3175";
    String historyId3 = "afa36c80-8172-4370-8914-d4a148fa3116";
    String playerId1 = "afa36c80-8172-4370-8914-d4a148fa3128";

    private ArrayList<MatchResponse> matches = new ArrayList<MatchResponse>();
    private MatchRequest match1 = new MatchRequest(matchId1, historyId1, 1, 1, "");
    private MatchEntity entity1 = new MatchEntity(match1);
    private MatchResponse response1 = new MatchResponse(entity1);
    private MatchRequest match2 = new MatchRequest(matchId2, historyId2, 2, 1, "");
    private MatchEntity entity2 = new MatchEntity(match2);
    private MatchResponse response2 = new MatchResponse(entity2);
    private MatchRequest match3 = new MatchRequest(matchId3, historyId3, 3, 1, "");
    private MatchEntity entity3 = new MatchEntity(match3);
    private MatchResponse response3 = new MatchResponse(entity3);


    @Override
    public PlayerHistoryResponse createPlayerHistory(PlayerHistoryEntity playerHistory) {
        return new PlayerHistoryResponse(playerHistory);
    }

    @Override
    public PlayerHistoryResponse showPlayerHistory(String playerId) {
        PlayerHistoryRequest request = new PlayerHistoryRequest(historyId1, playerId1, 1, 0, 0, 1);
        PlayerHistoryEntity entity = new PlayerHistoryEntity(request);
        PlayerHistoryResponse player = new PlayerHistoryResponse(entity);
        if (player.playerId == playerId) return  player;
        return null;
    }
    
    @Override
    public PlayerHistoryResponse deletePlayerHistory(String playerId) {
        PlayerHistoryRequest request = new PlayerHistoryRequest(historyId1, playerId1, 1, 0, 0, 1);
        PlayerHistoryEntity entity = new PlayerHistoryEntity(request);
        PlayerHistoryResponse player = new PlayerHistoryResponse(entity);
        if (player.playerId == playerId) return  null;
        return player;
    }

    @Override
    public ArrayList<MatchResponse> listMatch(String playerHistoryId) {
        matches.add(response1);
        matches.add(response2);
        matches.add(response3);
        return matches;
    }

    @Override
    public MatchResponse showMatch(String id) {
        matches.add(response1);
        matches.add(response2);
        matches.add(response3);
        for (MatchResponse match: matches) {
            if (match.id == id) return match;
        }
        return null;
    }

    @Override
    public ArrayList<MovementsResponse> listMovements(String matchId) {
        ArrayList<MovementsResponse> movements = new ArrayList<MovementsResponse>();
        MovementRequest request1 = new MovementRequest(1, matchId1, 0,0,1);
        MovementsEntity entity1 = new MovementsEntity(request1);
        MovementsResponse response1 = new MovementsResponse(entity1);
        MovementRequest request2 = new MovementRequest(2, matchId1,1,1,1);
        MovementsEntity entity2 = new MovementsEntity(request2);
        MovementsResponse response2 = new MovementsResponse(entity2);
        MovementRequest request3 = new MovementRequest(3, matchId1, 2,2,1);
        MovementsEntity entity3 = new MovementsEntity(request3);
        MovementsResponse response3 = new MovementsResponse(entity3);
        movements.add(response1);
        movements.add(response2);
        movements.add(response3);
        return movements;
    }
}
