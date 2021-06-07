package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MatchRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.TicTocToe;
import com.jacksonsr45.tictoctoe.infrastructure.repository.TicTocToeRepository;
import com.jacksonsr45.tictoctoe.userinterface.fragments.GameTableFragment;
import com.jacksonsr45.tictoctoe.userinterface.presenter.TicTocToePresenter;

public class InGameActivity extends AppCompatActivity {
    private MatchRequest request;
    private TicTocToe ticTocToe;
    private TicTocToeRepository repository;
    private TicTocToePresenter presenter;
    private Bundle extras;

    private String playerHistoryID, level;
    private ImageButton buttonCancelMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        this.extras = getIntent().getExtras();
        this.playerHistoryID = this.extras.getString("playerHistoryID");
        this.level = this.extras.getString("level");
        this.buttonCancelMatch = findViewById(R.id.buttonCancelMatch);
        this.presenter = new TicTocToePresenter();
        this.repository = new TicTocToeRepository(getApplicationContext());

        this.createNewMatch();
        this.getFragmentTable();
        this.cancelMatch();
    }

    private void createNewMatch() {
        this.ticTocToe = new TicTocToe(this.repository);
        this.request = new MatchRequest(this.playerHistoryID, Integer.parseInt(this.level));
        this.ticTocToe.startMatch(this.request, this.presenter);
        this.extras.putParcelable("presenter", this.presenter);
    }

    private void getFragmentTable() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.tableLayout, GameTableFragment.class, this.extras);
        transaction.commit();
    }

    private void cancelMatch() {
        this.buttonCancelMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticTocToe.deleteMatch(presenter.getMatch().id, presenter);
                finish();
            }
        });
    }
}