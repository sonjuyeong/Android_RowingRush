package com.example.trainingclub;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class EventEditActivity extends AppCompatActivity {


    SwitchCompat switchButton;
    private DatePickerDialog datePickerDialog_S, datePickerDialog_E;
    private EditText eventNameET;
    private TextView DateTV_S, DateTV_E, TimeTV_S, TimeTV_E;
    private LocalTime time;
    private LocalTime time_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initDatePicker_S();
        initDatePicker_E();
        eventNameET = findViewById(R.id.eventNameET);
        switchButton = findViewById(R.id.switchButton);
        DateTV_S = findViewById(R.id.DateTV_S);
        DateTV_E = findViewById(R.id.DateTV_E);
        DateTV_S.setText(CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        DateTV_E.setText(CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        TimeTV_S = findViewById(R.id.TimeTV_S);
        TimeTV_E = findViewById(R.id.TimeTV_E);
        time = LocalTime.now();
        time_2=time.plusHours(1);
        TimeTV_S.setText(CalendarUtils.formattedTime(time));
        TimeTV_E.setText(CalendarUtils.formattedTime(time_2));

        switchButton.setOnCheckedChangeListener((compoundButton, b) -> {
            if(compoundButton.isChecked()){
                TimeTV_S.setText("하루종일");
                TimeTV_E.setText("하루종일");
                TimeTV_E.setVisibility(View.INVISIBLE);
                TimeTV_S.setVisibility(View.INVISIBLE);
                DateTV_S.setX(550);
                DateTV_E.setX(550);

            }
            else{
                TimeTV_S.setText(CalendarUtils.formattedTime(time));
                TimeTV_E.setText(CalendarUtils.formattedTime(time_2));
                TimeTV_S.setVisibility(View.VISIBLE);
                TimeTV_E.setVisibility(View.VISIBLE);
                DateTV_S.setX(250);
                DateTV_E.setX(250);

            }
        });



        TimeTV_S.setOnClickListener(v -> {
            // Initialize a new time picker dialog fragment
            DialogFragment dFragment = new TimePickerFragment_S();

            // Show the time picker dialog fragment
            dFragment.show(getFragmentManager(),"시작시간 선택");
        });

        TimeTV_E.setOnClickListener(v -> {
            // Initialize a new time picker dialog fragment
            DialogFragment dFragment = new TimePickerFragment_E();

            // Show the time picker dialog fragment
            dFragment.show(getFragmentManager(),"마감시간 선택");
        });
    }




    private void initDatePicker_S() {
        DatePickerDialog.OnDateSetListener dateSetListener_S = (datePicker, year, month, day) -> {
            month = month + 1;
            String date = makeDateString(year, month, day);
            DateTV_S.setText(date);

        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog_S = new DatePickerDialog(this, dateSetListener_S, year, month, day);

    }



    private void initDatePicker_E() {
        DatePickerDialog.OnDateSetListener dateSetListener_E = (datePicker, year, month, day) -> {
            month = month + 1;
            String date = makeDateString(year, month, day);
            DateTV_E.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);


        datePickerDialog_E = new DatePickerDialog(this, dateSetListener_E, year, month, day);

    }






    private String makeDateString(int year, int month, int day) {
        return year + "년 " + month + "월 " + day + "일";
    }


    public void saveEventAction(View view) {

        try {
            String eventDate_S = DateTV_S.getText().toString();
            String eventDate_E = DateTV_E.getText().toString();
            String eventName = eventNameET.getText().toString();
            String eventTime_S = TimeTV_S.getText().toString();
            String eventTime_E = TimeTV_E.getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("yyyy년 mm월 dd일");
            Date FirstDate = format.parse(eventDate_S);
            Date EndDate = format.parse(eventDate_E);
            long calsec = (EndDate.getTime()-FirstDate.getTime())/1000;
            long calDateDays=calsec/(24*60*60);

            for(int i=0;i<=calDateDays;i++)
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(FirstDate);
                cal.add(Calendar.DATE, i);
                String MeventDate_E=format.format(cal.getTime());
                Event newEvent= new Event(eventName, eventTime_S,eventTime_E,eventDate_S, MeventDate_E);
                Event.eventsList.add(newEvent);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        finish();
    }


    public void dateButton_S(View view) {

        datePickerDialog_S.show();
    }

    public void dateButton_E(View view) {

        datePickerDialog_E.show();
    }


    public void Alert_time(View view) {
    }

    public void btn_back(View view) {
        startActivity(new Intent(this, WeekViewActivity.class));

    }

}