package edu.hanu.app.messenger.models;

public class HomeChat {
   private int imageUrl;
   private String userName;

    public HomeChat(int imageUrl, String userName) {
        this.imageUrl = imageUrl;
        this.userName = userName;
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
}

