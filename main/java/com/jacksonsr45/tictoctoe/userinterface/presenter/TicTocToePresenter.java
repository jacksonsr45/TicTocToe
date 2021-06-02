package com.jacksonsr45.tictoctoe.userinterface.presenter;

import com.jacksonsr45.tictoctoe.domain.presenter.TicTocToePresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;

public class TicTocToePresenter implements TicTocToePresenterInterface {
    private MatchResponse match;
    private MovementsResponse movements;
    private PlayerHistoryResponse playerHistory;

    @Override
    public void present(MatchResponse response) {
        this.match = response;
    }

    @Override
    public void present(MovementsResponse response) {
        this.movements = response;
    }

    @Override
    public void present(PlayerHistoryResponse response) {
        this.playerHistory = response;
    }

    public MatchResponse getMatch() {
        return match;
    }

    public MovementsResponse getMovements() {
        return movements;
    }

    public PlayerHistoryResponse getPlayerHistory() {
        return playerHistory;
    }
}
