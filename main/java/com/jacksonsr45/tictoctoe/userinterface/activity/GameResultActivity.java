package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.TicTocToe;
import com.jacksonsr45.tictoctoe.infrastructure.repository.TicTocToeRepository;
import com.jacksonsr45.tictoctoe.userinterface.presenter.TicTocToePresenter;

public class GameResultActivity extends AppCompatActivity {
    private PlayerHistoryRequest request;
    private TicTocToeRepository repository;
    private TicTocToe ticTocToe;
    private TicTocToePresenter presenter;
    private Bundle bundle;
    private Intent intent;

    private ImageView imageEmojiResult, imageStarResult;
    private ImageButton buttonContinueGame, buttonExitToHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
        this.repository = new TicTocToeRepository(getApplicationContext());
        this.ticTocToe = new TicTocToe(this.repository);

        this.bundle = getIntent().getExtras();
        this.presenter = this.bundle.getParcelable("presenter");

        this.ticTocToe.getPlayerHistory(this.presenter.getMatch().playersHistoryId, this.presenter);

        this.request = new PlayerHistoryRequest(
                this.presenter.getMovements().table, this.presenter.getPlayerHistory().id,
                this.presenter.getPlayerHistory().playerId, this.presenter.getPlayerHistory().total,
                this.presenter.getPlayerHistory().victories, this.presenter.getPlayerHistory().defeats,
                this.presenter.getPlayerHistory().ties
        );
        this.ticTocToe.setPlayerHistory(this.request, this.presenter);

        this.imageEmojiResult = findViewById(R.id.imageEmojiResult);
        this.imageStarResult = findViewById(R.id.imageStarResult);
        this.buttonContinueGame = findViewById(R.id.buttonContinueGame);
        this.buttonExitToHome = findViewById(R.id.buttonExitToHome);

        this.getResultInScreen();
        this.initButtonContinueGame();
        this.initButtonExitToHome();
    }

    private void getResultInScreen() {
        switch (this.presenter.getMatch().result) {
            case 1: this.imageEmojiResult.setImageResource(R.drawable.ic_emoji_victory);
                    this.imageStarResult.setImageResource(R.drawable.ic_star_min_result_victory);
                break;
            case -1: this.imageEmojiResult.setImageResource(R.drawable.ic_emoji_defeat);
                this.imageStarResult.setImageResource(R.drawable.ic_star_min_result_defeat);
                break;
            default: this.imageEmojiResult.setImageResource(R.drawable.ic_emoji_tie);
                this.imageStarResult.setImageResource(R.drawable.ic_star_min_result_tie);
                break;
        }
    }

    private void initButtonContinueGame() {
        this.buttonContinueGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InGameActivity.class);
                bundle.putString("playerHistoryID", presenter.getMatch().playersHistoryId);
                bundle.putString("level", String.valueOf(presenter.getMatch().level));
                intent.putExtras(bundle);
                resultLauncher.launch(intent);
            }
        });
    }

    private void initButtonExitToHome() {
        this.buttonExitToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultLauncher.launch(new Intent(getApplicationContext(), MainActivity.class));
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