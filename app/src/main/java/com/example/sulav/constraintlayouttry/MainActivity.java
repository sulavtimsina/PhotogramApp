package com.example.sulav.constraintlayouttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sulav.constraintlayouttry.Model.Post;
import com.example.sulav.constraintlayouttry.adapters.RecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Post> posts = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // load data
        //int userid, int likes, int dislikes, String photo_location)
        loadData();
        recyclerAdapter = new RecyclerAdapter(posts, getApplicationContext());

        recyclerView = findViewById(R.id.rV);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadData() {
        Post post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","photolocation");
        posts.add(post);

    }
}
