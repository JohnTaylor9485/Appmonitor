package com.skylon.Appmonitor.dao;

import com.skylon.Appmonitor.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchOptionDao {

    List<Project> tableinfoabc();
    List<CompleteInformation> findAllStatus(@Param("proj") String proj, @Param("app")  String app, @Param("param")  String param);
    List<RealTimeMonitoringInformation> findStatus(@Param("proj") String proj,@Param("app")  String app,@Param("param")  String param);
}
