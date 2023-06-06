package edu.hanu.app.tiktok.model;

public class VideoItem {

    private String videoUrl, VideoTitle, videoDescription;
    private String user_id;

    public VideoItem(String videoUrl, String videoTitle, String videoDescription, String user_id) {
        this.videoUrl = videoUrl;
        VideoTitle = videoTitle;
        this.videoDescription = videoDescription;
        this.user_id = user_id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTitle() {
        return VideoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        VideoTitle = videoTitle;
    }

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
}
