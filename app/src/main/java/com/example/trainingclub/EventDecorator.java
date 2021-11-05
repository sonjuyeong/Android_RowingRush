package com.example.trainingclub;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EventDecorator extends ArrayList<Event> {

    public EventDecorator(@NonNull CalendarViewHolder holder, @Nullable View convertView) {
        if (convertView == null)
            holder.parentView.setBackgroundColor(R.drawable.calendar_background);
    }

    public static void show() {
    }
}