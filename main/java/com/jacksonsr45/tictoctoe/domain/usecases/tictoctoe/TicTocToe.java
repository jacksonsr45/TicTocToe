package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;


import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.TicTocToeInterface;
import com.jacksonsr45.tictoctoe.domain.presenter.TicTocToePresenterInterface;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MatchRequest;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MovementRequest;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.PlayerHistoryRequest;

public class TicTocToe {
    private TicTocToeInterface ticTocToe;

    public TicTocToe(TicTocToeInterface ticTocToe) {
        this.ticTocToe = ticTocToe;
    }

    public void startMatch(MatchRequest request, TicTocToePresenterInterface presenter) {
        presenter.present(this.ticTocToe.startMatch(new MatchEntity(request)));
    }

    public void getPlayerHistory(String playerHistoryID, TicTocToePresenterInterface presenter) {
        presenter.present(this.ticTocToe.getPlayerHistory(playerHistoryID));
    }

    public void deleteMatch(String matchID, TicTocToePresenterInterface presenter) {
        presenter.present(this.ticTocToe.deleteMatch(matchID));
    }

    public void computerMove(MovementRequest request, TicTocToePresenterInterface presenter) {
        presenter.present(this.ticTocToe.computerMove(new MovementEntity(request)));
    }

    public void playerMove(MovementRequest request, TicTocToePresenterInterface presenter) {
        presenter.present(this.ticTocToe.playerMove(new MovementEntity(request)));
    }

    public void setPlayerHistory(PlayerHistoryRequest request, TicTocToePresenterInterface presenter) {
        presenter.present(this.ticTocToe.setPlayerHistory(new PlayerHistoryEntity(request)));
    }

    public boolean checkResult(Table table) {
        if (table.checkResult(3, 1)) return true;
        else if (table.checkResult(-3,-1)) return true;
        else if (table.checkATie()) return true;
        return false;
    }
}
