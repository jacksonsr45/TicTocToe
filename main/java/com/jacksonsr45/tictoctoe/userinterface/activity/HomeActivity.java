package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.fragments.PlayerHistoryFragment;
import com.jacksonsr45.tictoctoe.userinterface.fragments.SelectLevelFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class HomeActivity extends AppCompatActivity {
    private Bundle extras, bundle;
    private SmartTabLayout tabLayout;
    private ViewPager viewPager;

    private String playerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.extras = getIntent().getExtras();
        this.playerID = this.extras.getString("playerID");
        this.bundle = new Bundle();
        this.bundle.putString("playerID", this.playerID);

        this.tabLayout = findViewById(R.id.tabLayout);
        this.viewPager = findViewById(R.id.viewPager);

        FragmentPagerItems pages = new FragmentPagerItems(getApplicationContext());
        pages.add(FragmentPagerItem.of(
                getString(R.string.text_select_level), SelectLevelFragment.class, this.bundle));
        pages.add(FragmentPagerItem.of(
                getString(R.string.text_player_history), PlayerHistoryFragment.class, this.bundle));
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages
        );

        this.viewPager.setAdapter(adapter);
        this.tabLayout.setViewPager(this.viewPager);
    }
}