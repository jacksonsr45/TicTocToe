package com.jacksonsr45.tictoctoe.userinterface.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.PlayerHistoryManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerHistoryRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.InGameActivity;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerHistoryPresenter;


public class SelectLevelFragment extends Fragment {
    private Intent intent;
    private PlayerHistoryRequest request;
    private PlayerHistoryPresenter presenter;
    private PlayerHistoryRepository repository;
    private PlayerHistoryManager playerHistoryManager;

    private static final String ARG_PLAYER_ID = "playerID";
    private static final String ARG_LEVEL = "level";
    private static final String ARG_PLAYER_HISTORY_ID = "playerHistoryID";
    private static final String SELECT_LEVEL_EASY = "0";
    private static final String SELECT_LEVEL_MEDIUM = "1";
    private static final String SELECT_LEVEL_HARD = "2";

    private String playerID, playerHistoryID;
    private ImageButton buttonLevelEasy, buttonLevelMedium, buttonLevelHard, buttonExit;

    public SelectLevelFragment() { }

    public static SelectLevelFragment newInstance(String playerID) {
        SelectLevelFragment fragment = new SelectLevelFragment();
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
        View view = inflater.inflate(R.layout.fragment_select_level, container, false);
        this.repository = new PlayerHistoryRepository(getContext());
        this.playerHistoryManager = new PlayerHistoryManager(this.repository);
        this.presenter = new PlayerHistoryPresenter();
        this.checkPlayerHistoricExist();
        this.buttonLevelEasy = view.findViewById(R.id.buttonLevelEasy);
        this.buttonLevelMedium = view.findViewById(R.id.buttonLevelMedium);
        this.buttonLevelHard = view.findViewById(R.id.buttonLevelHard);
        this.buttonExit = view.findViewById(R.id.buttonExit);

        this.handleLevelEasy();
        this.handleLevelMedium();
        this.handleLevelHard();
        this.exit();
        return view;
    }

    public void checkPlayerHistoricExist() {
        this.request = new PlayerHistoryRequest(this.playerID);
        this.playerHistoryManager.showPlayerHistory(this.playerID, this.presenter);
        if (this.presenter.getPlayerHistory() == null)
            this.playerHistoryManager.createPlayerHistory(this.request, this.presenter);
        this.playerHistoryID = this.presenter.getPlayerHistory().id;
    }

    public void handleLevelEasy() {
        this.buttonLevelEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(), InGameActivity.class);
                intent.putExtra(ARG_LEVEL, SELECT_LEVEL_EASY);
                intent.putExtra(ARG_PLAYER_HISTORY_ID, playerHistoryID);
                resultLauncher.launch(intent);
            }
        });
    }

    public void handleLevelMedium() {
        this.buttonLevelMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(), InGameActivity.class);
                intent.putExtra(ARG_LEVEL, SELECT_LEVEL_MEDIUM);
                intent.putExtra(ARG_PLAYER_HISTORY_ID, playerHistoryID);
                resultLauncher.launch(intent);
            }
        });
    }

    public void handleLevelHard() {
        this.buttonLevelHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(), InGameActivity.class);
                intent.putExtra(ARG_LEVEL, SELECT_LEVEL_HARD);
                intent.putExtra(ARG_PLAYER_HISTORY_ID, playerHistoryID);
                resultLauncher.launch(intent);
            }
        });
    }

    public void exit() {
        this.buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAffinity();
            }
        });
    }

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                    }
                }
            });
}