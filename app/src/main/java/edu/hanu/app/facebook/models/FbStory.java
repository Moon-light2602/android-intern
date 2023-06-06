package edu.hanu.app.facebook.models;

public class FbStory {

    private int userAvatar;
    private int userStoryImg;
    private String userName;
    private boolean isUser;

    public FbStory(int userAvatar, int userStoryImg, String userName, boolean isUser) {
        this.userAvatar = userAvatar;
        this.userStoryImg = userStoryImg;
        this.userName = userName;
        this.isUser = isUser;
    }

    public int getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(int userAvatar) {
        this.userAvatar = userAvatar;
    }

    public int getUserStoryImg() {
        return userStoryImg;
    }

    public void setUserStoryImg(int userStoryImg) {
        this.userStoryImg = userStoryImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}
