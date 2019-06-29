package control;

import model.domin.Student;
import model.domin.User;
import model.service.LoginService;
import model.service.StudentService;

import java.util.ArrayList;

/**
 * 注册信息时的对密码和账号的检测
 * @author Zi10ng
 * @date 2019年6月4日22:49:19
 */
public class    RegisterControl {
    public int checkIn(String id){
        StudentService studentService = new StudentService();
        LoginService loginService = new LoginService();
        ArrayList<Student> students = studentService.query();
        ArrayList<User> users = loginService.query();

        for (User user: users
        ) {
            //如果id和注册表中一样
            if (user.getUserName().equals(id)){
                return 0;
            }
        }
        for (Student student: students
            ) {
            //如果在学生信息里面
            if (student.getId().equals(id)){
                return 1;
            }
        }
        return -1;
    }

}
