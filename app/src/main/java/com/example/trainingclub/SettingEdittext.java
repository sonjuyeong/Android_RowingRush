package com.example.trainingclub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SettingEdittext extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setContentView(R.layout.set_profiletext);

        final EditText edittext = (EditText) findViewById(R.id.set_edittext);
        Button button = (Button) findViewById(R.id.set_edit);
        final TextView textview = (TextView) findViewById(R.id.set_profile);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textview.setText(edittext.getText());
                startActivity(new Intent(SettingEdittext.this, SettingActivity.class));
            }
        });
    }
}