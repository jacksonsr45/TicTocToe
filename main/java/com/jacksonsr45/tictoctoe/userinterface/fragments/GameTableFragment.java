package com.jacksonsr45.tictoctoe.userinterface.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MatchRequest;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MovementRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.TicTocToe;
import com.jacksonsr45.tictoctoe.infrastructure.repository.TicTocToeRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.GameResultActivity;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.presenter.TicTocToePresenter;

public class GameTableFragment extends Fragment implements View.OnClickListener {
    private MovementRequest movementRequest;
    private MatchRequest matchRequest;
    private TicTocToe ticTocToe;
    private TicTocToeRepository repository;
    private TicTocToePresenter presenter;

    private Intent intent;
    private Bundle extras;

    private static final String ARG_PRESENTER = "presenter";

    private String playerHistoryID, level, matchID;
    private ImageButton tableButton1, tableButton2, tableButton3, tableButton4, tableButton5,
            tableButton6, tableButton7, tableButton8, tableButton9;
    private TextView textTableButton1, textTableButton2, textTableButton3, textTableButton4,
            textTableButton5, textTableButton6, textTableButton7, textTableButton8, textTableButton9;

    private int count = 1;
    private int movement = 1;

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
        View view = inflater.inflate(R.layout.fragment_game_table, container, false);
        this.playerHistoryID = this.presenter.getMatch().playersHistoryId;
        this.repository = new TicTocToeRepository(getContext());
        this.extras = new Bundle();
        this.intent = new Intent(getContext(), GameResultActivity.class);
        this.ticTocToe = new TicTocToe(this.repository);
        this.matchID = this.presenter.getMatch().id;
        this.level = String.valueOf(this.presenter.getMatch().level);

