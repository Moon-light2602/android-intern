package edu.hanu.app.tiktok.model;

public class VideoItem {

    private String videoUrl, videoDescription;
    private String user_id;
//    private int VideoTitle;
    private int userTikTok;

    public VideoItem(String videoUrl, int userTikTok, String videoDescription, String user_id) {
        this.videoUrl = videoUrl;
        this.userTikTok = userTikTok;
//        VideoTitle = videoTitle;
        this.videoDescription = videoDescription;
        this.user_id = user_id;


    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

//    public int getVideoTitle() {
//        return VideoTitle;
//    }
//
//    public void setVideoTitle(int videoTitle) {
//        VideoTitle = videoTitle;
//    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getUserTikTok() {
        return userTikTok;
    }

    public void setUserTikTok(int userTikTok) {
        this.userTikTok = userTikTok;
    }
}
