package com.example.sulav.constraintlayouttry.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sulav.constraintlayouttry.Model.Post;
import com.example.sulav.constraintlayouttry.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private static final String TAG = "RecyclerAdapter";
    private ArrayList<Post> posts;
    private Context context;

    public RecyclerAdapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    // create a new view
    // Here we attach
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        /* = R.layout.row_item = layout of each row item
           = parent
           = false*/
        View v= layoutInflater.inflate(R.layout.row_item, parent, false);
        /*Pass this view to our MyViewHolder constructor and return it*/
        return new MyViewHolder(v);

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - post is the Post object at the 'position', so we receive it and use it to populate
        // - view components using Post's fields.
        Post post = posts.get(position);
        //here holder is MyViewHolder object, its tvName is the text view which we have referred in
        // MyViewHolder class below. so using this below line, we can set text in that TextView.
        holder.tvName.setText(post.getName());
        holder.tvEmail.setText(post.getEmail());

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(post.getPhoto_location(), holder.ivProfilePic);
    }

    //return the size of arraylist or array
    @Override
    public int getItemCount() {
        return posts.size();
    }

    //This is the class which holds each row item.
    // give reference to all the view components which has to be accessed or modified in runtime
    // like we have to setText in tvName.
    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView tvName, tvEmail;
        ImageView ivProfilePic;


        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);
        }
    }
}
