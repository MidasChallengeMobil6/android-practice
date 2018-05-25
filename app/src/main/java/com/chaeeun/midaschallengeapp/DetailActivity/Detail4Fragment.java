package com.chaeeun.midaschallengeapp.DetailActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chaeeun.midaschallengeapp.R;
import com.chaeeun.midaschallengeapp.RecyclerView.ReviewRecyclerAdapter;
import com.chaeeun.midaschallengeapp.View.ReviewActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Detail4Fragment extends Fragment {


    public Detail4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (View)inflater.inflate(R.layout.fragment_detail4, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.review_rv);
        ReviewRecyclerAdapter adapter = new ReviewRecyclerAdapter(new int[]{R.drawable.group, R.drawable.group}
        ,new String[]{"홍길동", "김철수"}, new String[]{"너무나 명강의였어요", "굿굿"}, new String[]{"2018.05.22","2018.05.22"});
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        Button button = (Button)view.findViewById(R.id.review_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), ReviewActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
