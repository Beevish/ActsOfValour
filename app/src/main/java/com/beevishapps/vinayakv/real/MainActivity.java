package com.beevishapps.vinayakv.real;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    NavigationView navigationView = null;
    Toolbar toolbar = null;
    private List<Awards> AwardsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AwardsAdapter mAdapter;
    private CardView cardView;
    private View myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainFragment fragment = new mainFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        recyclerView = (RecyclerView) findViewById(R.id.Rc);
//        mAdapter = new AwardsAdapter(AwardsList, this);
//
//        RecyclerView.LayoutManager mLayoutManger = new LinearLayoutManager((getApplicationContext()));
//        recyclerView.setLayoutManager(mLayoutManger);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
//
//
//
//
//        prepareAwardData();


    }


    private void prepareAwardData() {


        Awards award = new Awards("Param Veer Chakra",
                "" +
                        "One man led  90 against a 900-strong enemy.\nOne man defeated 35 enemy soldiers.\nMen Fighting at -45 degrees.\nBrave soldier, stomach ripped open, kept fighting.\n21 year old refused to be evacuated from a burning tank.",
                "Established: 1950",
                R.drawable.pvc5);
//        getPColor(award.getImageset(), award);
        AwardsList.add(award);

        award = new Awards("Ashoka Chakra",
                "One sub inspector handling 200 militants.\n" +
                        "Brave women showing alertness during 2001 parliament attacks.\n" +
                        "22 year old girl saving lives of more than 300 people.\n",
                "Established: 1952",
                R.drawable.ac3);
//        getPColor(award.getImageset(), award);
        AwardsList.add(award);

        award = new Awards("Maha Veer Chakra",
                "Captain neutralizing enemy position single handedly.\n" +
                        "Soldiers fighting 21000 feet high.\n" +
                        "Capturing of Tiger Hill. \n", "Established: 1950",
                R.drawable.mvc2);
//        getPColor(award.getImageset(), award);
        AwardsList.add(award);

        award = new Awards("Veer Chakra",
                "First victory of Indian Airforce.\n" +
                        "Veer Chakra brothers.\n" +
                        "Skillful Wing Commander landed safely despite several dangers.\n" +
                        "Injured Colonel refusing to evacuate till the objective is accomplished.\n ",
                "Established: 1950",
                R.drawable.vc);
//        getPColor(award.getImageset(), award);
        AwardsList.add(award);


        mAdapter.notifyDataSetChanged();
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


            // this will clear the back stack and displays no animation on the screen
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//.....................................................clearing the stack.....................................


            pvcFragment fragment = new pvcFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack("pvcNavDrawer");//..................................adding fragment to back stack so that on going back i can get my previous screen...and not existing app directly..

            fragmentTransaction.commit();

        } else if (id == R.id.nav_gallery) {


            // this will clear the back stack and displays no animation on the screen
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//.................clearing the stack
            acFragment fragment = new acFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack("acNavDrawer");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_slideshow) {


            // this will clear the back stack and displays no animation on the screen
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//.................clearing the stack
            mvcFragment fragment = new mvcFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack("mvcNavDrawer");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_manage) {


            // this will clear the back stack and displays no animation on the screen
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);//.................clearing the stack
            vcFragment fragment = new vcFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack("vcNavDrawer");
            fragmentTransaction.commit();

        } else if (id == R.id.Home) {


            mainFragment fragment = new mainFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_send) {

            sendEmail(MainActivity.this, new String[]{"vinayaknairv@gmail.com"}, "Send an Email to me",
                    "Name of Hero-Name of Award", "His.....STORY\n\nReference(from where did you verified your story from).\n\nThank you for writing....");

//            Intent email = new Intent(Intent.ACTION_SEND);
//            email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "vinayaknairv@gmail.com"});
//            email.putExtra(Intent.EXTRA_SUBJECT, "Name of Hero-Award");
//            email.putExtra(Intent.EXTRA_TEXT, "His....story");
//
////need this to prompts email client only
//            email.setType("text/plain");
//            startActivity(email);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void sendEmail(MainActivity mainActivity, String[] recipientList, String title, String subject, String body) {

        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipientList);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        MainActivity.this.startActivity(Intent.createChooser(emailIntent, title));
    }


    //....................................................changing the action bar title on click...........................................................
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}
