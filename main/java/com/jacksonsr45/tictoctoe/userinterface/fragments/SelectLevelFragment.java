package com.jacksonsr45.tictoctoe.userinterface.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;


public class SelectLevelFragment extends Fragment {
    private static final String ARG_PLAYER_ID = "playerID";

    private String playerID;

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
            playerID = getArguments().getString(ARG_PLAYER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_level, container, false);
//        System.out.println(getArguments().getString(ARG_PLAYER_ID));
        return view;
    }
}