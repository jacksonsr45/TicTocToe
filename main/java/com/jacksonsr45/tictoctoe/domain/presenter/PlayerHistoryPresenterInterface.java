package com.jacksonsr45.tictoctoe.domain.presenter;

import com.jacksonsr45.tictoctoe.domain.response.PlayerHistoryResponse;

import java.util.ArrayList;

public interface PlayerHistoryPresenterInterface {
    public void present(PlayerHistoryResponse response);

    public void present(ArrayList<PlayerHistoryResponse> response);
}
