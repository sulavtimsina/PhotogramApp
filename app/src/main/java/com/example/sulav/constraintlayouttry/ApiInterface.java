package com.example.sulav.constraintlayouttry;

import com.example.sulav.constraintlayouttry.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("echoJson.php")
    Call<List<Post>> getPosts();
}
