package com.example.trainingclub;

import org.json.JSONException;

public interface InterfaceFAN {
    void successFAN(String json) throws JSONException;
    void errorFAN(String error);

}
