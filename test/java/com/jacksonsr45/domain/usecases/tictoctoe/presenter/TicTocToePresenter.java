package com.jacksonsr45.domain.usecases.tictoctoe.presenter;

import com.jacksonsr45.domain.presenter.TicTocToePresenterInterface;
import com.jacksonsr45.domain.response.TicTocToeResponse;

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
