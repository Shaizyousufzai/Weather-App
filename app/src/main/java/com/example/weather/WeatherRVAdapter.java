package com.example.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherRVAdapter  extends RecyclerView.Adapter<WeatherRVAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WeatherRVModal> weatherRVModalsArrayList;

    public WeatherRVAdapter(Context context, ArrayList<WeatherRVModal> weatherRVModalsArrayList) {
        this.context = context;
        this.weatherRVModalsArrayList = weatherRVModalsArrayList;
    }

    @NonNull
    @Override
    public WeatherRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherRVAdapter.ViewHolder holder, int position) {
        WeatherRVModal modal = weatherRVModalsArrayList.get(position);
        holder.tempretureTv.setText(modal.getTempreture() + "°c");
        Picasso.get().load("http:".concat(modal.getIcon())).into(holder.conditionIv);
        holder.windTv.setText(modal.getWindspeed()+"Km/H");
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");
        try {
            Date t = input.parse(modal.getTime());
            holder.timeTv.setText(output.format(t));
        }catch (ParseException e){
            e.printStackTrace();
        }




    }

    @Override
    public int getItemCount() {
        return weatherRVModalsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView windTv,tempretureTv,timeTv;
        private ImageView conditionIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            windTv = itemView.findViewById(R.id.idTVWindSpeed);
            tempretureTv = itemView.findViewById(R.id.idTVTempreture);
            timeTv = itemView.findViewById(R.id.idTvTime);
            conditionIv = itemView.findViewById(R.id.idTVCondition);
        }
    }
}
