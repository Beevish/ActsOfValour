package com.beevishapps.vinayakv.real;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;

public class Pvc_Activity extends AppCompatActivity{


    //    RecyclerView recyclerView;
//    newResponse.PVCBean responseObj;
//    String url="";
//    Gson gson;
//    private HeroPicAdapter mAdapter;
    int pcolor;

    boolean online;
    AsyncHttpClient client;

    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvc_);

//        recyclerView = (RecyclerView) findViewById(R.id.pvcRc);//.......................................taking the new recycler view;
//
//
//        online=isOnline();  //................................................................................................method for checking if mobile is online or not......................
//        Log.w("Output::::::::::", String.valueOf(online));
//
//        String awardsString=loadJSONFromAsset();
//        gson=new Gson();
//        responseObj = new newResponse.PVCBean();
//        responseObj = gson.fromJson(awardsString,newResponse.PVCBean.class);
//        mAdapter= new HeroPicAdapter(Pvc_Activity.this,responseObj.getHeros());
        //recyclerView.setAdapter(mAdapter);


        //................................for taking json from network{

//        client =new AsyncHttpClient();
//        client.get(Pvc_Activity.this, url, new AsyncHttpResponseHandler() {

//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                String responsestr=new String(responseBody);
//                gson=new Gson();

//                mAdapter= new HeroPicAdapter(Pvc_Activity.this,responseObj.getHeros());
//                recyclerView.setAdapter(mAdapter);
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//            }
//        });


    //}
//        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);



        //...for grid image layout

        //mAdapter = new HeroPicAdapter(Heropics_List, this);

//        RecyclerView.LayoutManager mLayoutManger = new GridLayoutManager((getApplicationContext()), 2, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(mLayoutManger);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//
////        getPColor(url, responseObj.getHeros());
//        recyclerView.setAdapter(mAdapter);

/*
*  id = in.readString();
                name = in.readString();
                title = in.readString();
                operation = in.readString();
                url = in.readString();
                moredescription = in.readString();
                description = in.readString();
                pColor = in.readInt();
 */


      //  prepareHeropic_Data();    //................static data preparation...


//        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
//        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);

//        dynamicToolbarColor();
    }


    //................................................................................................method for checking if mobile is online or not......................
//    public boolean isOnline() {
//        ConnectivityManager cm =
//                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netInfo = cm.getActiveNetworkInfo();
//        return netInfo != null && netInfo.isConnectedOrConnecting();
//    }




    //json getting it from the file inside the asset folder....................................................................


//    public String loadJSONFromAsset() {
//        String json = null;
//
//        try {
//
//            InputStream is = getAssets().open("pvcData.json");
//            //InputStream is = getAssets().open("pvcData.json");
//
//            int size = is.available();
//
//            byte[] buffer = new byte[size];
//
//            is.read(buffer);
//
//            is.close();
//
//            json = new String(buffer, "UTF-8");
//
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//
//    }






    //Pallete coloring.......................................
//    void getPColor(int id, final newResponse.PVCBean.HerosBean pp) {
//
//
//        Bitmap photo = BitmapFactory.decodeResource(getApplicationContext().getResources(), id);
//
//
//        // Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nyancat);
//        if (photo != null && !photo.isRecycled()) {
//            Palette palette = Palette.from(photo).generate();
//            int default1 = getApplicationContext().getResources().getColor(R.color.colorPrimary);
//            int p1color = palette.getMutedColor(getApplicationContext().getResources().getColor(android.R.color.black)); //palette.getMutedColor(getApplicationContext().getResources().getColor(android.R.color.black));
//            //int p1color = palette.getVibrantColor(getApplicationContext().getResources().getColor(android.R.color.black)); //palette.getMutedColor(getApplicationContext().getResources().getColor(android.R.color.black));
//
//
//            pp.pColor = p1color;
//
//
//        }


    }

//    private void dynamicToolbarColor() {
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
//                R.drawable.pvc5);
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//
//            @Override
//            public void onGenerated(Palette palette) {
//                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(getResources().getColor(R.color.colorPrimary)));
//                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(getResources().getColor(R.color.colorPrimary)));
//            }
//        });
//    }
//}
