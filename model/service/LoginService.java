package model.service;

import model.dao.LoginDao;
import model.domin.User;

import java.util.ArrayList;

/**
 * 对登录文件进行增删查
 * @author 王石博
 * @date 2019年6月4日08:49:32
 */
public class LoginService {
    private LoginDao loginDao = new LoginDao();

    /**
     * 通过用户名查询用户
     * @param userName 用户名
     * @return 用户类
     */
    public User query(String userName){
        return loginDao.read(userName);
    }

    /**
     * 读取所有信息
     * @return list
     */
    public ArrayList<User>  query(){
        return loginDao.read();
    }

    /**
     * 插入用户类
     * @param user 用户类
     * @return boolean
     */
    public boolean insert(User user){
        loginDao.write(user);
        return true;
    }

    /**
     * 通过用户名删除用户
     * @param userName 用户名
     * @return boolean
     */
    public boolean delete(String userName){
        ArrayList<User> users = loginDao.read();
        if (loginDao.read(userName) == null){
            return false;
        }
        for (User e: users
        ) {
            if (userName.equals(e.getUserName())) {
                users.remove(e);
                break;
            }
        }
        loginDao.write(users);
        return true;

    }
    /**
     * 更新
     */
    public boolean update(String userName, String pass){
        LoginDao loginDao = new LoginDao();
        User user = loginDao.read(userName);
        user.setPassword(pass);
        delete(userName);
        insert(user);
        return true;
    }
}
