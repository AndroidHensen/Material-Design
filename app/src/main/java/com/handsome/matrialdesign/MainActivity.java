package com.handsome.matrialdesign;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    FloatingActionButton float_button;
    CollapsingToolbarLayout collapsing_layout;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer_layout;
    NavigationView navigation_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        float_button = (FloatingActionButton) findViewById(R.id.float_button);
        collapsing_layout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_layout);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置回滚时、拓展时标题的颜色
        collapsing_layout.setTitle("Material Design");
        collapsing_layout.setCollapsedTitleTextColor(Color.WHITE);
        collapsing_layout.setExpandedTitleColor(Color.WHITE);

        float_button.setOnClickListener(this);

        //增加菜单开关按钮
        toggle = new ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        //去除滚动条
        navigation_view.getChildAt(0).setVerticalScrollBarEnabled(false);
        navigation_view.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "This is Snackbar", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }

    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }
}
