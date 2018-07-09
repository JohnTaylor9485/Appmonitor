package com.skylon.Appmonitor.controller;

import com.skylon.Appmonitor.entity.App;
import com.skylon.Appmonitor.entity.Parameter;
import com.skylon.Appmonitor.entity.Project;
import com.skylon.Appmonitor.service.INameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class StatusController {
    @Autowired
    INameInfo iNameInfo;

    @RequestMapping("status")
    ModelAndView searchcontent(ModelAndView mv) {
        List<Project> projectList = iNameInfo.tableinfoabc();
        for (Project p : projectList) {
            for (App a : p.getAppList()) {
                for (Parameter param : a.getParameterList()) {
                    String s = iNameInfo.findStatus(p.getId(), a.getId(), param.getPid());
                    if (s.equals("OK"))
                        param.setpStatus("OK");
                    if (s.equals("ERROR0"))
                        param.setpStatus("NO DATA");
                    if (s.equals("ERROR1"))
                        param.setpStatus("CONNECTION FAILED");
                    if (s.equals("ERROR2"))
                        param.setpStatus("NO RESPONSEDING");

                }
            }
        }
        mv.addObject("projectList", projectList);
        mv.setViewName("StatusList");
        return mv;
    }
}
