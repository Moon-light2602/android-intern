package edu.hanu.app.messenger.models;

public class ChatMessages {
    private int imageUrl;
    private String userName, content;

    public ChatMessages(int imageUrl, String userName, String content) {
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.content = content;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

