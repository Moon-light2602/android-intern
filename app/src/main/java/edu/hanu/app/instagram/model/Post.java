package edu.hanu.app.instagram.model;

import android.content.pm.PackageManager;

public class Post {

    private int avatar, instaImage;
    private String userName, userDesc, contentPost, commentOfUser, comment;

    public Post(int avatar, int instaImage, String userName, String userDesc, String contentPost, String commentOfUser, String comment) {
        this.avatar = avatar;
        this.instaImage = instaImage;
        this.userName = userName;
        this.userDesc = userDesc;
        this.contentPost = contentPost;
        this.commentOfUser = commentOfUser;
        this.comment = comment;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getInstaImage() {
        return instaImage;
    }

    public void setInstaImage(int instaImage) {
        this.instaImage = instaImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws PackageManager.NameNotFoundException{
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

    public String getContentPost() {
        return contentPost;
    }

    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }

    public String getCommentOfUser() {
        return commentOfUser;
    }

    public void setCommentOfUser(String commentOfUser) {
        this.commentOfUser = commentOfUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}