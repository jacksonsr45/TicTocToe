package com.jacksonsr45.tictoctoe.userinterface.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MatchRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.TicTocToe;
import com.jacksonsr45.tictoctoe.infrastructure.repository.TicTocToeRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.presenter.TicTocToePresenter;

public class GameTableFragment extends Fragment {
    private MatchRequest request;
    private TicTocToe ticTocToe;
    private TicTocToeRepository repository;
    private TicTocToePresenter presenter;

    private static final String ARG_PRESENTER = "presenter";

    private String playerHistoryID, level, matchID;

    public GameTableFragment() { }

    public static GameTableFragment newInstance(TicTocToePresenter presenter) {
        GameTableFragment fragment = new GameTableFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PRESENTER, presenter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.presenter = getArguments().getParcelable(ARG_PRESENTER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, container, false);
        this.playerHistoryID = this.presenter.getMatch().playersHistoryId;
        this.matchID = this.presenter.getMatch().id;
        this.level = String.valueOf(this.presenter.getMatch().level);

        return view;
    }
}