//package model.dao;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
///**
// * @author Zi10ng
// * @date 2019年6月9日13:21:59
// * 帮助文档读取
// */
//public class HelpDao {
//    public String read(){
//        File file = new File("src//file");
//        StringBuilder help = new StringBuilder();
//        try(BufferedReader bufferedReader =
//                    new BufferedReader(new FileReader("src//file//txt//helpMe.txt"))
//                           // HelpDao.class.getResource("/").getPath() + "//file//txt//helpMe.txt"))
//        ) {
//            String  message = bufferedReader.readLine();
//            while (message != null){
//                help.append(message).append("\r\n");
//                message = bufferedReader.readLine();
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return help.toString();
//    }
//}
package model.dao;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Zi10ng
 * @date 2019年6月9日13:21:59
 * 帮助文档读取
 */
public class HelpDao {
    public String read(){

        StringBuilder help = new StringBuilder();
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(new FileInputStream(
                            HelpDao.class.getResource("/").getPath() + "//file//txt//helpMe.txt"), StandardCharsets.UTF_8))) {
            String  message = bufferedReader.readLine();
            while (message != null){
                help.append(message).append("\r\n");
                message = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return help.toString();
    }
}
