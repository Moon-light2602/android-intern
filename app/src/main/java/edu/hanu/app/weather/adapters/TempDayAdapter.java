package edu.hanu.app.weather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.weather.models.TempDay;

public class TempDayAdapter extends RecyclerView.Adapter<TempDayAdapter.TempDayHolder> {

    private List<TempDay> list;

    public void setData(List<TempDay> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public TempDayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_temp_day, parent, false);
        return new TempDayHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TempDayHolder holder, int position) {
        TempDay item = list.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TempDayHolder extends RecyclerView.ViewHolder {

        TextView tvDay, tvHumidity, tvTempMaxMin;

        public TempDayHolder(@NonNull View itemView) {
            super(itemView);

            tvDay = itemView.findViewById(R.id.tvDay);
            tvHumidity = itemView.findViewById(R.id.tvHumidity);
            tvTempMaxMin = itemView.findViewById(R.id.tvTempMaxMin);
        }

        private void setData(TempDay item) {
            tvDay.setText(item.getDay());
            tvHumidity.setText("" + item.getHumidity() + "%");
            tvTempMaxMin.setText(item.getTempMax() + "⁰/ " + item.getTempMin() + "⁰");
        }
    }
}
