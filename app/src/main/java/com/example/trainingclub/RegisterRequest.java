package com.example.trainingclub;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    final static private String URL = "https://script.google.com/macros/s/AKfycbxc5R_Y7zTad80LiUs_O-6wE889DjIquIuirMARMTgOFqGOdsJ3/exec";
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}


