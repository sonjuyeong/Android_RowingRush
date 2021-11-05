package com.example.trainingclub;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageview;
    TextView My_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        My_id=(TextView) findViewById(R.id.my_id);
        String myid = ((LoginActivity)LoginActivity.context_main).MYID;
        My_id.setText(myid);
    }

    public void set_profile(View view) {
        startActivity(new Intent(this, SettingEdittext.class));
    }

    public void logout(View view) { startActivity(new Intent(this, LoginActivity.class)); }

    public void Activity_log(View view) {
    }

    public void announcement(View view) {
    }

    public void Account(View view) {
    }

    public void Ibtn_change(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, GET_GALLERY_IMAGE);

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

}