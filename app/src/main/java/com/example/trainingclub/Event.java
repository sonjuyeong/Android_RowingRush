package com.example.trainingclub;

import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public static ArrayList<Event> eventsForDate(String date) {
        ArrayList<Event> events = new ArrayList<>();

        for (Event event : eventsList) {
            if(event.getDate_E().equals(date))
            {
                events.add(event);

            }

        }

        return events;
    }



    private String name;
    private String Time_S;
    private String Time_E;
    private String Date_S;
    private String Date_E;

    public Event(String name, String Time_S, String Time_E, String Date_S, String Date_E)
    {
        this.name = name;
        this.Time_S= Time_S;
        this.Time_E = Time_E;
        this.Date_S= Date_S;
        this.Date_E = Date_E;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDate_S()
    {
        return Date_S;
    }

    public void setDate_S(String Date_S)
    {
        this.Date_S = Date_S;
    }


    public String getDate_E()
    {
        return Date_E;
    }

    public void setDate_E(String Date_E)
    {
        this.Date_E = Date_E;
    }



    public String getTime_S()
    {
        return Time_S;
    }

    public void setTime_S(String Time_S)
    {
        this.Time_S = Time_S;
    }

    public String getTime_E()
    {
        return Time_E;
    }

    public void setTime_E(String Time_E)
    {
        this.Time_E = Time_E;
    }
}

