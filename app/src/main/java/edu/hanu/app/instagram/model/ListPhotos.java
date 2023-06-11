package edu.hanu.app.instagram.model;

import java.util.List;

public class ListPhotos {

    private int type;
    private List<Photos> photos;

    public ListPhotos(int type, List<Photos> photos) {
            this.type = type;
            this.photos = photos;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }
}
