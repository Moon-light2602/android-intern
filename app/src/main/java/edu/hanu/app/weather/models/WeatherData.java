package edu.hanu.app.weather.models;

import java.util.List;

public class WeatherData {

    private List<Weather> weather;
    private main main;
    private Sys sys;
    private Wind wind;
    private String name;
    private int timezone;

    public WeatherData(List<Weather> weather, edu.hanu.app.weather.models.main main, Sys sys, Wind wind, String name, int timezone) {
        this.weather = weather;
        this.main = main;
        this.sys = sys;
        this.wind = wind;
        this.name = name;
        this.timezone = timezone;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public edu.hanu.app.weather.models.main getMain() {
        return main;
    }

    public void setMain(edu.hanu.app.weather.models.main main) {
        this.main = main;
    }

    public Sys getSys() {
        return sys;
    }

    public void getSys(Sys sys) {
        this.sys = sys;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }
}
