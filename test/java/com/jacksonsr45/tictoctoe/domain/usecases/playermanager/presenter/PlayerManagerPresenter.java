package com.jacksonsr45.tictoctoe.domain.usecases.playermanager.presenter;

import com.jacksonsr45.tictoctoe.domain.presenter.PlayerManagerPresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;

import java.util.ArrayList;

public class PlayerManagerPresenter implements PlayerManagerPresenterInterface {
    private PlayerResponse player;
    private ArrayList<PlayerResponse> players;

    @Override
    public void present(PlayerResponse response) {
        this.player = response;
    }

    @Override
    public void present(ArrayList<PlayerResponse> response) {
        this.players = response;
    }

    public PlayerResponse getPlayer() {
        return this.player;
    }

    public ArrayList<PlayerResponse> getPlayers() { return this.players; }
}
