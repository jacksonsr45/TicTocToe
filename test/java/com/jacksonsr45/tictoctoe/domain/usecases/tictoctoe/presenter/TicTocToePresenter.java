package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.presenter;

import com.jacksonsr45.tictoctoe.domain.presenter.TicTocToePresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;

public class TicTocToePresenter implements TicTocToePresenterInterface {
    private MatchResponse matchResponse;
    private MovementsResponse movementsResponse;
    private PlayerHistoryResponse playerHistoryResponse;

    @Override
    public void present(MatchResponse response) {
        this.matchResponse = response;
    }

    @Override
    public void present(MovementsResponse response) {
        this.movementsResponse = response;
    }

    @Override
    public void present(PlayerHistoryResponse response) {
        this.playerHistoryResponse = response;
    }

    public MatchResponse getMatch() {
        return this.matchResponse;
    }

    public MovementsResponse getMovements() {
        return this.movementsResponse;
    }

    public PlayerHistoryResponse getPlayerHistory() {
        return this.playerHistoryResponse;
    }
}
