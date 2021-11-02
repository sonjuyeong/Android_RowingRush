package com.example.trainingclub;

public class RegisterModel {
    String userid, userpass,userdistance, userdate;
    int usertime ,user;

    public String getUserid(){
        return userid;
    }
    public void setUserid(String userid)
    {
        this.userid=userid;
    }

    public int getUsertime(){
        return usertime;
    }
    public void setUsertime(int usertime)
    {
        this.usertime=usertime;
    }

    public String getUserdistance(){
        return userdistance;
    }
    public void setUserdistance(String userdistance)
    {
        this.userdistance=userdistance;
    }

    public String getUserdate(){
        return userdate;
    }
    public void setUserdate(String userdate)
    {
        this.userdate=userdate;
    }

    public int getUser(){
        return user;
    }
    public void setUser(int user)
    {
        this.user=user;
    }

    public String getUserpass(){
        return userpass;
    }
    public void setUserpass(String userpass)
    {
        this.userpass=userpass;
    }


}
