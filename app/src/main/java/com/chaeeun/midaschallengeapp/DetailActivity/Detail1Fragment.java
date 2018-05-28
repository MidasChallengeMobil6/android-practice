package com.chaeeun.midaschallengeapp.DetailActivity;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chaeeun.midaschallengeapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Detail1Fragment extends Fragment {


    public Detail1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.fragment_detail1_, container, false);
        ImageView imageView= (ImageView)view.findViewById(R.id.profile_img);
        GradientDrawable drawable = (GradientDrawable)getContext().getDrawable(R.drawable.radius_image);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);
        return view;
    }

}
