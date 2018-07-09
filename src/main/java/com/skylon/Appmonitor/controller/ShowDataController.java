package com.skylon.Appmonitor.controller;

import com.skylon.Appmonitor.entity.RealTimeMonitoringInformation;
import com.skylon.Appmonitor.service.IShowAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShowDataController {
    @Autowired
    IShowAll iShowAll;
    @RequestMapping(value="/raw")
    public ModelAndView showdate(ModelAndView mv){
        List<RealTimeMonitoringInformation> realTimeMonitoringInformationsList = iShowAll.showAll();
        mv.addObject("dataList",realTimeMonitoringInformationsList);
        mv.setViewName("RawData");
        return mv;
    }
}
