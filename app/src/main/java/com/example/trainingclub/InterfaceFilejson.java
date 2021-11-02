package com.example.trainingclub;

import java.util.ArrayList;

public interface InterfaceFilejson {
    interface save{
        void successSimpan(String message);
    }
    interface list{
        void listRegisteration( ArrayList<RegisterModel> registerModels);
    }
    interface list3{
        void listRegisteration3( ArrayList<RegisterModel> registerModels);
    }
    interface  list5{
        void listRegisteration5( ArrayList<RegisterModel> registerModels);
    }


    interface game {
        void game();
    }
}
