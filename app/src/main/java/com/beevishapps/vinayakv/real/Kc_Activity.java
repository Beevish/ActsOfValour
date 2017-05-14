package com.beevishapps.vinayakv.real;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class Kc_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    newResponse.PVCBean responseObj;
    Gson gson;
    private HeroPicAdapter mAdapter;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kc_);

        recyclerView = (RecyclerView) findViewById(R.id.kcRc);//.......................................taking the new recycler view;

        String awardsString=loadJSONFromAsset();
        gson=new Gson();
        responseObj = new newResponse.PVCBean();
        responseObj = gson.fromJson(awardsString,newResponse.PVCBean.class);
        mAdapter= new HeroPicAdapter(Kc_Activity.this,responseObj.getHeros());

        RecyclerView.LayoutManager mLayoutManger = new GridLayoutManager((getApplicationContext()), 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManger);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


//        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//
//        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
//        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
//
//        dynamicToolbarColor();



    }
    public String loadJSONFromAsset() {
        String json = null;

        try {

            InputStream is = getAssets().open("kcData.json");
            //InputStream is = getAssets().open("pvcData.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

//    private void dynamicToolbarColor() {
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
//                R.drawable.ac3);
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//
//            @Override
//            public void onGenerated(Palette palette) {
//                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(getResources().getColor(R.color.colorPrimary)));
//                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(getResources().getColor(R.color.colorPrimary)));
//            }
//        });
//    }







}
