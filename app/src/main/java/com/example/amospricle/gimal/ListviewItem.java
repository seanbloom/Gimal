package com.example.amospricle.gimal;

/**
 * Created by amospricle on 2015. 12. 4..
 */
public class ListviewItem{
    private int icon;
    private String name;
    private String subject;
    private String prof;
    private String assignment;
    private String number;
    private int helper;
    private int profile;

    public String getnumber(){return number;}
    public int getIcon(){return icon;}
    public String getName(){return name;}
    public String getSubject(){return subject;}
    public String getAssignment(){return assignment;}
    public String getProf(){return prof;}
    public int getProfile(){return profile;}
    public int getHelper() {return helper;}

    public void setHelper(int i){this.helper= i;}

    public ListviewItem(int icon,String name, String subject, String prof, String assignment,String number, int helper,int profile){
        this.icon=icon;
        this.name=name;
        this.number = number;
        this.subject=subject;

        this.prof=prof;
        this.assignment=assignment;
        this.helper = helper;
        this.profile=profile;
    }
}