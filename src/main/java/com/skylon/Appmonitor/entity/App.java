package com.skylon.Appmonitor.entity;

import java.util.List;

public class App {
    private String id;
    private String Name;
    private List<Parameter> parameterList;

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

    public List<Parameter> getParameterList() {
        return this.parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }
}




