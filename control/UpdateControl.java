package control;

import model.service.StudentService;

/**
 * 对更新学生信息时格式的检测
 * @author Zi10ng
 * @date 2019年6月7日14:41:12
 */
public class UpdateControl {
    public UpdateControl(){

    }
    public int update(String id, String attribute, String value){
        StudentService studentService =new StudentService();
        InsertControl insertControl = new InsertControl();

        final String value2 = "性别";
        final String value3 = "班级";
        final String value4 = "Java";
        final String value5 = "数据库";
        final String value6 = "计网";

        if ("".equals(id) || "".equals(value)){
            //未填写信息
            return -1;
        }
        boolean exist1 = (value2.equals(attribute)&& !("男".equals(value) || "女".equals(value))) ||
                        (value3.equals(attribute)&& !("一班".equals(value) || "二班".equals(value)));
        if (exist1){
            //格式不正确
            return 0;
        }

        boolean exist3 = (!insertControl.isNumber(value)) && (value4.equals(attribute) || value5.equals(attribute) || value6.equals(attribute));
        if (exist3){
            //不是数字
            return 3;
        }

        boolean exist2 = (value4.equals(attribute)&&(Integer.valueOf(value) > 100)) ||
                        (value5.equals(attribute)&&(Integer.valueOf(value) > 100)) ||
                        (value6.equals(attribute)&&(Integer.valueOf(value) > 100));

        if (exist2){
            //大于100
            return 2;
        }
        if (studentService.update(id, attribute, value)){
            //查询成功
            return 1;
        }else {
            //id不存在
            return -2;
        }
    }
}
