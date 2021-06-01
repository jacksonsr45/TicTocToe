package com.jacksonsr45.tictoctoe.domain.presenter;


import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;

import java.util.ArrayList;

public interface PlayerHistoryPresenterInterface {
    public void present(ArrayList response);

    public void present(PlayerHistoryResponse response);

    public void present(MatchResponse response);
}
