package com.jacksonsr45.tictoctoe.userinterface.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.PlayerHistoryManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerHistoryRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.adapter.ListPlayerHistoryAdapter;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerHistoryPresenter;


public class PlayerHistoryFragment extends Fragment {
    private Intent intent;
    private PlayerHistoryRequest request;
    private PlayerHistoryPresenter presenter;
    private PlayerHistoryRepository repository;
    private PlayerHistoryManager playerHistoryManager;

    private static final String ARG_PLAYER_ID = "playerID";

    private String playerID;
    private RecyclerView listViewResult;
    private TextView textViewTotalVictories, textViewTotalDefeats, textViewTotalTies, textViewResultTotal;

    public PlayerHistoryFragment() { }

    public static PlayerHistoryFragment newInstance(String playerID) {
        PlayerHistoryFragment fragment = new PlayerHistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PLAYER_ID, playerID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.playerID = getArguments().getString(ARG_PLAYER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_history, container, false);
        this.repository = new PlayerHistoryRepository(getContext());
        this.playerHistoryManager = new PlayerHistoryManager(this.repository);
        this.presenter = new PlayerHistoryPresenter();
        this.listViewResult = view.findViewById(R.id.listViewResult);
        this.textViewTotalVictories = view.findViewById(R.id.textViewTotalVictories);
        this.textViewTotalDefeats = view.findViewById(R.id.textViewTotalDefeats);
        this.textViewTotalTies = view.findViewById(R.id.textViewTotalTies);
        this.textViewResultTotal = view.findViewById(R.id.textViewResultTotal);

        this.playerHistoryManager.showPlayerHistory(this.playerID, this.presenter);
        if (this.presenter.getPlayerHistory() == null)
            this.playerHistoryManager.createPlayerHistory(this.request, this.presenter);

        if (this.presenter.getMatches() != null) {
            ListPlayerHistoryAdapter adapter = new ListPlayerHistoryAdapter(this.presenter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            this.listViewResult.setLayoutManager(layoutManager);
            this.listViewResult.setHasFixedSize(true);
            this.listViewResult.setAdapter(adapter);
        }

        this.textViewTotalVictories.setText(String.valueOf(this.presenter.getPlayerHistory().victories));
        this.textViewTotalDefeats.setText(String.valueOf(this.presenter.getPlayerHistory().defeats));
        this.textViewTotalTies.setText(String.valueOf(this.presenter.getPlayerHistory().ties));
        this.textViewResultTotal.setText(String.valueOf(this.presenter.getPlayerHistory().total));

        return view;
    }
}