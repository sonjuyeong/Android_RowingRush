package com.example.trainingclub;

import static com.example.trainingclub.CalendarUtils.daysInWeekArray;
import static com.example.trainingclub.CalendarUtils.monthYearFromDate;
import static com.example.trainingclub.CalendarUtils.selectedDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeekViewActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener, InterfaceFAN,InterfaceFilejson.game {
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        setWeekView();
        String url = "https://script.google.com/macros/s/AKfycbylvetNHghg319R-1_Nid9Ei_JV4ef-89ZJnyeHTo6JyOi4ofSmdSFH6MbbMq8l5nz2/exec?action=read";
        Request request=new Request();
        request.getItems(url,"list",this);




    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventListView = findViewById(R.id.eventListView);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        setEventAdpater();
    }


    public void previousWeekAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view)
    {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
        setWeekView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalendarUtils.selectedDate = date;
        setWeekView();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdpater();
    }

    private void setEventAdpater()
    {
        ArrayList<Event> today = Event.eventsForDate(CalendarUtils.formattedDate(selectedDate));
        EventAdapter todayAdapter = new EventAdapter(getApplicationContext(), today);
        eventListView.setAdapter(todayAdapter);

        eventListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent =new Intent(getApplicationContext(), EventViewActivity.class);
            intent.putExtra("Name",today.get(position).getName());
            intent.putExtra("Date_S",today.get(position).getDate_S());
            intent.putExtra("Date_E",today.get(position).getDate_E());
            intent.putExtra("Time_S",today.get(position).getTime_S());
            intent.putExtra("Time_E",today.get(position).getTime_E());
            startActivity(intent);
        });

    }

    public void newEventAction(View view) {
        startActivity(new Intent(this, EventEditActivity.class));
    }

    public void btn_ranking(View view) {
        startActivity(new Intent(this, RankingActivity.class));
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
        filejson.game(json,this);
    }

    @Override
    public void errorFAN(String error) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void game() {
        ArrayList<Event> todaygame = Event.eventsForDate(CalendarUtils.formattedDate(selectedDate));
        EventAdapter todaygameadapter = new EventAdapter(getApplicationContext(), todaygame);
        eventListView.setAdapter(todaygameadapter);

    }
}