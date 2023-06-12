package edu.hanu.app.tiktok.model;

public class VideoItem {
    public String videoUrl, userName, videoDesc, videoHastag, musicName;

    public VideoItem(String videoUrl, String userName, String videoDesc, String videoHastag, String musicName) {
        this.videoUrl = videoUrl;
        this.userName = userName;
        this.videoDesc = videoDesc;
        this.videoHastag = videoHastag;
        this.musicName = musicName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoHastag() {
        return videoHastag;
    }

    public void setVideoHastag(String videoHastag) {
        this.videoHastag = videoHastag;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}
