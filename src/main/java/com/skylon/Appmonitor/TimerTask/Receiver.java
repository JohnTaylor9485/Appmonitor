package com.skylon.Appmonitor.TimerTask;

import com.skylon.Appmonitor.dao.RealtimeMonitoringDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public class Receiver extends HttpServlet implements ServletContextListener {
   @Autowired
    RealtimeMonitoringDao realtimeMonitoringDao;
    public void contextDestroyed(ServletContextEvent arg0) {
    }
    public void contextInitialized(ServletContextEvent arg0) {
        WebApplicationContextUtils.getRequiredWebApplicationContext(arg0.getServletContext())
                .getAutowireCapableBeanFactory().autowireBean(this);
        System.out.println("-----------------守护线程--------------------------");
        System.out.println("-----------------port监听已启动--------------------------");
        ReceiverStarter s=new ReceiverStarter(realtimeMonitoringDao);
        s.setDaemon(true);// 设置线程为后台线程，tomcat不会被hold,启动后依然一直监听。
        s.start();
    }
}

