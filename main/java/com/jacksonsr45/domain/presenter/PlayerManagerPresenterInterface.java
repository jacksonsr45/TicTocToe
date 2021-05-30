package com.jacksonsr45.domain.presenter;

import com.jacksonsr45.domain.response.PlayerManagerResponse;

import java.util.ArrayList;

public interface PlayerManagerPresenterInterface {
    public void present(PlayerManagerResponse response);

    public void present(ArrayList<PlayerManagerResponse> response);
}
