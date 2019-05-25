package com.iav.senamlantai.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.iav.vlvollylearning.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppAboutFragment extends Fragment {


    private ImageView ivLogo;

    public AppAboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_app, container, false);
        initView(view);

        Glide.with(getActivity()).load(R.drawable.pustaka).into(ivLogo);
        return view;
    }

    private void initView(View view) {
        ivLogo = view.findViewById(R.id.ivLogo);
    }
}
