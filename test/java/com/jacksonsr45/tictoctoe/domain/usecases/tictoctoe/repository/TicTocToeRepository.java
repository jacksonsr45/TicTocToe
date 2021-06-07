package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.repository;


import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.TicTocToeInterface;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;

public class TicTocToeRepository implements TicTocToeInterface {

    @Override
    public MatchResponse startMatch(MatchEntity entity) {
        return new MatchResponse(entity);
    }

    @Override
    public MatchResponse deleteMatch(String matchID) {
        return null;
    }

    @Override
    public MovementsResponse computerMove(MovementEntity entity) {
        return new MovementsResponse(entity);
    }

    @Override
    public MovementsResponse playerMove(MovementEntity entity) {
        return new MovementsResponse(entity);
    }

    @Override
    public PlayerHistoryResponse setPlayerHistory(PlayerHistoryEntity entity) {
        return new PlayerHistoryResponse(entity);
    }
}
