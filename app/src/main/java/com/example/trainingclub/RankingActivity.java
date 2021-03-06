package com.example.trainingclub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity implements InterfaceFAN, InterfaceFilejson.list{

    private RecyclerView rvList1;
    TextView My_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        rvList1=(RecyclerView) findViewById(R.id.rvList1);

        String url = "https://script.google.com/macros/s/AKfycbylvetNHghg319R-1_Nid9Ei_JV4ef-89ZJnyeHTo6JyOi4ofSmdSFH6MbbMq8l5nz2/exec?action=read";
        Request request=new Request();
        request.getItems(url,"list",this);


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


    @Override
    public void successFAN(String json) throws JSONException {
        Filejson filejson = new Filejson();
        filejson.listRegisteration(json, this);

    }

    @Override
    public void errorFAN(String error) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show();


    }


    @Override
    public void listRegisteration(ArrayList<RegisterModel> registerModels) {
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,registerModels);
        rvList1.setAdapter(listViewAdapter);
        rvList1.setLayoutManager(new LinearLayoutManager(this));

    }

    public void dis1(View view) {

    }
    public void dis3(View view){
        startActivity(new Intent(this, RankingActivity3.class));
    }

    public void dis5(View view) {
        startActivity(new Intent(this, RankingActivity5.class));
    }
}