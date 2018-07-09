package com.skylon.Appmonitor.service;

import com.skylon.Appmonitor.entity.CompleteInformation;
import com.skylon.Appmonitor.entity.Project;
import com.skylon.Appmonitor.entity.RealTimeMonitoringInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INameInfo {

    List<Project> tableinfoabc();
    String findStatus(String proj,String app,String param);
    List<CompleteInformation> findAllStatus(@Param("proj") String proj, @Param("app")  String app, @Param("param")  String param);

}
