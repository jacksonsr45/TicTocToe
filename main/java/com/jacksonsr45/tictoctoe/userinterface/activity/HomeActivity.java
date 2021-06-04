package com.jacksonsr45.tictoctoe.userinterface.activity;

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
    private SmartTabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.tabLayout = findViewById(R.id.tabLayout);
        this.viewPager = findViewById(R.id.viewPager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
              getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Slecione Level", SelectLevelFragment.class)
                .add("Historico", PlayerHistoryFragment.class)
                .create()
        );

        this.viewPager.setAdapter(adapter);
        this.tabLayout.setViewPager(this.viewPager);
    }
}