package com.jacksonsr45.tictoctoe.userinterface.adapter;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.PlayerManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerManagerRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.HomeActivity;
import com.jacksonsr45.tictoctoe.userinterface.activity.MainActivity;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerManagerPresenter;


public class ListPlayersAdapter extends RecyclerView.Adapter<ListPlayersAdapter.MyViewHolder> {
    private PlayerManagerPresenter presenter;

    public ListPlayersAdapter(PlayerManagerPresenter presenter) {
        this.presenter = presenter;
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
        holder.playerName.setText(this.presenter.getPlayers().get(position).name);
        holder.selectPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                intent.putExtra("playerID", presenter.getPlayers().get(position).id);
                v.getContext().startActivity(intent);
            }
        });
        holder.deletePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerManagerRepository repository = new PlayerManagerRepository(v.getContext());
                PlayerManager player = new PlayerManager(repository);
                player.deletePlayer( presenter.getPlayers().get(position).id, presenter);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.presenter.getPlayers().size();
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
