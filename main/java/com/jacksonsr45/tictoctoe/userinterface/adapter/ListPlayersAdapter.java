package com.jacksonsr45.tictoctoe.userinterface.adapter;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;

import java.util.ArrayList;

public class ListPlayersAdapter extends RecyclerView.Adapter<ListPlayersAdapter.MyViewHolder> {
    private ArrayList<PlayerResponse> playerList;

    public ListPlayersAdapter(ArrayList<PlayerResponse> players) {
        this.playerList = players;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listPlayers = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_players, parent, false);
        return new MyViewHolder(listPlayers);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.playerName.setText(this.playerList.get(position).name);
        holder.selectPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.deletePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.playerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView playerName;
        private ImageButton selectPlayer;
        private ImageButton deletePlayer;

        @SuppressLint("ResourceType")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.playerName = itemView.findViewById(R.id.textListPlayerName);
            this.deletePlayer = itemView.findViewById(R.id.buttonListDeletePlayer);
            this.selectPlayer = itemView.findViewById(R.id.buttonListSelectPlayer);
        }
    }
}
