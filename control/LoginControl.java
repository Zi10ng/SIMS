package control;

import model.dao.LoginDao;
import model.domin.Log;
import model.domin.User;
import model.domin.Student;
import model.service.LoginService;
import model.service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 登录时的控制类
 * @author Zi10ng
 * @date 2019年6月4日14:57:31
 */
public class LoginControl {

    private LoginService loginService = new LoginService();

    /**
     * 只用来验证账号和密码
     * @param userName 用户名
     * @param password 密码
     * @return int
     */
    public int checkIn(String userName, String password){

        //不能直接返回，当userName不匹配时会造成空指针异常
        if (loginService.query(userName) == null) {
            return 0;
        }
        else if (loginService.query(userName).getPassword().equals(password)){
            return 1;
        }
        else {
            return -1;
        }
    }

    /**
     * 将username和id相同的login和student放在map中
     * @return map
     */
    public HashMap<User, Student> checkIn(){

        HashMap<User, Student> loginStudentHashMap = new HashMap<>(16);
        ArrayList<User> users = loginService.query();
        StudentService studentService = new StudentService();
        ArrayList<Student> students = studentService.query();

        //把学生的id放到map中
        for (User user : users
             ) {
            for (Student student: students
                 ) {
                if (user.getUserName().equals(student.getId())){
                    loginStudentHashMap.put(user, student);
                }
            }
        }
        return loginStudentHashMap;
    }

    public String queryInfo(){

            LoginDao loginDao = new LoginDao();
            ArrayList<User> users = loginDao.read();
            StringBuilder s = new StringBuilder(10);
            for (User user : users
            ) {
                s.append(user.getUserName()).append("--").append(user.getPassword()).append("\r\n");
            }
            return s.toString();

    }
}
