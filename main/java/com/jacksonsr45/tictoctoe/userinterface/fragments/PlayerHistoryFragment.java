package com.jacksonsr45.tictoctoe.userinterface.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;


public class PlayerHistoryFragment extends Fragment {
    private static final String ARG_PLAYER_ID = "playerID";

    private String mParam1;

    public PlayerHistoryFragment() {
        // Required empty public constructor
    }
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
            mParam1 = getArguments().getString(ARG_PLAYER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_history, container, false);
        return view;
    }
}