package edu.hanu.app.weather.Models;

import java.util.List;

public class WeatherData {

    private List<weather> weather;
    private main main;
    private String name;

    public WeatherData(List<edu.hanu.app.weather.Models.weather> weather, edu.hanu.app.weather.Models.main main, String name) {
        this.weather = weather;
        this.main = main;
        this.name = name;
    }

    public List<edu.hanu.app.weather.Models.weather> getWeather() {
        return weather;
    }

    public void setWeather(List<edu.hanu.app.weather.Models.weather> weather) {
        this.weather = weather;
    }

    public edu.hanu.app.weather.Models.main getMain() {
        return main;
    }

    public void setMain(edu.hanu.app.weather.Models.main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
