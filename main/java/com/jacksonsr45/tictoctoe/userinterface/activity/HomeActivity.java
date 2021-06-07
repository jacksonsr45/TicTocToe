package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.fragments.PlayerHistoryFragment;
import com.jacksonsr45.tictoctoe.userinterface.fragments.SelectLevelFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class HomeActivity extends AppCompatActivity {
    private Bundle extras;
    private SmartTabLayout tabLayout;
    private ViewPager viewPager;

    private String playerID;

    private SelectLevelFragment selectLevelFragment;
    private PlayerHistoryFragment playerHistoryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.extras = getIntent().getExtras();
        this.playerID = this.extras.getString("playerID");

        this.selectLevelFragment = new SelectLevelFragment();
        this.playerHistoryFragment = new PlayerHistoryFragment();
        this.selectLevelFragment.newInstance(this.playerID);
        this.playerHistoryFragment.newInstance(this.playerID);

        this.tabLayout = findViewById(R.id.tabLayout);
        this.viewPager = findViewById(R.id.viewPager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
              getSupportFragmentManager(), FragmentPagerItems.with(getApplicationContext())
                .add(R.string.text_select_level, SelectLevelFragment.class)
                .add(R.string.text_player_history, PlayerHistoryFragment.class)
                .create()
        );

        this.viewPager.setAdapter(adapter);
        this.tabLayout.setViewPager(this.viewPager);
    }
}