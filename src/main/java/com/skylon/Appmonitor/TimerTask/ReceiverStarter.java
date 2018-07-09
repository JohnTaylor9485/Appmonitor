package com.skylon.Appmonitor.TimerTask;

import com.skylon.Appmonitor.dao.RealtimeMonitoringDao;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverStarter extends Thread {
    RealtimeMonitoringDao realtimeMonitoringDao;
    public ReceiverStarter( RealtimeMonitoringDao realtimeMonitoringDao) {
        this.realtimeMonitoringDao=realtimeMonitoringDao;
    }
    public void run() {
        int port=8088;
        System.out.println("-----------------port:"+port+"---------------------------");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
                // 轮流等待请求
            while(true)
            {
                // 等待客户端请求,无请求则闲置;有请求到来时,返回一个对该请求的socket连接
                Socket clientSocket = serverSocket.accept();
                // ReceiverHelper,通过socket连接通信
                Thread t = new Thread(new ReceiverHelper(clientSocket,realtimeMonitoringDao));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}