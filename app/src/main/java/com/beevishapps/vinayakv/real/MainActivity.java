package com.beevishapps.vinayakv.real;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private List<Awards> AwardsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AwardsAdapter mAdapter;

    private CardView cardView;
    private View myview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FrameLayout frameLayoutBalance = (FrameLayout)findViewById(R.id.framelayouthome);
//        frameLayoutBalance.setBackgroundColor(Color.parseColor("#020830"));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //    myview=(View) findViewById(R.id.myview);
        recyclerView = (RecyclerView) findViewById(R.id.Rc);
        mAdapter = new AwardsAdapter(AwardsList, this);

        RecyclerView.LayoutManager mLayoutManger = new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(mLayoutManger);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

//        myview.setBackgroundResource(R.color.transp);
//        myview.getBackground().setAlpha(45);


        prepareAwardData();


    }


    private void prepareAwardData() {


        Awards award = new Awards("Param Veer Chakra",
                "" +
                        "One man led  90 against a 900-strong enemy.\nOne man defeated 35 enemy soldiers.\nMen Fighting at -45 degrees.\nBrave soldier, stomach ripped open, kept fighting.\n21 year old refused to be evacuated from a burning tank.",
                "Established: 1950",
                R.drawable.pvc5);
        getPColor(award.getImageset(), award);
        AwardsList.add(award);

        award = new Awards("Ashoka Chakra",
                "One sub inspector handling 200 militants.\n" +
                        "Brave women showing alertness during 2001 parliament attacks.\n" +
                        "22 year old girl saving lives of more than 300 people.\n",
                "Established: 1952",
                R.drawable.ac3);
        getPColor(award.getImageset(), award);
        AwardsList.add(award);

        award = new Awards("Maha Veer Chakra",
                "Captain neutralizing enemy position single handedly.\n" +
                        "Soldiers fighting 21000 feet high.\n" +
                        "Capturing of Tiger Hill. \n", "Established: 1950",
                R.drawable.mvc2);
        getPColor(award.getImageset(), award);
        AwardsList.add(award);

        award = new Awards("Veer Chakra",
                "First victory of Indian Airforce.\n" +
                        "Veer Chakra brothers.\n" +
                        "Skillful Wing Commander landed safely despite several dangers.\n" +
                        "Injured Colonel refusing to evacuate till the objective is accomplished.\n ",
                "Established: 1950",
                R.drawable.vir_chakra);
        getPColor(award.getImageset(), award);
        AwardsList.add(award);


        mAdapter.notifyDataSetChanged();
    }

    void getPColor(int id, final Awards pp) {


        Bitmap photo = BitmapFactory.decodeResource(getApplicationContext().getResources(), id);


        // Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nyancat);
        if (photo != null && !photo.isRecycled()) {
            Palette palette = Palette.from(photo).generate();
            int default1 = getApplicationContext().getResources().getColor(R.color.cardview_dark_background);
            int p1color = palette.getMutedColor(getApplicationContext().getResources().getColor(android.R.color.black)); //palette.getMutedColor(getApplicationContext().getResources().getColor(android.R.color.black));


            pp.pcolor = default1;


        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent pvc = new Intent(MainActivity.this, Pvc_Activity.class);
            MainActivity.this.startActivity(pvc);
        } else if (id == R.id.nav_gallery) {
            Intent ac = new Intent(MainActivity.this, Ac_Activity.class);
            MainActivity.this.startActivity(ac);

        } else if (id == R.id.nav_slideshow) {
            Intent mvc = new Intent(MainActivity.this, Mvc_Activity.class);
            MainActivity.this.startActivity(mvc);

        } else if (id == R.id.nav_manage) {
            Intent vc = new Intent(MainActivity.this, Kc_Activity.class);
            MainActivity.this.startActivity(vc);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
