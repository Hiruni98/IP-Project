package com.example.adminpanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private Context context;
    private List<Dataevents> dataevents;
    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_event,parent,false);
        return new EventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        final Dataevents dataevents = new Dataevents();
        holder.Venue.setText(dataevents.Venue);
        holder.Name.setText(dataevents.Name);
        holder.Description.setText(dataevents.Description);
        holder.Date.setText(dataevents.Date);
        holder.Time.setText(dataevents.Time);
    }

    @Override
    public int getItemCount() {
        return dataevents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Venue,Name,Description,Date,Time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Venue = itemView.findViewById(R.id.venueTxt);
            Name = itemView.findViewById(R.id.nameTxt);
            Description = itemView.findViewById(R.id.DescTxt);
            Date = itemView.findViewById(R.id.dateTxt);
            Time = itemView.findViewById(R.id.timeTxt);


        }
    }
}
