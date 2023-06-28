package edu.hanu.app.weather;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.weather.Models.MausamData;
import edu.hanu.app.weather.Models.main;
import edu.hanu.app.weather.Models.weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {

    private TextView date, cityName, mainTempValue, description,
            maxTempValue, minTempValue, pressureValue, humidityValue;
    private EditText searchCityEdittext;

    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weather);

        constraintLayout = findViewById(R.id.constraint_layout);

        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String currentDate = format.format(new Date());

        fetchWeather("Delhi");

        date = findViewById(R.id.date);
        cityName = findViewById(R.id.cityName);
        mainTempValue = findViewById(R.id.main_temp_value);
        description = findViewById(R.id.description);
        maxTempValue = findViewById(R.id.max_temp);
        minTempValue = findViewById(R.id.min_temp);
        pressureValue = findViewById(R.id.pressure);
        humidityValue = findViewById(R.id.humidity);
        searchCityEdittext = findViewById(R.id.search_city_edittext);
        date.setText(currentDate);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hideKeyBoard();
                if(TextUtils.isEmpty(searchCityEdittext.getText().toString())){
                    searchCityEdittext.setError("Please enter city");
                    return;
                }

                String CITY_NAME = searchCityEdittext.getText().toString();


                fetchWeather(CITY_NAME);
            }
        });


    }
    void hideKeyBoard(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(constraintLayout.getApplicationWindowToken(), 0);
    }

    void fetchWeather(String cityname) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);

        Call<MausamData> call = interfaceApi.getData(cityname, "80409e07282e463da7a67d85222710b6", "metric");

        call.enqueue(new Callback<MausamData>() {
            @Override
            public void onResponse(Call<MausamData> call, Response<MausamData> response) {

                if(response.isSuccessful()){

                    MausamData mausamData = response.body();

                    main to = mausamData.getMain();

                    mainTempValue.setText(String.valueOf(to.getTemp()) + "\u2103");
                    maxTempValue.setText(String.valueOf(to.getTemp_max()));
                    minTempValue.setText(String.valueOf(to.getTemp_min()));
                    pressureValue.setText(String.valueOf(to.getPressure()));
                    humidityValue.setText(String.valueOf(to.getHumidity()));
                    cityName.setText(mausamData.getName());

                    List<weather> weather = mausamData.getWeather();

                    for (weather data : weather) {

                        description.setText(data.getDescription());
                    }
                }
            }

            @Override
            public void onFailure(Call<MausamData> call, Throwable t) {
            }
        });
    }
}
