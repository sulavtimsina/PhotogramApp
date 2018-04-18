package com.example.sulav.constraintlayouttry.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sulav.constraintlayouttry.Model.Post;
import com.example.sulav.constraintlayouttry.R;
import com.example.sulav.constraintlayouttry.adapters.RecyclerAdapter;
import com.example.sulav.constraintlayouttry.retrofit.ApiInterface;
import com.example.sulav.constraintlayouttry.retrofit.RetrofitClient;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Post> posts = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getApiClient().create(ApiInterface.class);

        loadUil();
        // load data
        loadDataFromJson();

//        recyclerAdapter = new RecyclerAdapter(posts, getApplicationContext());

        recyclerView = findViewById(R.id.rV);
//        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadDataFromJson() {
        Call<List<Post>> call = apiInterface.getPosts();

        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                Call<List<Post>> ram = call;
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                posts = (ArrayList<Post>) response.body();
                recyclerAdapter = new RecyclerAdapter(posts, getApplicationContext());
                recyclerView.setAdapter(recyclerAdapter);

                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
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
        Post post = new Post("sulav","sulav@gmail.com","http://www.ssaurel.com/tmp/logo_ssaurel.png");
        posts.add(post);
        post = new Post("ram","ram@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("hari","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("sam","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("tom","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);
        post = new Post("sulav","sulav@gmail.com","http://lorempixel.com/300/300/");
        posts.add(post);

    }
}
