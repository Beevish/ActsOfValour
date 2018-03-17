package com.beevishapps.vinayakv.real;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class mainFragment extends Fragment {


    private List<Awards> AwardsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AwardsAdapter mAdapter;


    public mainFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.RcFragment);
//        recyclerView =  new RecyclerView(getContext());
        mAdapter = new AwardsAdapter(AwardsList, getActivity());

        RecyclerView.LayoutManager mLayoutManger = new LinearLayoutManager((getActivity().getApplicationContext()));
        recyclerView.setLayoutManager(mLayoutManger);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        prepareAwardData();
        // Inflate the layout for this fragment
        return view;
    }

    private void prepareAwardData() {
        AwardsList.clear();//.................................................empting array in awards screen else it is getting added one below the other...............................................................
        Awards award = new Awards("Param Veer Chakra",
                "" +
                        "One man led 90 against a 900-strong enemy.\nOne man defeated 35 enemy soldiers.\nMen Fighting at -45 degrees.\nBrave soldier, stomach ripped open, kept fighting.\n21 year old refused to be evacuated from a burning tank.",
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
    public void onResume() {
        super.onResume();


        ((MainActivity) getActivity()).setActionBarTitle("Acts of Valour");
    }
}
