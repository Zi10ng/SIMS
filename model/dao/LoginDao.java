package model.dao;

import model.domin.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * 负责对login文件的读取和写入，login包括管理员和学生
 * @author Zi10ng
 * @date 2019年6月4日08:18:22
 */
public class LoginDao{

    /**
     * 通过用户名读取密码
     * @param userName 用户名
     * @return login类
     */
    public User read(String userName){
        User user = null;

        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(new FileInputStream(
//                             "src//file//txt//login.txt"))
                             LoginDao.class.getResource("/").getPath() + "//file//txt//login.txt"), StandardCharsets.UTF_8))
        ) {
            String message = bufferedReader.readLine();
            while (message != null) {
                String[] values = message.split("-");
                //注意第二个if
                if (userName.equals(values[0]) && values.length == 2) {
                    user = new User(values[0], values[1]);
                    break;
                }
                message = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件中没有数据，请先插入数据！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 读取所有的用户信息，便于删除
     * @return login类数组
     */
    public ArrayList<User> read(){
        ArrayList<User> users = new ArrayList<>();

        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(new FileInputStream(
//                            "src//file//txt//login.txt"))
                            LoginDao.class.getResource("/").getPath() + "//file//txt//login.txt"), StandardCharsets.UTF_8))
        ) {
            String  message = bufferedReader.readLine();
            while (message != null){
                String [] values = message.split("-");

                //此处可能出现空指针异常，所以要加if
                if (values.length == 2) {
                    users.add(new User(values[0], values[1]));
                }
                message = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return users;
    }

    /**
     * 通过写入信息
     * @param user  用户类
     */
    public void write(User user){

        try (FileWriter writer = new FileWriter(
//                "src//file//txt//login.txt", true)){
                LoginDao.class.getResource("/").getPath() + "//file//txt//login.txt", StandardCharsets.UTF_8,true)){

            // 将写文件指针移到文件尾。
            writer.write("\r\n");
            writer.write(user.getUserName() + "-" + user.getPassword());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入所有信息
     * @param users 用户信息list
     */
    public void write(ArrayList<User> users) {

        //加这个是为了先清空文件内容
        try (FileWriter fileWriter =new FileWriter(
//                "src//file//txt//login.txt")){
                LoginDao.class.getResource("/").getPath() + "//file//txt//login.txt",StandardCharsets.UTF_8)){

            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter =new FileWriter(
//                "src//file//txt//login.txt", true)){
                LoginDao.class.getResource("/").getPath() + "//file//txt//login.txt",StandardCharsets.UTF_8,true)) {

            for (int i = 0; i < users.size(); i++) {
                if (i == 0){
                    fileWriter.write(users.get(i).getUserName() + "-" + users.get(i).getPassword());
                } else {
                    fileWriter.write("\r\n");
                    fileWriter.write(users.get(i).getUserName() + "-" + users.get(i).getPassword());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
