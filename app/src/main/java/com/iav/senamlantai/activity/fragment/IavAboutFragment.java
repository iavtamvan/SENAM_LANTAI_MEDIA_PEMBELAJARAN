package com.iav.senamlantai.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iav.vlvollylearning.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IavAboutFragment extends Fragment {


    public IavAboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iav_about, container, false);
    }

}
