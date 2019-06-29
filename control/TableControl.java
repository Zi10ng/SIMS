package control;

import model.domin.Student;
import model.domin.User;
import model.service.LoginService;
import model.service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 处理与表相关的问题
 * @author Zi10ng
 * @date 2019年6月6日14:54:27
 */
public class TableControl {
    private StudentService studentService = new StudentService();
    //这个hash是供该类所有方法使用，要加上static

    private static HashMap<String,Integer> idRank = new HashMap<>();
    //数目长度

    public static int rowCounts;

    /**
     * 显示文件中所有
     * @return String[][]
     */
    public String [][] displayTable(){
        //?如何动态变化数组
        String [][] display = new String[40][10];
        ArrayList<Student> students = studentService.query();
        studentService.sortByGPA(students);
        int i = 0;
        for (Student student : students
                ) {
            display[i][0] = student.getId();
            display[i][1] = student.getName();
            display[i][2] = student.getSex();
            display[i][3] = student.getClas();
            display[i][4] = student.getJava();
            display[i][5] = student.getDb();
            display[i][6] = student.getCi();
            display[i][7] = studentService.gpa(student.getId());
            display[i++][8] = Integer.valueOf(i).toString();
            idRank.put(display[i - 1][0], i);
        }
        rowCounts = i;
        return display;
    }
    /**
     * 显示一个
     * @return String[][]
     */
    public String [][] displayTable(Student student){
        String [][]  display = new String[16][10];
        display[0][0] = student.getId();
        display[0][1] = student.getName();
        display[0][2] = student.getSex();
        display[0][3] = student.getClas();
        display[0][4] = student.getJava();
        display[0][5] = student.getDb();
        display[0][6] = student.getCi();
        display[0][7] = studentService.gpa(student.getId());
        display[0][8] = idRank.get(display[0][0]).toString();
        return display;
    }

    /**
     * 显示部分
     * @param students 学生数组
     * @return 字符串数组
     */
    public String [][] displayTable(ArrayList<Student> students){
        studentService.sortByGPA(students);
        String [][] display = new String[30][10];
        int i = 0;
        for (Student student : students
        ) {
            display[i][0] = student.getId();
            display[i][1] = student.getName();
            display[i][2] = student.getSex();
            display[i][3] = student.getClas();
            display[i][4] = student.getJava();
            display[i][5] = student.getDb();
            display[i][6] = student.getCi();
            display[i][7] = studentService.gpa(student.getId());
            display[i][8] = idRank.get(display[i++][0]).toString();
        }
        return display;
    }

    /**
     * 显示所有用户及密码
     * @return string[][]
     */
    public String[][] displayUser(){
        String [][] display = new String[30][3];
        LoginService loginService = new LoginService();
        ArrayList<User> users = loginService.query();
        users.sort(User::compareTo);
        int i = 0;
        for (User user : users
        ) {
            display[i][0] = user.getUserName();
            display[i++][1] = user.getPassword();
        }
        return display;
    }

    /**
     * 显示一个用户的密码
     * @param id id
     * @return String[][]
     */
    public String[][] displayUser(String id){
        String [][]  display = new String[16][3];
        LoginService loginService = new LoginService();
        User user = loginService.query(id);
        display[0][0] = user.getUserName();
        display[0][1] = user.getPassword();
        return display;
    }
}
