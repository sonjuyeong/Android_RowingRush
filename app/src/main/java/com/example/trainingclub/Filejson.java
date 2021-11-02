package com.example.trainingclub;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Filejson {

    public void game(String json, InterfaceFilejson.game view) throws JSONException{
        JSONObject object = new JSONObject(json);
        JSONArray jsonArray=object.getJSONArray("records");
        for(int i=0; i<jsonArray.length(); i++)
        {
            String name=jsonArray.getJSONObject(i).getString("userid") ;
            String date=jsonArray.getJSONObject(i).getString("date");
            Event newEvent= new Event(name, "하루종일","하루종일",date, date);
            Event.eventsList.add(newEvent);

        }
        view.game();
    }

    public void simpan(String json, InterfaceFilejson.save view ) throws JSONException {
        JSONObject object=new JSONObject(json);
        view.successSimpan(object.getString("status"));

    }

    public void listRegisteration(String json, InterfaceFilejson.list view) throws JSONException{

        JSONObject object = new JSONObject(json);
        JSONArray jsonArray=object.getJSONArray("records");
        ArrayList<RegisterModel> registerModels = new ArrayList<>();
        for(int i=0; i<jsonArray.length(); i++)
        {
            if(jsonArray.getJSONObject(i).getString("userdistance").equals("1"))
            {
                RegisterModel model = new RegisterModel();
                model.setUser(i+1);
                model.setUserdate(jsonArray.getJSONObject(i).getString("date"));
                model.setUserid(jsonArray.getJSONObject(i).getString("userid"));
                model.setUserdistance(jsonArray.getJSONObject(i).getString("userdistance"));
                int value = Integer.parseInt(jsonArray.getJSONObject(i).getString("usertime"));
                model.setUsertime(value);
                registerModels.add(model);
            }
        }

        view.listRegisteration(registerModels);
    }
    public void listRegisteration3(String json, InterfaceFilejson.list3 view) throws JSONException{

        JSONObject object = new JSONObject(json);
        JSONArray jsonArray=object.getJSONArray("records");
        ArrayList<RegisterModel> registerModels = new ArrayList<>();

        for(int i=0; i<jsonArray.length(); i++)
        {
            if(jsonArray.getJSONObject(i).getString("userdistance").equals("3"))
            {
                RegisterModel model = new RegisterModel();
                model.setUserid(jsonArray.getJSONObject(i).getString("userid"));
                int value = Integer.parseInt(jsonArray.getJSONObject(i).getString("usertime"));
                model.setUserdate(jsonArray.getJSONObject(i).getString("date"));
                model.setUsertime(value);
                model.setUserdistance(jsonArray.getJSONObject(i).getString("userdistance"));
                registerModels.add(model);

            }
        }

        view.listRegisteration3(registerModels);
    }
    public void listRegisteration5(String json, InterfaceFilejson.list5 view) throws JSONException{

        JSONObject object = new JSONObject(json);
        JSONArray jsonArray=object.getJSONArray("records");
        ArrayList<RegisterModel> registerModels = new ArrayList<>();
        for(int i=0; i<jsonArray.length(); i++)
        {
            if(jsonArray.getJSONObject(i).getString("userdistance").equals("5"))
            {
                RegisterModel model = new RegisterModel();
                model.setUserid(jsonArray.getJSONObject(i).getString("userid"));
                int value = Integer.parseInt(jsonArray.getJSONObject(i).getString("usertime"));
                model.setUserdistance(jsonArray.getJSONObject(i).getString("userdistance"));
                model.setUserdate(jsonArray.getJSONObject(i).getString("date"));
                model.setUsertime(value);
                registerModels.add(model);
            }
        }

        view.listRegisteration5(registerModels);
    }


}
