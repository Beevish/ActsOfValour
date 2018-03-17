package com.beevishapps.vinayakv.real;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class pvcFragment extends Fragment {
    RecyclerView recyclerView;
    newResponse.PVCBean responseObj;
    String url = "";
    Gson gson;
    private HeroPicAdapter mAdapter;

    public pvcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pvc, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.pvcRcFragment);//.......................................taking the new recycler view;


//        online=isOnline();  //................................................................................................method for checking if mobile is online or not......................
//        Log.w("Output::::::::::", String.valueOf(online));

        String awardsString = loadJSONFromAsset();
        gson = new Gson();
        responseObj = new newResponse.PVCBean();
        responseObj = gson.fromJson(awardsString, newResponse.PVCBean.class);
        mAdapter = new HeroPicAdapter(getActivity(), responseObj.getHeros());


        RecyclerView.LayoutManager mLayoutManger = new GridLayoutManager((getActivity().getApplicationContext()), 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManger);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

//        getPColor(url, responseObj.getHeros());
        recyclerView.setAdapter(mAdapter);


        return view;
    }

    private String loadJSONFromAsset() {

        String json = null;

        try {

            InputStream is = getActivity().getAssets().open("pvcData.json");
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

    @Override
    public void onResume() {
        super.onResume();


        ((MainActivity) getActivity()).setActionBarTitle("Param Veers");
    }


}
