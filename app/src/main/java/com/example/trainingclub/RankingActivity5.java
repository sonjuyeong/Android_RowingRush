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

public class RankingActivity5 extends AppCompatActivity implements InterfaceFAN, InterfaceFilejson.list5{

    private RecyclerView rvList5;
    TextView My_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking5);
        rvList5=(RecyclerView) findViewById(R.id.rvList5);
        My_id=(TextView) findViewById(R.id.my_id);
        String myid = ((LoginActivity)LoginActivity.context_main).MYID;
        My_id.setText(myid);
        String url = "https://script.google.com/macros/s/AKfycbylvetNHghg319R-1_Nid9Ei_JV4ef-89ZJnyeHTo6JyOi4ofSmdSFH6MbbMq8l5nz2/exec?action=read";
        Request request=new Request();
        request.getItems(url, "list", this);

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
        filejson.listRegisteration5(json, this);
    }

    @Override
    public void errorFAN(String error) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void listRegisteration5(ArrayList<RegisterModel> registerModels) {
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,registerModels);
        rvList5.setAdapter(listViewAdapter);
        rvList5.setLayoutManager(new LinearLayoutManager(this));
    }

    public void dis1(View view) {
        startActivity(new Intent(this, RankingActivity.class));

    }
    public void dis3(View view){
        startActivity(new Intent(this, RankingActivity3.class));
    }

    public void dis5(View view) {
    }
}