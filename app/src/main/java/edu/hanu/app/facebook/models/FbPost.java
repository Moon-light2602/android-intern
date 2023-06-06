package edu.hanu.app.facebook.models;

import android.content.pm.PackageManager;

public class FbPost {
    private String userNameOfPost;
    private int userAvatar;
    private String postContent;
    private int userImage;

    public FbPost(String userNameOfPost, int userAvatar, int userImage, String postContent) {
        this.userNameOfPost = userNameOfPost;
        this.userAvatar = userAvatar;
        this.postContent = postContent;
        this.userImage= userImage;
    }

    public String getUserNameOfPost() {
        return userNameOfPost;
    }

    public void setUserNameOfPost(String userNameOfPost) throws PackageManager.NameNotFoundException {
        if(userNameOfPost.isEmpty()) {
            throw new PackageManager.NameNotFoundException("User name of post is required.");
        }
        this.userNameOfPost = userNameOfPost;
    }

    public int getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(int userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}