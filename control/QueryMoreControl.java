package control;

import model.domin.Student;
import model.service.StudentService;

import java.util.ArrayList;

/**
 * 多条件查询时的处理
 * @author Zi10ng
 * @date 2019年6月7日08:55:58
 */
public class QueryMoreControl {
    public QueryMoreControl(){}

    public ArrayList<Student> queryMore(String name, String sex, String clas){

        StudentService studentService = new StudentService();
        String defaultName = "(可选)";
        String nu = "0000";
        if (defaultName.equals(name)||"".equals(name)){
            name = nu;
        }
        if (defaultName.equals(sex)){
            sex = nu;
        }
        if (defaultName.equals(clas)){
            clas = nu;
        }

        return studentService.query(name, sex, clas);
    }

}
