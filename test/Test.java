package test;

import control.LogControl;
import control.LoginControl;
import model.dao.LoginDao;
import model.domin.User;
import model.domin.Student;
import model.dao.StudentDao;
import model.service.LoginService;
import model.service.StudentService;
import view.*;

import java.util.ArrayList;

/**
 * 测试程序
 * @author Zi10ng
 * @date 2019年6月4日14:47:11
 *                                                    __----~~~~~~~~~~~------___
 *                                   .  .   ~~//====......          __--~ ~~
 *                   -.            \_|//     |||\\  ~~~~~~::::... /~
 *                ___-==_       _-~o~  \/    |||  \\            _/~~-
 *        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 *    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 *  .~       .~       |   \\ -_    /  /-   /   ||      \   /
 * /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 * |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 *          '         ~-|      /|    |-~\~~       __--~~
 *                      |-~~-_/ |    |   ~\_   _-~            /\
 *                           /  \     \__   \/~                \__
 *                       _--~ _/ | .-~~____--~-/                  ~~==.
 *                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
 *                                 -_     ~\
 *                           神兽保佑测试代码永无bug
 */
public class Test {

    private static Student student = new Student();
    private static StudentDao studentDao = new StudentDao();
    private static StudentService studentService = new StudentService();
    private static ArrayList<Student> students = new ArrayList<>();

    private static User user = new User("2017103","333");
    private static LoginDao loginDao = new LoginDao();
    private static LoginService loginService = new LoginService();
    private static ArrayList<User> users = new ArrayList<>();

    private static LoginControl loginControl = new LoginControl();
    private static RegisterFrame registerFrame;

    private static AdminFrame adminFrame;

    public static void main(String[] args) {



        //QueryFrame queryFrame = new QueryFrame();
        //InsertFrame insertFrame = new InsertFrame();
        //test4();
    }

    /**
     * 第一次测试，有些bug
     * @author Zi10ng
     * @date 2019年6月1日23:15:59
     */
    public static void test1(){

        int a = 11;
        System.out.println(String.valueOf(a));

        studentDao = new StudentDao();
        student = studentDao.read("001");
        System.out.println(student.getCi());

        studentDao = new StudentDao();
        students = studentDao.read();
        for (Student e: students
             ) {
            System.out.println(e.getName());
        }
    }

    /**
     * 第二次测试，增删查改完成，排序完成，可以写汉语
     * @author Zi10ng
     * @date 2019年6月2日15:44:42
     */
    public static void test2(){
        students = studentService.query();
        for (Student e: students
        ) {
            System.out.println(e.getId());
        }
        student = studentService.query("002");
        System.out.println(student.getName());
        studentService.insert(new Student("009","贾玲", "女", "二班","100","10","23"));
        studentService.delete("002");
        studentService.update("001","CI","100");
        studentService.sortByGPA(students);
    }
    /**
     * 第三次测试，多条件查询，但是总是出现空指针异常
     * 空指针异常问题解决，是因为刚开始指向了一个null值
     * @author Zi10ng
     * @date 2019年6月2日20:09:25
     */
    public static void test3(){
        ArrayList<Student> students = studentService.query("0000","男","0000");

        for (Student student: students
        ) {
            System.out.println(student.getName());
        }
    }

    /**
     * 第四次测试，用于登录的用户增删查完成
     * @author Zi10ng
     * @date 2019年6月4日09:08:36
     */
    public static void test4(){
        loginService.insert(user);
        user = loginService.query("2017201");
        System.out.println(user.getUserName() + user.getPassword());
        loginService.update("2017201","201");
    }

    /**
     * 第五次测试，用于测试密码以及用户校验
     * 在读取文件时候又出现了空指针异常
     * 问题解决，是未进行空指针检查
     * @author Zi10ng
     * @date 2019年6月4日15:46:00
     */
    public static void test5(){
        System.out.println(loginControl.checkIn("100","cool"));
        System.out.println(loginControl.checkIn("2017201","111"));
        System.out.println(loginControl.checkIn().get(loginService.query("2017201")).getName());
    }
    /**
     * 第六次测试，辅助GUI完成
     * @author Zi10ng
     * @date 2019年6月5日08:41:25
     */
    public static void test6(){
        registerFrame = new RegisterFrame();
    }

    /**
     * 第七次测试，删除面板完成但是对ui不满意，可能会重构
     */
    public static void test7(){
        adminFrame = new AdminFrame();
        //new DeleteFrame();
    }

    /**
     * 第8次测试，日志读写完成
     * @author Zi10ng
     * @date 2019年6月6日12:23:27
     */
    public static void test8(){
        LogControl logControl = new LogControl();
        logControl.log("root", "测试了该程序");
        System.out.println(logControl.display());
    }
}
