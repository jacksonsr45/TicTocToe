package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.presenter;

import com.jacksonsr45.tictoctoe.domain.presenter.TicTocToePresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.TicTocToeResponse;

public class TicTocToePresenter implements TicTocToePresenterInterface {
    private TicTocToeResponse ticTocToe;

    @Override
    public void presenter(TicTocToeResponse response) {
        this.ticTocToe = response;
    }

    public TicTocToeResponse ticTocToeViewModel() {
        return this.ticTocToe;
    }
}
