package com.skylon.Appmonitor.dao;

import com.skylon.Appmonitor.entity.CompleteInformation;
import com.skylon.Appmonitor.entity.RealTimeMonitoringInformation;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RealtimeMonitoringDao {
    List<RealTimeMonitoringInformation> listAllMInformation();
    int insertMInformation(RealTimeMonitoringInformation realTimeMonitoringInformation);
    List<CompleteInformation> showallData();

}
