package edu.hanu.app.instagram.model;

import android.content.pm.PackageManager;

public class Story {
  private int instaAvatar;
  private String instaUserName;
  private boolean isUser;

    public Story(int instaAvatar, String instaUserName, boolean isUser) {
        this.instaAvatar = instaAvatar;
        this.instaUserName = instaUserName;
        this.isUser = isUser;
    }

    public int getInstaAvatar() {
        return instaAvatar;
    }

    public void setInstaAvatar(int instaAvatar) throws PackageManager.NameNotFoundException {
        if(instaUserName.isEmpty()) {
            throw new PackageManager.NameNotFoundException("User name is required!");
        }
        this.instaAvatar = instaAvatar;
    }

    public String getInstaUserName() {
        return instaUserName;
    }

    public void setInstaUserName(String instaUserName) {
        this.instaUserName = instaUserName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}
