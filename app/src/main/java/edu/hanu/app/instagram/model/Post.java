package edu.hanu.app.instagram.model;

import android.content.pm.PackageManager;

public class Post {

    private int avatar;
    private String userName;
    private String userDesc;
    private int image;

    public Post(int avatar, String userName, String userDesc, int image) {
        this.avatar = avatar;
        this.userName = userName;
        this.userDesc = userDesc;
        this.image = image;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws PackageManager.NameNotFoundException {
        if(userName.isEmpty()) {
            throw new PackageManager.NameNotFoundException("User name is required!");
        }
        this.userName = userName;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
