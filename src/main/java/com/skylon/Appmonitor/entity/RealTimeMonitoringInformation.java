package com.skylon.Appmonitor.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class RealTimeMonitoringInformation {
    private String ProjectCode;
    private String ProgramCode;
    private String ParameterCode;
    private Date CollectionTime;
    private int Status;
    private Date ReceiveTime;

    public RealTimeMonitoringInformation() {
        ProjectCode = "0000";
        ProgramCode = "0000";
        ParameterCode = "0000";
        CollectionTime = new Date();
        Status = 1;
        ReceiveTime = new Date();
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
