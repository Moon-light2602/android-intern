package edu.hanu.app.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import edu.hanu.app.R;
import edu.hanu.app.weather.adapters.TempDayAdapter;
import edu.hanu.app.weather.adapters.TempHoursAdapter;
import edu.hanu.app.weather.models.TempDay;
import edu.hanu.app.weather.models.TempHours;
import edu.hanu.app.weather.models.Weather;
import edu.hanu.app.weather.models.WeatherData;
import edu.hanu.app.weather.models.main;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {

    TextView tvCityName, tvCurrentTime, tvCurrentTemp, tvDescription, tvTempMaxMin, tvFeelsLike,
    tvHumidity, tvSunrise, tvSunset, tvWind;

    EditText edtSearchView;
    FloatingActionButton fab;

    String url ="api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}";
    String APIKEY = "d0dd5f297c71810e52a03f1542c23fed";

    RecyclerView rcvDisplayTempHour, rcvDisplayTempDay;
    TempDayAdapter tempDayAdapter;
    TempHoursAdapter tempHoursAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Hanoi");
        setSupportActionBar(toolbar);

        initView();


        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String currentDate = format.format(new Date());
        tvCurrentTime.setText(currentDate);

        LinearLayoutManager displayTemDay = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvDisplayTempDay.setLayoutManager(displayTemDay);
        tempDayAdapter = new TempDayAdapter();
        tempDayAdapter.setData(getListTempDay());
        rcvDisplayTempDay.setAdapter(tempDayAdapter);

        LinearLayoutManager displayTemHour = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcvDisplayTempHour.setLayoutManager(displayTemHour);
        tempHoursAdapter = new TempHoursAdapter();
        tempHoursAdapter.setData(getListTempHours());
        rcvDisplayTempHour.setAdapter(tempHoursAdapter);

        getWeather("Hanoi");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edtSearchView.getText().toString())) {
                    edtSearchView.setError("Please enter city name");
                    return;
                }

                String cityName = edtSearchView.getText().toString().trim();
                getWeather(cityName);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initView() {
        rcvDisplayTempHour = findViewById(R.id.rcvDisplayTempHour);
        rcvDisplayTempDay = findViewById(R.id.rcvDisplayTempByDay);
        tvCityName = findViewById(R.id.tvCityName);
        tvCurrentTime = findViewById(R.id.tvCurrentTime);
        tvDescription = findViewById(R.id.tvDescription);
        tvCurrentTemp = findViewById(R.id.tvCurrentTemp);
        tvTempMaxMin = findViewById(R.id.tvTempMaxMin);
        tvFeelsLike = findViewById(R.id.tvFeelsLike);
        tvHumidity = findViewById(R.id.tvHumidity);
        tvSunrise = findViewById(R.id.tvSunrise);
        tvSunset = findViewById(R.id.tvSunset);
        tvWind = findViewById(R.id.tvWind);
        edtSearchView = findViewById(R.id.edtSearchView);
        fab = findViewById(R.id.fab);
    }

    private void getWeather(String cityName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
        Call<WeatherData> weatherDataCall = interfaceApi.getWeather(cityName, APIKEY);
        weatherDataCall.enqueue(new Callback<WeatherData>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (!(response.isSuccessful())) {
                    Toast.makeText(WeatherActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                }

                WeatherData weatherData = response.body();
                main main = weatherData.getMain();
                double temp = main.getTemp();
                int currentTemp = (int) (temp - 273.15);
                int temp_max = (int) (main.getTemp_max() - 273.15);
                int temp_min = (int) (main.getTemp_min() - 273.15);
                int feels_like = (int) (main.getFeels_like() -273.15);
                tvCityName.setText(weatherData.getName());
                tvCurrentTemp.setText(currentTemp + "\u2103");
                tvHumidity.setText(main.getHumidity() + "%");
                tvTempMaxMin.setText(temp_max + "⁰/ " + temp_min + "⁰");
                tvFeelsLike.setText("Feels like " + feels_like + "⁰");

                @SuppressLint("SimpleDateFormat") String sunrise = new SimpleDateFormat("hh:mm a").format(weatherData.getSys().getSunrise() * 1000);
                tvSunrise.setText(sunrise);
                @SuppressLint("SimpleDateFormat") String sunset = new SimpleDateFormat("hh:mm a").format(weatherData.getSys().getSunset() * 1000);
                tvSunset.setText(sunset);
                tvWind.setText(weatherData.getWind().getSpeed()+" km/h");

                List<Weather> description = weatherData.getWeather();
                for(Weather data : description) {
                    tvDescription.setText(data.getDescription());
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Toast.makeText(WeatherActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<TempHours> getListTempHours() {
        List<TempHours> list = new ArrayList<>();

        list.add(new TempHours("14:00", R.drawable.sunny, "34"));
        list.add(new TempHours("15:00", R.drawable.sunny, "33"));
        list.add(new TempHours("16:00", R.drawable.sunny, "33"));
        list.add(new TempHours("17:00", R.drawable.sunny, "32"));
        list.add(new TempHours("18:00", R.drawable.clouds, "32"));
        return list;
    }

    private List<TempDay> getListTempDay() {
        List<TempDay> list = new ArrayList<>();

        list.add(new TempDay("Thứ năm", 12, 35, 28));
        list.add(new TempDay("Thứ sáu", 17, 37, 28));
        list.add(new TempDay("Thứ bảy", 40, 37, 28));
        list.add(new TempDay("Chủ nhật", 57, 37, 28));
        list.add(new TempDay("Thứ hai", 52, 36, 28));
        list.add(new TempDay("Thứ ba", 24, 36, 28));
        return list;
    }


}
