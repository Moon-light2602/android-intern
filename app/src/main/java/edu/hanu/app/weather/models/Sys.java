package edu.hanu.app.weather.models;

public class Sys {
    private int sunrise;
    private int sunset;

    public Sys(int sunrise, int sunset) {
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
