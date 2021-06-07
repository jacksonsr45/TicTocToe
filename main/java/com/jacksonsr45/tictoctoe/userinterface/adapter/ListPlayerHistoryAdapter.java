package com.jacksonsr45.tictoctoe.userinterface.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerHistoryPresenter;

public class ListPlayerHistoryAdapter extends RecyclerView.Adapter<ListPlayerHistoryAdapter.MyViewHolder> {
    private PlayerHistoryPresenter presenter;

    public ListPlayerHistoryAdapter(PlayerHistoryPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listPlayerHistory = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_player_history, parent, false);
        return new MyViewHolder(listPlayerHistory);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewResultDate.setText(this.presenter.getMatches().get(position).createdAt);
        holder.textViewResultTotalMove.setText(this.presenter.getMatches().get(position).level);
        switch (this.presenter.getMatches().get(position).result) {
            case 1:
                holder.imageMinResult.setImageResource(R.drawable.ic_star_min_result_victory);
                break;
            case -1:
                holder.imageMinResult.setImageResource(R.drawable.ic_star_min_result_defeat);
                break;
            default:
                holder.imageMinResult.setImageResource(R.drawable.ic_star_min_result_tie);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return this.presenter.getMatches().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewResultDate, textViewResultTotalMove;
        private ImageView imageMinResult;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewResultDate = itemView.findViewById(R.id.textViewResultDate);
            this.textViewResultTotalMove = itemView.findViewById(R.id.textViewResultLevel);
            this.imageMinResult = itemView.findViewById(R.id.imageMinResult);
        }
    }
}
