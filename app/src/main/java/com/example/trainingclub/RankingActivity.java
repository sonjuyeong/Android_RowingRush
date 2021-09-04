package com.example.trainingclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RankingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
    }

    public void btn_ranking(View view) {
    }

    public void btn_setting(View view) {
        startActivity(new Intent(this, SettingActivity.class));
    }

    public void btn_calendar(View view)
    {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void Account(View view) {
    }

    public void Activity_log(View view) {
    }

    public void logout(View view) {
    }
}