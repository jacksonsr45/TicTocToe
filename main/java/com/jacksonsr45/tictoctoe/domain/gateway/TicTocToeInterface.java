package com.jacksonsr45.tictoctoe.domain.gateway;

import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;

public interface TicTocToeInterface {
    public MatchResponse startMatch(MatchEntity entity);

    public MatchResponse deleteMatch(String matchID);

    public MatchResponse updateMatch(String matchID, int result);

    public MovementsResponse computerMove(MovementEntity entity);

    public MovementsResponse playerMove(MovementEntity entity);

    public PlayerHistoryResponse setPlayerHistory(PlayerHistoryEntity entity);

    public PlayerHistoryResponse getPlayerHistory(String playerHistoryID);
}
