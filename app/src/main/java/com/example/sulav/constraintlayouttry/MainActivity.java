package com.example.sulav.constraintlayouttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sulav.constraintlayouttry.Model.Post;
import com.example.sulav.constraintlayouttry.adapters.RecyclerAdapter;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Post> posts = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load UIL
        loadUil();
        // load data
        //int userid, int likes, int dislikes, String photo_location)
        loadData();

        recyclerAdapter = new RecyclerAdapter(posts, getApplicationContext());

        recyclerView = findViewById(R.id.rV);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadUil() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .diskCacheExtraOptions(480, 800, null)
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(getApplicationContext())) // default
                .imageDecoder(new BaseImageDecoder(false)) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();

        // Apply configuration
        ImageLoader.getInstance().init(config);
    }

    private void loadData() {
        Post post = new Post("sulav","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("ram","ram@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("hari","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("sam","sulav@gmail.com","photolocation");
        posts.add(post);
        post = new Post("tom","sulav@gmail.com","photolocation");
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
