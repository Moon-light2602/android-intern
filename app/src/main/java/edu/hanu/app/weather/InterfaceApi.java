package edu.hanu.app.weather;

import edu.hanu.app.weather.models.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceApi {

    @GET("weather")
    Call<WeatherData> getWeather(
            @Query("q") String cityName,
            @Query("appid") String APIKEY
    );
}
