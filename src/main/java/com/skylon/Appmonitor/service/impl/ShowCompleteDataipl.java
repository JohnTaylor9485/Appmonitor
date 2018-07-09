package com.skylon.Appmonitor.service.impl;

import com.skylon.Appmonitor.dao.RealtimeMonitoringDao;
import com.skylon.Appmonitor.entity.CompleteInformation;
import com.skylon.Appmonitor.service.IShowCompleteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShowCompleteDataipl implements IShowCompleteData {
    @Autowired
    RealtimeMonitoringDao realtimeMonitoringDao;
    @Override
    public List<CompleteInformation> showCompleteData() {
       return realtimeMonitoringDao.showallData();
    }
}
