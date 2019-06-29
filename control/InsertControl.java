package control;

import model.domin.Student;
import model.service.StudentService;

/**
 * @author Zi10ng
 * @date 2019年6月7日13:38:58
 * 对插入数据格式的检测
 */
public class InsertControl {
    public InsertControl(){

    }
    public int insert(String id, String name, String sex, String clas, String java, String db, String ci){
        StudentService studentService = new StudentService();
        int flag = 100;
        if (studentService.query(id) != null){
            //存在该id
            return -1;
        }
        if ("".equals(id) || "".equals(java) || "".equals(db) || "".equals(ci) || "".equals(name)){
            //未插入有效数据
            return 0;
        }
        if (!(isNumber(java) && isNumber(db) && isNumber(ci))){
            //不是数字
            return 2;
        }
        if (Integer.valueOf(java) > flag || Integer.valueOf(db) > flag || Integer.valueOf(ci) > flag){
            //成绩大于100分
            return -2;
        }else {
            studentService.insert(new Student(id,name,sex,clas,java,db,ci));
            return 1;
        }
    }

    /**
     * 判断字符串是否是数字
     * @param str 字符串
     * @return Boolean
     */
    boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
