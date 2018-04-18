package com.example.sulav.constraintlayouttry.retrofit;

import com.example.sulav.constraintlayouttry.Model.Post;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @POST("echoJsonDb.php")
    Call<List<Post>> getPosts();

    interface Service {
        @Multipart
        @POST("/")
        Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("name") RequestBody name);
    }
}
