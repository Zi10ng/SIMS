package model.dao;

import model.domin.Log;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * 用于日志的写入和写出
 * @author Zi10ng
 * @date 2019年6月5日19:44:01
 */
public class LogDao {

    public boolean write(Log log){
        try (FileWriter writer = new FileWriter(
//                "src//file//txt//log.txt",true)){
                LogDao.class.getResource("/").getPath() + "//file//txt//log.txt", StandardCharsets.UTF_8,true)){
            // 将写文件指针移到文件尾。
            writer.write("\r\n");
            writer.write(log.getDate() + "-" + log.getName() + "-" + log.getOperate());

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *
     * @return Log
     */
    public ArrayList<Log> read(){
        ArrayList<Log> logs = new ArrayList<>();

        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(new FileInputStream(
                            LogDao.class.getResource("/").getPath() + "//file//txt//log.txt"), StandardCharsets.UTF_8))
        ) {
            String  message = bufferedReader.readLine();
            while (message != null){
                String [] values = message.split("-");

                //此处可能出现空指针异常，所以要加if
                if (values.length == 3) {
                    logs.add(new Log(values[0], values[1], values[2]));
                }
                message = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return logs;
    }

}
