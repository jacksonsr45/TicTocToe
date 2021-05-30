package com.jacksonsr45.domain.usecases.tictoctoe;

import com.jacksonsr45.domain.entity.TicTocToeEntity;
import com.jacksonsr45.domain.gateway.TicTocToeInterface;
import com.jacksonsr45.domain.presenter.TicTocToePresenterInterface;
import com.jacksonsr45.domain.request.TicTocToeRequest;

public class TicTocToe {
    private TicTocToeInterface ticTocToe;

    public TicTocToe(TicTocToeInterface ticTocToe) {
        this.ticTocToe = ticTocToe;
    }

    public void initGame(TicTocToeRequest request, TicTocToePresenterInterface presenter) {
        presenter.presenter(ticTocToe.initGame(new TicTocToeEntity(request)));
    }

    public void computerMove(TicTocToeRequest request, TicTocToePresenterInterface presenter) {
        request.getComputer().move(request.getTable(), 2, -1);
        presenter.presenter(ticTocToe.computerMove(new TicTocToeEntity(request)));
    }

    public void playerMove(TicTocToeRequest request, TicTocToePresenterInterface presenter) {
        presenter.presenter(ticTocToe.playerMove(new TicTocToeEntity(request)));
    }
}
