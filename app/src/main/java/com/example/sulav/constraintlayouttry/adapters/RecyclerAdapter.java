package com.example.sulav.constraintlayouttry.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sulav.constraintlayouttry.Model.Post;
import com.example.sulav.constraintlayouttry.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private static final String TAG = "RecyclerAdapter";
    private ArrayList<Post> posts;
    private Context context;

    public RecyclerAdapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    public RecyclerAdapter(ArrayList<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(posts.get(position).getPhoto_location())
                .into(holder.ivMainPic);
        holder.tvName.setText(posts.get(position).getUserid());
        holder.tvLikes.setText(posts.get(position).getLikes());
        holder.tvDislikes.setText(posts.get(position).getDislikes());
        holder.ivMainPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked");
                Toast.makeText(context, "Main image clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvLikes, tvDislikes;
        CircleImageView ivProfilePic;
        ImageView ivMainPic;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvLikes = itemView.findViewById(R.id.tvLikes);
            tvDislikes = itemView.findViewById(R.id.tvDislikes);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);
            ivMainPic = itemView.findViewById(R.id.ivMainPic);


        }
    }
}
