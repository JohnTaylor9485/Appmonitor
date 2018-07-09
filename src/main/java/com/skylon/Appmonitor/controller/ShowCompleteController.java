package com.skylon.Appmonitor.controller;

import com.skylon.Appmonitor.entity.CompleteInformation;
import com.skylon.Appmonitor.service.IShowCompleteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShowCompleteController {
    @Autowired
    IShowCompleteData iShowCompleteData;
    @RequestMapping("Complete")
    ModelAndView showCompleteData(ModelAndView modelAndView){
        List<CompleteInformation> comList = iShowCompleteData.showCompleteData();
        modelAndView.addObject("comList",comList);
        modelAndView.setViewName("ComInfo");
        return modelAndView;
    }
}
