package com.skylon.Appmonitor.TimerTask;
public class MonitorConfiguration {
    private  int Testport;
    private  int Serverport;
    private  String Testhost;
    private  String Serverhost;
    private  String AreaId;
    private  String AppId;
    private  String ModelId;



    public int getTestport() {
        return Testport;
    }

    public void setTestport(int testport) {
        Testport = testport;
    }

    public int getServerport() {
        return Serverport;
    }

    public void setServerport(int serverport) {
        Serverport = serverport;
    }

    public String getTesthost() {
        return Testhost;
    }

    public void setTesthost(String testhost) {
        Testhost = testhost;
    }

    public String getServerhost() {
        return Serverhost;
    }

    public void setServerhost(String serverhost) {
        Serverhost = serverhost;
    }

    public String getAreaId() {
        return AreaId;
    }

    public void setAreaId(String areaId) {
        AreaId = areaId;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getModelId() {
        return ModelId;
    }

    public void setModelId(String modelId) {
        ModelId = modelId;
    }
}
