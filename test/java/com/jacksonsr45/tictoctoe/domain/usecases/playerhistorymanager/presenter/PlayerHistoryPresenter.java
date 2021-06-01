package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.presenter;

import com.jacksonsr45.tictoctoe.domain.presenter.PlayerHistoryPresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;

import java.util.ArrayList;

public class PlayerHistoryPresenter implements PlayerHistoryPresenterInterface {
    private PlayerHistoryResponse playerHistory;
    private MatchResponse match;
    private ArrayList<MatchResponse> matches;
    private ArrayList<MovementsResponse> movements;

    @Override
    public void present(ArrayList response) {
        if ( response.get(0).getClass() == MatchResponse.class) this.matches = response;
        else if ( response.get(0).getClass() == MovementsResponse.class) this.movements = response;
    }

    @Override
    public void present(PlayerHistoryResponse response) {
        this.playerHistory = response;
    }

    @Override
    public void present(MatchResponse response) {
        this.match = response;
    }

    public MatchResponse getMatch() {
        return match;
    }

    public ArrayList<MovementsResponse> getMovements() {
        return movements;
    }

    public PlayerHistoryResponse getPlayerHistory() {
        return playerHistory;
    }

    public ArrayList<MatchResponse> getMatches() {
        return matches;
    }
}
