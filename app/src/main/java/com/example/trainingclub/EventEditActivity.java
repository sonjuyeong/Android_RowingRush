package com.example.trainingclub;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalTime;
import java.util.Calendar;

public class EventEditActivity extends AppCompatActivity
{
    private DatePickerDialog datePickerDialog_S;
    private DatePickerDialog datePickerDialog_E;
    private EditText eventNameET;
    private TextView DateTV_S, DateTV_E, TimeTV_S, TimeTV_E;
    private LocalTime time;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initDatePicker_S();
        initDatePicker_E();
        initWidgets();
        DateTV_S= findViewById(R.id.DateTV_S);
        DateTV_E = findViewById(R.id.DateTV_E);
        TimeTV_S= findViewById(R.id.TimeTV_S);
        TimeTV_E= findViewById(R.id.TimeTV_E);
        DateTV_S.setText(CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        DateTV_E.setText(CalendarUtils.formattedDate(CalendarUtils.selectedDate));
    }

    private void initDatePicker_S()
    {
        DatePickerDialog.OnDateSetListener dateSetListener_S = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(year, month ,day);
                DateTV_E.setText(date);

            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog_S = new DatePickerDialog(this, style, dateSetListener_S, year, month, day);

    }

    private void initDatePicker_E()
    {
        DatePickerDialog.OnDateSetListener dateSetListener_E = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(year, month ,day);
                DateTV_S.setText(date);

            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog_E = new DatePickerDialog(this, style, dateSetListener_E, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }


    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);

    }


    private String makeDateString(int year, int month, int day)
    {
        return year+"년 " + month + "월 "+ day +"일 ";
    }


    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);
        finish();
    }


    public void dateButton_S(View view) {

        datePickerDialog_S.show();
    }

    public void dateButton_E(View view){

        datePickerDialog_E.show();
    }

    public void timeButton_E(View view) {
    }

    public void timeButton_S(View view) {
    }

    public void Alert_time(View view) {
    }

    public void event_time(View view) {
    }

    public void event_day(View view) {
    }
}
