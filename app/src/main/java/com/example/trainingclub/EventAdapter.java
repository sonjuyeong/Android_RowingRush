package com.example.trainingclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EventAdapter extends ArrayAdapter<Event>
{

    public EventAdapter(@NonNull Context context, List<Event> events)
    {
        super(context, 0, events);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Event event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView eventCellTV1 = convertView.findViewById(R.id.eventCellTV);
        String eventTitle = event.getName();
        eventCellTV1.setText(eventTitle);
        TextView eventCellTV2 = convertView.findViewById(R.id.eventCellTV_time);
        String eventTime;
        if(event.getTime_S().equals("하루종일"))
        {
            eventTime = event.getTime_S();
        }
        else
        {
            eventTime = event.getTime_S() + " - " + event.getTime_E();
        }
        eventCellTV2.setText(eventTime);
        return convertView;
    }




}