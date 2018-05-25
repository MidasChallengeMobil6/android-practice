package com.chaeeun.midaschallengeapp.RecyclerView;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaeeun.midaschallengeapp.R;

public class ReviewRecyclerAdapter extends RecyclerView.Adapter<ReviewRecyclerAdapter.ViewHolder> {

    int[] resIds;
    String[] profile_names;
    String[] profile_texts;
    String[] profile_days;


    public ReviewRecyclerAdapter(int[] resIds, String[] profile_names, String[] profile_texts, String[] profile_days){
        this.resIds = resIds;
        this.profile_names = profile_names;
        this.profile_texts = profile_texts;
        this.profile_days = profile_days;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout cl;

        ViewHolder(ConstraintLayout cl){
            super(cl);
            this.cl = cl;
        }
    }


    @Override
    public ReviewRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout cl = (ConstraintLayout)LayoutInflater.from(parent.getContext()).inflate(R.layout.review_constraint, parent, false);
        ViewHolder holder =new ViewHolder(cl);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        ConstraintLayout cl = holder.cl;
        ImageView profile_img = cl.findViewById(R.id.profile_picture_img);
        TextView profile_name = cl.findViewById(R.id.profile_name_tv);
        TextView profile_text = cl.findViewById(R.id.profile_text_tv);
        TextView profile_day = cl.findViewById(R.id.profile_day_tv);

        Drawable drawable = ContextCompat.getDrawable(cl.getContext(), resIds[position]);
        profile_img.setImageDrawable(drawable);
        profile_name.setText(profile_names[position]);
        profile_text.setText(profile_texts[position]);
        profile_day.setText(profile_days[position]);
    }

    @Override
    public int getItemCount() {
        return profile_names.length;
    }
}
