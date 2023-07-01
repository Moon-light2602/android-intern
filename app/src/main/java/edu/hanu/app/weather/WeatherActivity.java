package edu.hanu.app.weather;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.hanu.app.R;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


//        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                hideKeyBoard();
//                if(TextUtils.isEmpty(searchCityEdittext.getText().toString())){
//                    searchCityEdittext.setError("Please enter city");
//                    return;
//                }
//
//                String CITY_NAME = searchCityEdittext.getText().toString();
//
//
//                fetchWeather(CITY_NAME);
//            }
//        });
//
//
//    }
//    void hideKeyBoard(){
//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(constraintLayout.getApplicationWindowToken(), 0);
//    }
//
//    void fetchWeather(String cityname) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.openweathermap.org/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
//
//        Call<WeatherData> call = interfaceApi.getData(cityname, "80409e07282e463da7a67d85222710b6", "metric");
//
//        call.enqueue(new Callback<WeatherData>() {
//            @Override
//            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//
//                if(response.isSuccessful()){
//
//                    WeatherData weatherData = response.body();
//
//                    main to = weatherData.getMain();
//
//                    mainTempValue.setText(String.valueOf(to.getTemp()) + "\u2103");
//                    maxTempValue.setText(String.valueOf(to.getTemp_max()));
//                    minTempValue.setText(String.valueOf(to.getTemp_min()));
//                    pressureValue.setText(String.valueOf(to.getPressure()));
//                    humidityValue.setText(String.valueOf(to.getHumidity()));
//                    cityName.setText(weatherData.getName());
//
//                    List<weather> weather = weatherData.getWeather();
//
//                    for (weather data : weather) {
//
//                        description.setText(data.getDescription());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<WeatherData> call, Throwable t) {
//            }
//        });
    }
}
