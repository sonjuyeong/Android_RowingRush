package com.example.trainingclub;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(getActivity(), this, hour, minute, false);

        return tpd;


    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Set a variable to hold the current time AM PM Status
        // Initially we set the variable value to AM
        String status = "오전";

        if (hourOfDay >= 12) {
            // If the hour is greater than or equal to 12
            // Then the current AM PM status is PM
            status = "오후";
        }

        int hour_of_12_hour_format;

        if (hourOfDay == 24 || hourOfDay == 0) {
            hour_of_12_hour_format = 12;
        } else if (hourOfDay > 12) {

            // If the hour is greater than or equal to 12
            // Then we subtract 12 from the hour to make it 12 hour format time
            hour_of_12_hour_format = hourOfDay - 12;
        } else {
            hour_of_12_hour_format = hourOfDay;
        }

        // Get the calling activity TextView reference
        TextView alert_time = (TextView) getActivity().findViewById(R.id.alert_time);
        // Display the 12 hour format time in app interface
        String time = String.format("%s %d:%02d", status, hour_of_12_hour_format, minute);
        alert_time.setText(time);

    }
}
