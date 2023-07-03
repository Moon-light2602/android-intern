package edu.hanu.app.weather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.weather.models.TempHours;

public class TempHoursAdapter extends RecyclerView.Adapter<TempHoursAdapter.TempHoursHolder> {

    private List<TempHours> list;

    public void setData(List<TempHours> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public TempHoursAdapter.TempHoursHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TempHoursHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_temp_hour, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TempHoursHolder holder, int position) {

        TempHours item = list.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TempHoursHolder extends RecyclerView.ViewHolder {
        TextView tvCurrentHours, tvCurrentTemp;
        ImageView iconWeather;

        public TempHoursHolder(@NonNull View itemView) {
            super(itemView);

            tvCurrentHours = itemView.findViewById(R.id.tvCurrentHours);
            tvCurrentTemp = itemView.findViewById(R.id.tvCurrentTemp);
            iconWeather = itemView.findViewById(R.id.iconWeather);
        }

        public void setData(TempHours item) {
            tvCurrentHours.setText(item.getHours());
            tvCurrentTemp.setText(item.getTemperature() + "⁰");
            iconWeather.setImageResource(item.getIconWeather());

        }
    }
}
