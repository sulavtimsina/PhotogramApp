package com.example.sulav.constraintlayouttry.Model;

public class Post {

//    private int id;
    private String userid;
    private int likes;
    private int dislikes;
    private String photo_location;

    public Post(String userid, int likes, int dislikes, String photo_location) {
        this.userid = userid;
        this.likes = likes;
        this.dislikes = dislikes;
        this.photo_location = photo_location;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getPhoto_location() {
        return photo_location;
    }

    public void setPhoto_location(String photo_location) {
        this.photo_location = photo_location;
    }
}
