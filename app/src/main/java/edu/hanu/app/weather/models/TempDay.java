package edu.hanu.app.weather.models;

public class TempDay {
    private String day;
    private int humidity;
    private int tempMax;
    private int tempMin;

    public TempDay(String day, int humidity, int tempMax, int tempMin) {
        this.day = day;
        this.humidity = humidity;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }
}
