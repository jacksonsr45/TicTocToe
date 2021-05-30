package com.jacksonsr45.domain.gateway;

import com.jacksonsr45.domain.entity.TicTocToeEntity;
import com.jacksonsr45.domain.response.TicTocToeResponse;

public interface TicTocToeInterface {
    public TicTocToeResponse initGame(TicTocToeEntity entity);

    public TicTocToeResponse computerMove(TicTocToeEntity entity);

    public TicTocToeResponse playerMove(TicTocToeEntity entity);
}
