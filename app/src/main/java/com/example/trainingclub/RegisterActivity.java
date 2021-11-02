package com.example.trainingclub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, InterfaceFAN, InterfaceFilejson.save {

    private EditText idText, passwordText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        idText = findViewById(R.id.idText);
        passwordText =findViewById(R.id.passwordText);

        Button registerButton =(Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String userid  = idText.getText().toString();
        String userpass = passwordText.getText().toString();
        if(TextUtils.isEmpty(userid))
        {
            idText.setError("isi data");
            return;
        }
        if(TextUtils.isEmpty(userpass))
        {
            passwordText.setError("isi data");
            return;
        }

        Map<String, String> maps = new HashMap<>();
        maps.put("userid", userid);
        maps.put("userpass", userpass);
        maps.put("login", "1");

        String url = "https://script.google.com/macros/s/AKfycbwoQEYegaKSD8dFsl1Oes9lUMpWoMSe9vxvAeTLT-FNQv1di5xQA-RyyzBeOZfHnuYT/exec";
        Request request=new Request();
        request.postItems(url, "simpan",maps, this);

    }

    @Override
    public void successFAN(String json) throws JSONException {
        Filejson filejson = new Filejson();
        filejson.simpan(json, this);
    }

    @Override
    public void errorFAN(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successSimpan(String message) {
        if(message.equals("가입 성공"))
        {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            finish();
            Intent registerIntent = new Intent(this, LoginActivity.class);
            RegisterActivity.this.startActivity(registerIntent);
        }
        else{
            Toast.makeText(this, "중복된 아이디입니다.", Toast.LENGTH_SHORT).show();

        }

    }
}