package control;

import model.dao.LogDao;
import model.domin.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 此处将操作记录在log文件中，并配上时间
 * @author Zi10ng
 * @date 2019年6月5日19:48:06
 */
public class LogControl {

    private LogDao logDao = new LogDao();

    /**
     * 将日志通过到写入文件
     * @param name 操作者
     * @param operate 操作
     */
    public void log(String name, String operate){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        logDao.write(new Log(simpleDateFormat.format(date), name, operate));
    }

    /**
     * 通过dao将读出来的数据转换为字符串
     * 通过StringBuffer实现
     * @return String
     */
    public String display(){

        ArrayList<Log> logs = logDao.read();
        StringBuilder s = new StringBuilder(10);
        for (Log log: logs
             ) {
            s.append(log.getDate()).append("--").append(log.getName()).append("--").append(log.getOperate()).append("\r\n");
        }
        return s.toString();
    }
}
