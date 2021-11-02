package com.example.trainingclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class EventViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);

        TextView dateTV_S = findViewById(R.id.DateTV_S);
        TextView dateTV_E = findViewById(R.id.DateTV_E);
        TextView timeTV_S = findViewById(R.id.TimeTV_S);
        TextView timeTV_E = findViewById(R.id.TimeTV_E);
        TextView eventName = findViewById(R.id.eventNameET);
        Intent intent = getIntent();
        String Name = intent.getStringExtra("Name");
        eventName.setText(Name);
        dateTV_S.setText(intent.getStringExtra("Date_S"));
        dateTV_E.setText(intent.getStringExtra("Date_E"));
        timeTV_S.setText(intent.getStringExtra("Time_S"));
        timeTV_E.setText(intent.getStringExtra("Time_E"));
        String Time = timeTV_S.getText().toString();
        if(Time.equals("하루종일")){

            timeTV_E.setVisibility(View.INVISIBLE);
            timeTV_S.setVisibility(View.INVISIBLE);
            dateTV_S.setX(300);
            dateTV_E.setX(300);

        }
        else
        {
            timeTV_S.setVisibility(View.VISIBLE);
            timeTV_E.setVisibility(View.VISIBLE);
            dateTV_S.setX(20);
            dateTV_E.setX(20);
        }

    }

    public void EventAction(View view) {



    }

    public void btn_back(View view) {

        startActivity(new Intent(this, WeekViewActivity.class));

    }
}