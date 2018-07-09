package com.skylon.Appmonitor.controller;

import com.skylon.Appmonitor.entity.CompleteInformation;
import com.skylon.Appmonitor.service.INameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StatusController {
@Autowired
    INameInfo iNameInfo;


    @RequestMapping("/status/details")
    ModelAndView searhResult(@RequestParam("app") String AppId,
                             @RequestParam("proj") String ProjId,
                             @RequestParam("param") String ParamId,
                             ModelAndView modelAndView) {
        List<CompleteInformation> resultList=iNameInfo.findAllStatus(ProjId,AppId,ParamId);
        modelAndView.addObject("resultList",resultList);
        modelAndView.setViewName("Details");
        return modelAndView;
    }
}
