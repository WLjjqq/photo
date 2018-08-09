package com.wx.bean;

public class Student {

    private String cId;

    private String uName;

    private String pwd;

    public  Student(){

    }
    public  Student(String cId, String uName, String pwd){

        this.cId = cId;
        this.uName = uName;
        this.pwd = pwd;

    }

    public String getcId()
    {
        return cId;
    }

    public void setcId(String cId)
    {
        this.cId = cId;
    }

    public String getuName()
    {
        return uName;
    }

    public void setuName(String uName)
    {
        this.uName = uName;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "cId='" + cId + '\'' +
                ", uName='" + uName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
