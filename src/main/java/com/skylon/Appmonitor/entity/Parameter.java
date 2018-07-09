package com.skylon.Appmonitor.entity;

import java.util.List;

public class Parameter {
    private String pid;
    private String pName;
    private String pStatus;

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }
    //private List<RealTimeMonitoringInformation> realTimeMonitoringInformationList;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }


//    public List<RealTimeMonitoringInformation> getRealTimeMonitoringInformationList() {
//        return realTimeMonitoringInformationList;
//    }
//
//    public void addRealTimeMonitoringInformationList(RealTimeMonitoringInformation realTimeMonitoringInformation) {
//        this.realTimeMonitoringInformationList.add(realTimeMonitoringInformation);
//    }
}