        this.initButtons(view);
        this.initTextViews(view);
        this.buttonSetOnClickListener();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tableButton1: this.defaultClickButton1();break;
            case R.id.tableButton2: this.defaultClickButton2();break;
            case R.id.tableButton3: this.defaultClickButton3();break;
            case R.id.tableButton4: this.defaultClickButton4();break;
            case R.id.tableButton5: this.defaultClickButton5();break;
            case R.id.tableButton6: this.defaultClickButton6();break;
            case R.id.tableButton7: this.defaultClickButton7();break;
            case R.id.tableButton8: this.defaultClickButton8();break;
            default: this.defaultClickButton9();break;
        }
    }

    private void defaultClickButton1() {
        this.textTableButton1.setText("X");
        this.tableButton1.setClickable(false);
        this.setPlayerMovement(0,0,1);
    }

    private void defaultClickButton2() {
        this.textTableButton2.setText("X");
        this.tableButton2.setClickable(false);
        this.setPlayerMovement(0,1,1);
    }

    private void defaultClickButton3() {
        this.textTableButton3.setText("X");
        this.tableButton3.setClickable(false);
        this.setPlayerMovement(0,2,1);
    }

    private void defaultClickButton4() {
        this.textTableButton4.setText("X");
        this.tableButton4.setClickable(false);
        this.setPlayerMovement(1,0,1);
    }

    private void defaultClickButton5() {
        this.textTableButton5.setText("X");
        this.tableButton5.setClickable(false);
        this.setPlayerMovement(1,1,1);
    }

    private void defaultClickButton6() {
        this.textTableButton6.setText("X");
        this.tableButton6.setClickable(false);
        this.setPlayerMovement(1,2,1);
    }

    private void defaultClickButton7() {
        this.textTableButton7.setText("X");
        this.tableButton7.setClickable(false);
        this.setPlayerMovement(2,0,1);
    }

    private void defaultClickButton8() {
        this.textTableButton8.setText("X");
        this.tableButton8.setClickable(false);
        this.setPlayerMovement(2,1,1);
    }

    private void defaultClickButton9() {
        this.textTableButton9.setText("X");
        this.tableButton9.setClickable(false);
        this.setPlayerMovement(2,2,1);
    }

    private void setPlayerMovement(int line, int column, int value) {
        if (this.presenter.getMovements() == null)
            this.movementRequest = new MovementRequest( this.count, this.matchID,
                    null,line,column,value);
        else this.movementRequest = new MovementRequest( this.count, this.matchID,
                this.presenter.getMovements().table,line,column,value);
        this.ticTocToe.playerMove(this.movementRequest, this.presenter);
        this.count += 1;
        this.movement = -1;
        this.check();
    }

    private void buttonSetOnClickListener() {
        this.tableButton1.setOnClickListener(this);
        this.tableButton2.setOnClickListener(this);
        this.tableButton3.setOnClickListener(this);
        this.tableButton4.setOnClickListener(this);
        this.tableButton5.setOnClickListener(this);
        this.tableButton6.setOnClickListener(this);
        this.tableButton7.setOnClickListener(this);
        this.tableButton8.setOnClickListener(this);
        this.tableButton9.setOnClickListener(this);
    }


    private void initButtons(View view) {
        this.tableButton1 = view.findViewById(R.id.tableButton1);
        this.tableButton2 = view.findViewById(R.id.tableButton2);
        this.tableButton3 = view.findViewById(R.id.tableButton3);
        this.tableButton4 = view.findViewById(R.id.tableButton4);
        this.tableButton5 = view.findViewById(R.id.tableButton5);
        this.tableButton6 = view.findViewById(R.id.tableButton6);
        this.tableButton7 = view.findViewById(R.id.tableButton7);
        this.tableButton8 = view.findViewById(R.id.tableButton8);
        this.tableButton9 = view.findViewById(R.id.tableButton9);
    }

    private void initTextViews(View view) {
        this.textTableButton1 = view.findViewById(R.id.textTableButton1);
        this.textTableButton2 = view.findViewById(R.id.textTableButton2);
        this.textTableButton3 = view.findViewById(R.id.textTableButton3);
        this.textTableButton4 = view.findViewById(R.id.textTableButton4);
        this.textTableButton5 = view.findViewById(R.id.textTableButton5);
        this.textTableButton6 = view.findViewById(R.id.textTableButton6);
        this.textTableButton7 = view.findViewById(R.id.textTableButton7);
        this.textTableButton8 = view.findViewById(R.id.textTableButton8);
        this.textTableButton9 = view.findViewById(R.id.textTableButton9);
    }

    private void computerMove() {
        String value;
        this.movementRequest = new MovementRequest(this.count, this.matchID,
                this.presenter.getMovements().table, Integer.parseInt(this.level), 2);
        this.ticTocToe.computerMove(this.movementRequest, this.presenter);
        int line = this.presenter.getMovements().line;
        int column = this.presenter.getMovements().column;
        value = String.valueOf(line)+String.valueOf(column);
        this.setTableComputerValue(value);
    }

    private void setTableComputerValue(String value) {
        this.count += 1;
        this.movement = 1;
        switch (value) {
            case "00": this.defaultSetTableComputer1();break;
            case "01": this.defaultSetTableComputer2();break;
            case "02": this.defaultSetTableComputer3();break;
            case "10": this.defaultSetTableComputer4();break;
            case "11": this.defaultSetTableComputer5();break;
            case "12": this.defaultSetTableComputer6();break;
            case "20": this.defaultSetTableComputer7();break;
            case "21": this.defaultSetTableComputer8();break;
            default: this.defaultSetTableComputer9();break;
        }
    }

    private void defaultSetTableComputer1() {
        this.textTableButton1.setText("O");
        this.tableButton1.setClickable(false);
    }

    private void defaultSetTableComputer2() {
        this.textTableButton2.setText("O");
        this.tableButton2.setClickable(false);
    }

    private void defaultSetTableComputer3() {
        this.textTableButton3.setText("O");
        this.tableButton3.setClickable(false);
    }

    private void defaultSetTableComputer4() {
        this.textTableButton4.setText("O");
        this.tableButton4.setClickable(false);
    }

    private void defaultSetTableComputer5() {
        this.textTableButton5.setText("O");
        this.tableButton5.setClickable(false);
    }

    private void defaultSetTableComputer6() {
        this.textTableButton6.setText("O");
        this.tableButton6.setClickable(false);
    }

    private void defaultSetTableComputer7() {
        this.textTableButton7.setText("O");
        this.tableButton7.setClickable(false);
    }

    private void defaultSetTableComputer8() {
        this.textTableButton8.setText("O");
        this.tableButton8.setClickable(false);
    }

    private void defaultSetTableComputer9() {
        this.textTableButton9.setText("O");
        this.tableButton9.setClickable(false);
    }

    private void check() {
        if (this.presenter.getMovements().table.checkResult(3, 1) ||
                this.presenter.getMovements().table.checkResult(-3, -1) ||
                this.presenter.getMovements().table.checkATie()) {
            this.extras.putParcelable("presenter", this.presenter);
            this.extras.putInt("result", this.presenter.getMovements().table.getResult());
            this.intent.putExtras(this.extras);
            this.ticTocToe.updateMatch(this.matchID, this.presenter.getMovements().table.getResult());
            resultLauncher.launch(intent);
        } else if (this.movement == -1) {
            this.computerMove();
            this.check();
        }
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