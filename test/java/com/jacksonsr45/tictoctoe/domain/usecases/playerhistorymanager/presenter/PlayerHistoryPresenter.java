package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.presenter;

import com.jacksonsr45.tictoctoe.domain.presenter.PlayerHistoryPresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.PlayerHistoryResponse;

import java.util.ArrayList;

public class PlayerHistoryPresenter implements PlayerHistoryPresenterInterface {
    private PlayerHistoryResponse playerHistoryViewModel;
    private ArrayList<PlayerHistoryResponse> playersHistoryViewModel;

    @Override
    public void present(PlayerHistoryResponse response) {
        this.playerHistoryViewModel = response;
    }

    @Override
    public void present(ArrayList<PlayerHistoryResponse> response) {
        this.playersHistoryViewModel = response;
    }

    public PlayerHistoryResponse getPlayerHistoryViewModel() {
        return this.playerHistoryViewModel;
    }

    public ArrayList<PlayerHistoryResponse> getPlayersHistoryViewModel() {
        return this.playersHistoryViewModel;
    }
}
