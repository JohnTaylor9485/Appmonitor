package com.skylon.Appmonitor.service.impl;

import com.skylon.Appmonitor.dao.RealtimeMonitoringDao;
import com.skylon.Appmonitor.entity.RealTimeMonitoringInformation;
import com.skylon.Appmonitor.service.IShowAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShowAllipl implements IShowAll {
    @Autowired
    RealtimeMonitoringDao realtimeMonitoringDao;
    @Override
    public List<RealTimeMonitoringInformation> showAll() {
        return realtimeMonitoringDao.listAllMInformation();
    }
}
