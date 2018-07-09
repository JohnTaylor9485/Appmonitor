package com.skylon.Appmonitor.entity;


import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class CompleteInformation {
    private String AppName;
    private String ProjName;
    private String ParamName;
    private String ProjectCode;
    private String ProgramCode;
    private String ParameterCode;
    private Date CollectionTime;
    private int Status;
    private Date ReceiveTime;


    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public String getProjName() {
        return ProjName;
    }

    public void setProjName(String projName) {
        ProjName = projName;
    }

    public String getParamName() {
        return ParamName;
    }

    public void setParamName(String paramName) {
        ParamName = paramName;
    }
    public String getProjectCode() {
        return ProjectCode;
    }

    public void setProjectCode(String projectCode) {
        ProjectCode = projectCode;
    }

    public String getProgramCode() {
        return ProgramCode;
    }

    public void setProgramCode(String programCode) {
        ProgramCode = programCode;
    }

    public String getParameterCode() {
        return ParameterCode;
    }

    public void setParameterCode(String parameterCode) {
        ParameterCode = parameterCode;
    }

    public Date getCollectionTime() {
        return CollectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        CollectionTime = collectionTime;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Date getReceiveTime() {
        return ReceiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        ReceiveTime = receiveTime;
    }

}
