package edu.hanu.app.messenger.models;

public class BubbleChat {
    private int type, avatarSender;
    private String contentOfSender, contentOfReceiver;

    public BubbleChat(int type, int avatarSender, String contentOfSender) {
        this.type = type;
        this.avatarSender = avatarSender;
        this.contentOfSender = contentOfSender;
    }

    public BubbleChat(int type, String contentOfReceiver) {
        this.type = type;
        this.contentOfReceiver = contentOfReceiver;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAvatarSender() {
        return avatarSender;
    }

    public void setAvatarSender(int avatarSender) {
        this.avatarSender = avatarSender;
    }

    public String getContentOfSender() {
        return contentOfSender;
    }

    public void setContentOfSender(String contentOfSender) {
        this.contentOfSender = contentOfSender;
    }

    public String getContentOfReceiver() {
        return contentOfReceiver;
    }

    public void setContentOfReceiver(String contentOfReceiver) {
        this.contentOfReceiver = contentOfReceiver;
    }
}
