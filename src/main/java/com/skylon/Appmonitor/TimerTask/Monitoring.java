package com.skylon.Appmonitor.TimerTask;
import com.skylon.Appmonitor.dao.RealtimeMonitoringDao;
import com.skylon.Appmonitor.entity.RealTimeMonitoringInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class Monitoring {
    @Autowired
    RealtimeMonitoringDao realtimeMonitoringDao;
    @Autowired
    RealTimeMonitoringInformation realTimeMonitoringInformation ;
    private String command;//最终要发送的命令
    private int Testport;//需要测试的端口
    private int Serverport;//接收命令的端口
    private BufferedWriter writer;
    private String Testhost;//需要测试的host
    private String Serverhost;//接收命令的host
    private String AreaId;//区域代码
    private String AppId;//程序代码
    private String ModelId;//模块代码
    private int status;//连通状态，1代表接通，2代表失败
    private Date TestTime;//进行ping测试的时间
    private Date SendTime;//发送指令的时间
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Monitoring(MonitorConfiguration monitorConfiguration) {
        //通过监视配置对象进行配置，该对象属性可以在app。properties中进行修改
        Testport = monitorConfiguration.getTestport();
        Serverport = monitorConfiguration.getServerport();
        Testhost = monitorConfiguration.getTesthost();
        Serverhost = monitorConfiguration.getServerhost();
        AreaId = monitorConfiguration.getAreaId();
        AppId = monitorConfiguration.getAppId();
        ModelId = monitorConfiguration.getModelId();
        status = 2;
    }

    public void generateCommond() {
        //根据信息构建要发送的指令
        StringBuilder stringBuilder = new StringBuilder("!report#");
        stringBuilder.append(AreaId);
        stringBuilder.append("*");
        stringBuilder.append(AppId);
        stringBuilder.append("*");
        stringBuilder.append(ModelId);
        stringBuilder.append("*");
        stringBuilder.append(sdf.format(TestTime));
        stringBuilder.append("*");
        SendTime = new Date();
        stringBuilder.append(sdf.format(SendTime));
        stringBuilder.append("*");
        stringBuilder.append(status);
        stringBuilder.append("$");
        command = stringBuilder.toString();

    }

    public void testconnection() {
        //在此进行ping测试操作，设定测试时间，设定测试结果
        //应更改为更精确的测试方式，现在仅作为测试用途
        TestTime = new Date();
        try {
            String temp = sdf.format(TestTime);
            TestTime = sdf.parse(temp);
            Socket testsocket = new Socket(Testhost, Testport);
            testsocket.close();
            status = 1;
        } catch (Exception e) {
            status = 2;
            System.out.println("Connection Failed");
        }
    }


    public void intoDatabase() throws ParseException {
        //不发送命令将结果直接存入数据库
        realTimeMonitoringInformation.setProjectCode(AreaId);
        realTimeMonitoringInformation.setProgramCode(AppId);
        realTimeMonitoringInformation.setParameterCode(ModelId);
        realTimeMonitoringInformation.setCollectionTime(TestTime);
        SendTime = new Date();
        String temp = sdf.format(SendTime);
        SendTime = sdf.parse(temp);
        realTimeMonitoringInformation.setReceiveTime(SendTime);
        realTimeMonitoringInformation.setStatus(status);
        realtimeMonitoringDao.insertMInformation(realTimeMonitoringInformation);
    }


    public void sendmsg() {
        try {
            Socket socket = new Socket(Serverhost, Serverport);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            generateCommond();
            writer.write(command);
            System.out.println(command);
            writer.newLine();
            writer.flush();
            socket.close();
        } catch (Exception ex) {
            System.out.println("server holding");
        }
    }

    public void Startmonitoring() throws ParseException {
        testconnection();
        // intoDatabase();
        sendmsg();
    }

    @Scheduled(cron = "0 0/10 * * * ?")
    public void test1() throws ParseException {
        Startmonitoring();
    }

}