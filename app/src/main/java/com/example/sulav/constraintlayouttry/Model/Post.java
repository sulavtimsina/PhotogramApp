package com.example.sulav.constraintlayouttry.Model;

public class Post {

    private String name;
    private String email;
    private String photo_location;

    public Post(String name, String email, String photo_location) {
        this.name = name;
        this.email = email;
        this.photo_location = photo_location;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto_location() {
        return photo_location;
    }
}
