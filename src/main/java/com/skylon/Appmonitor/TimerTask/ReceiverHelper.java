package com.skylon.Appmonitor.TimerTask;

import com.skylon.Appmonitor.dao.RealtimeMonitoringDao;
import com.skylon.Appmonitor.entity.RealTimeMonitoringInformation;

import java.io.*;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReceiverHelper implements Runnable {
    private Socket socket;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private RealTimeMonitoringInformation realTimeMonitoringInformation = new RealTimeMonitoringInformation();

    public ReceiverHelper(Socket clientSocket, RealtimeMonitoringDao realtimeMonitoringDao) {
        try {
            // 得到socket连接
            socket = clientSocket;
            // 得到客户端发来的消息
            InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isReader);
            String mess = br.readLine();
            String[] ms = mess.split("#");
            String[] result = ms[1].split("[*]");
            //切分获得的消息
            realTimeMonitoringInformation.setProjectCode(result[0]);
            realTimeMonitoringInformation.setProgramCode(result[1]);
            realTimeMonitoringInformation.setParameterCode(result[2]);
            realTimeMonitoringInformation.setCollectionTime(sdf.parse(result[3]));
            realTimeMonitoringInformation.setReceiveTime(sdf.parse(result[4]));
            if (result[5].equals("1$"))
                realTimeMonitoringInformation.setStatus(1);
            else
                realTimeMonitoringInformation.setStatus(2);
            //新建信息对象，进行赋值
            realtimeMonitoringDao.insertMInformation(realTimeMonitoringInformation);
            //写入到数据库
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void run() {
    }
}