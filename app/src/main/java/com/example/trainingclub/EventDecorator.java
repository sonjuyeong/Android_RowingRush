package com.example.trainingclub;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class EventDecorator implements DayViewDecorator {


    private final Drawable drawable;
    private int color;
    private HashSet<LocalDate> dates;
    private TextView textView;
    public EventDecorator(Collection<LocalDate> dates, Activity context, TextView textView) {
        drawable = context.getResources().getDrawable(R.drawable.calendar_background);

        this.dates = new HashSet<>(dates);
        this.textView = textView;
    }

    @Override
    public boolean shouldDecorate(LocalDate day){
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
    }

    public void setText(String text){
        textView.setText(text);
    }

}