package com.chaeeun.midaschallengeapp.DetailActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chaeeun.midaschallengeapp.R;

public class DetailActivity extends AppCompatActivity {

    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("(강추) 아기 신발 만들기 강의");

        actionBar.setDisplayHomeAsUpEnabled(true);

        TabLayout tabs = (TabLayout)findViewById(R.id.menu_tab);
        tabs.addTab(tabs.newTab().setText("수업소개"));
        tabs.addTab(tabs.newTab().setText("커리큘럼"));
        tabs.addTab(tabs.newTab().setText("장소/시간"));
        tabs.addTab(tabs.newTab().setText("리뷰"));
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        container = (FrameLayout) findViewById(R.id.container_fl);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_fl, new Detail1Fragment());
        transaction.commit();



        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch(tab.getPosition()){
                    case 0:
                        transaction.replace(R.id.container_fl, new Detail1Fragment());
                        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commit();
                        break;
                    case 1:
                        transaction.replace(R.id.container_fl, new Detail2Fragment());
                        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commit();
                        break;
                    case 2:
                        transaction.replace(R.id.container_fl, new Detail3Fragment());
                        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commit();
                        break;
                    case 3:
                        transaction.replace(R.id.container_fl, new Detail4Fragment());
                        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.like:
                Toast toast = Toast.makeText(getApplicationContext(), "좋아요", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.upload:
                Toast toast1 = Toast.makeText(getApplicationContext(), "업로드", Toast.LENGTH_SHORT);
                toast1.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
