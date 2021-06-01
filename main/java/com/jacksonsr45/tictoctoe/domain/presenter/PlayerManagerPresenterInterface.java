package com.jacksonsr45.tictoctoe.domain.presenter;

import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;

import java.util.ArrayList;

public interface PlayerManagerPresenterInterface {
    public void present(PlayerResponse response);

    public void present(ArrayList<PlayerResponse> response);
}
