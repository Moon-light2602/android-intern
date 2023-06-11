package edu.hanu.app.instagram.model;

public class Photos {
    private int resourceId;

    public Photos(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
