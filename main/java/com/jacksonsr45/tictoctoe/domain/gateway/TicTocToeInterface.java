package com.jacksonsr45.tictoctoe.domain.gateway;

import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;

public interface TicTocToeInterface {
    public MatchResponse startMatch(MatchEntity entity);

    public MovementsResponse computerMove(MovementEntity entity);

    public MovementsResponse playerMove(MovementEntity entity);

    public PlayerHistoryResponse setPlayerHistory(PlayerHistoryEntity entity);
}