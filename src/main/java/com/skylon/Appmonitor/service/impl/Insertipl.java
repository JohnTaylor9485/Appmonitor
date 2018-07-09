package com.skylon.Appmonitor.service.impl;

import com.skylon.Appmonitor.dao.RealtimeMonitoringDao;
import com.skylon.Appmonitor.entity.RealTimeMonitoringInformation;
import com.skylon.Appmonitor.service.IInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Insertipl implements IInsert {
    @Autowired
    RealtimeMonitoringDao realtimeMonitoringDao;
    @Override
    public int insertMInformation(RealTimeMonitoringInformation realTimeMonitoringInformation) {
        System.out.println("yes1");
        return realtimeMonitoringDao.insertMInformation(realTimeMonitoringInformation);
    }
}
