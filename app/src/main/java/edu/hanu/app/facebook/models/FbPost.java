package edu.hanu.app.facebook.models;

import android.content.pm.PackageManager;

import java.util.List;

public class FbPost {
    private String userNameOfPost;
    private int userAvatar;
    private String postContent;
    private int userImage;
    private List<Images> images;
    private int type;
    private int photo;
    private String videoUrl;

    public FbPost(int type, String userNameOfPost, int userAvatar, int userImage, String postContent) {
        this.userNameOfPost = userNameOfPost;
        this.userAvatar = userAvatar;
        this.postContent = postContent;
        this.userImage = userImage;
        this.type = type;
    }

    public FbPost(int type, String userNameOfPost, int userAvatar, List<Images> images, String postContent) {
        this.userNameOfPost = userNameOfPost;
        this.userAvatar = userAvatar;
        this.postContent = postContent;
        this.images = images;
        this.type = type;
    }

    public FbPost(int type,String userNameOfPost, int userAvatar, String videoUrl, String postContent ) {
        this.userNameOfPost = userNameOfPost;
        this.userAvatar = userAvatar;
        this.postContent = postContent;
        this.type = type;
        this.videoUrl = videoUrl;
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

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}