package com.jacksonsr45.tictoctoe.domain.usecases.playermanager.presenter;

import com.jacksonsr45.tictoctoe.domain.presenter.PlayerManagerPresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;

import java.util.ArrayList;

public class PlayerManagerPresenter implements PlayerManagerPresenterInterface {
    private PlayerResponse playerViewModel;
    private ArrayList<PlayerResponse> playersViewModel;

    @Override
    public void present(PlayerResponse response) {
        this.playerViewModel = response;
    }

    @Override
    public void present(ArrayList<PlayerResponse> response) {
        this.playersViewModel = response;
    }

    public PlayerResponse getPlayerViewModel() {
        return this.playerViewModel;
    }

    public ArrayList<PlayerResponse> getPlayersViewModel() { return this.playersViewModel; }
}
