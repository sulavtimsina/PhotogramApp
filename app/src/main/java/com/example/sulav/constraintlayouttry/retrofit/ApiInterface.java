package com.example.sulav.constraintlayouttry.retrofit;

import com.example.sulav.constraintlayouttry.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("echoJsonDb.php")
    Call<List<Post>> getPosts();
}
