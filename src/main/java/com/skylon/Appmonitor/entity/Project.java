package com.skylon.Appmonitor.entity;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String id;
    private String Name;
    private ArrayList<App> appList;

    public ArrayList<App> getAppList() {
        return appList;
    }

    public void setAppList(ArrayList<App> appList) {
        this.appList = appList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
