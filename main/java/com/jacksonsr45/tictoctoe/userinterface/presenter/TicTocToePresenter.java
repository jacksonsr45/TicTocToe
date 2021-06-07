package com.jacksonsr45.tictoctoe.userinterface.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import com.jacksonsr45.tictoctoe.domain.presenter.TicTocToePresenterInterface;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.PlayerHistoryResponse;

public class TicTocToePresenter implements TicTocToePresenterInterface, Parcelable {
    private MatchResponse match;
    private MovementsResponse movements;
    private PlayerHistoryResponse playerHistory;

    public TicTocToePresenter() {}

    protected TicTocToePresenter(Parcel in) {
        this.match = (MatchResponse) in.readValue(MatchResponse.class.getClassLoader());
        this.movements = (MovementsResponse) in.readValue(MovementsResponse.class.getClassLoader());
        this.playerHistory = (PlayerHistoryResponse) in.readValue(PlayerHistoryResponse.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(match);
        dest.writeValue(movements);
        dest.writeValue(playerHistory);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TicTocToePresenter> CREATOR = new Creator<TicTocToePresenter>() {
        @Override
        public TicTocToePresenter createFromParcel(Parcel in) {
            return new TicTocToePresenter(in);
        }

        @Override
        public TicTocToePresenter[] newArray(int size) {
            return new TicTocToePresenter[size];
        }
    };

    @Override
    public void present(MatchResponse response) {
        this.match = response;
    }

    @Override
    public void present(MovementsResponse response) {
        this.movements = response;
    }

    @Override
    public void present(PlayerHistoryResponse response) {
        this.playerHistory = response;
    }

    public MatchResponse getMatch() {
        return match;
    }

    public MovementsResponse getMovements() {
        return movements;
    }

    public PlayerHistoryResponse getPlayerHistory() {
        return playerHistory;
    }
}
