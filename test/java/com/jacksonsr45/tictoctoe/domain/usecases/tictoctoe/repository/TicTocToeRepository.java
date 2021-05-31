package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.repository;

import com.jacksonsr45.tictoctoe.domain.entity.TicTocToeEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.TicTocToeInterface;
import com.jacksonsr45.tictoctoe.domain.response.TicTocToeResponse;

public class TicTocToeRepository implements TicTocToeInterface {
    @Override
    public TicTocToeResponse initGame(TicTocToeEntity entity) {
        return new TicTocToeResponse(entity);
    }

    @Override
    public TicTocToeResponse computerMove(TicTocToeEntity entity) {
        return new TicTocToeResponse(entity);
    }

    @Override
    public TicTocToeResponse playerMove(TicTocToeEntity entity) {
        return new TicTocToeResponse(entity);
    }
}
