package com.jacksonsr45.tictoctoe.domain.presenter;

import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;

public interface TicTocToePresenterInterface {
    public void present(MatchResponse response);

    public void present(MovementsResponse response);

    public void present(PlayerHistoryResponse response);
}
