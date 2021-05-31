package com.jacksonsr45.tictoctoe.domain.usecases.playermanager.presenter;

import com.jacksonsr45.tictoctoe.domain.presenter.PlayerManagerPresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.PlayerManagerResponse;

import java.util.ArrayList;

public class PlayerManagerPresenter implements PlayerManagerPresenterInterface {
    private PlayerManagerResponse playerViewModel;
    private ArrayList<PlayerManagerResponse> playersViewModel;

    @Override
    public void present(PlayerManagerResponse response) {
        this.playerViewModel = response;
    }

    @Override
    public void present(ArrayList<PlayerManagerResponse> response) {
        this.playersViewModel = response;
    }

    public PlayerManagerResponse getPlayerViewModel() {
        return this.playerViewModel;
    }

    public ArrayList<PlayerManagerResponse> getPlayersViewModel() { return this.playersViewModel; }
}
