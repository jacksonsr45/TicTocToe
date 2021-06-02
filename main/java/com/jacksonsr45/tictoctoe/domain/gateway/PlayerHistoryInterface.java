package com.jacksonsr45.tictoctoe.domain.gateway;

import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;

import java.util.ArrayList;

public interface PlayerHistoryInterface {
    public PlayerHistoryResponse createPlayerHistory(PlayerHistoryEntity playerHistory);

    public PlayerHistoryResponse deletePlayerHistory(String playerId);

    public PlayerHistoryResponse showPlayerHistory(String playerId);

    public ArrayList<MatchResponse> listMatch(String playerHistoryId);

    public MatchResponse showMatch(String id);

    public ArrayList<MovementsResponse> listMovements(String matchId);
}
