package com.example.trainingclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void btn_ranking(View view) {
        startActivity(new Intent(this, RankingActivity.class));
    }

    public void btn_setting(View view) {
    }

    public void btn_calendar(View view)
    {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void logout(View view) {
    }

    public void Activity_log(View view) {
    }

    public void Account(View view) {
    }

    public void Ibtn_change(View view) {
    }
}