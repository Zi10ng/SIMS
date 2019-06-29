package model.service;

import model.dao.StudentDao;
import model.domin.Student;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 对学生信息进行增删查改
 * @author 王石博
 * @date 2019年6月2日09:43:41
 */

public class StudentService {

    private StudentDao studentDao = new StudentDao();

    /**
     * 通过id查询学生信息
     *
     * @param id 学生ID
     * @return 返回学生类
     */
    public Student query(String id) {

        handleNull(id);

        return studentDao.read(id);
    }

    /**
     * 调用dao查询所有信息
     *
     * @return ArrayLIst<Student>
     */
    public ArrayList<Student> query() {

        return studentDao.read();
    }

    /**
     * 选择性查询，参数是0000默认没填写
     * 如果都没填写则进入不了这个方法，前端检查
     *
     * @param name 姓名
     * @param sex  性别
     * @param clas 班级
     * @return arrayList
     */
    public ArrayList<Student> query(String name, String sex, String clas) {

        String nu = "0000";
        ArrayList<Student> students = studentDao.read();

        //下面这句话不new的话会产生空指针异常
        ArrayList<Student> students1 = new ArrayList<>();
        if (nu.equals(name) && nu.equals(sex) && nu.equals(clas)){
            return null;
        }
        for (Student student : students
        ) {
            boolean exist = (student.getName().equals(name) || nu.equals(name)) &&
                            (student.getSex().equals(sex) || nu.equals(sex)) &&
                            (student.getClas().equals(clas) || nu.equals(clas));
            if (exist){
                students1.add(student);
            }
        }
        return students1;
    }

    /**
     * 增添一条记录并写入
     * @param student 学生类
     * @return boolean
     */
    public boolean insert(Student student){
        studentDao.write(student);
        return true;
    }

    /**
     * 删除一条学生信息并将剩余信息写入文件
     * @param id 学生id
     * @return boolean
     */
    public boolean delete(String id){

        if (! handleNull(id)) {
            return false;
        }

        ArrayList<Student> students = studentDao.read();
        for (Student e: students
             ) {
            if (id.equals(e.getId())) {
                students.remove(e);
                break;
            }
        }
        studentDao.write(students);
        return true;
    }

    /**
     * 更新并写入文件
     * @param id  学生id
     * @param raw  要更新的属性
     * @param now  要更新的属性的值
     */
    public boolean update(String id, String raw, String now){

        final String value1 = "姓名";
        final String value2 = "性别";
        final String value3 = "班级";
        final String value4 = "Java";
        final String value5 = "数据库";
        final String value6 = "计网";

        if ( !handleNull(id)){
            return false;
        }

        //将更新值重置到student中
        Student student = studentDao.read(id);
        switch (raw){
            case (value1):
                student.setName(now);
                break;
            case (value2):
                student.setSex(now);
                break;
            case (value3):
                student.setClas(now);
                break;
            case (value4):
                student.setJava(now);
                break;
            case (value5):
                student.setDb(now);
                break;
            case (value6):
                student.setCi(now);
                break;
            default:
        }
        //删除原来id的学生，并将新值插入
        delete(id);
        insert(student);

        return true;
    }

    /**
     * 将文件中的信息按照ID排序并写入文件
     * @return 布尔值
     */
    public boolean sortByGPA(ArrayList<Student> students){

        students.sort(Student::compareTo);

        return true;
    }

    /**
     * 计算GPA,通过hash
     * @param id 学生id
     * @return 返回double
     */
    public String gpa(String id){
        HashMap<Integer, Double> hash = new HashMap<>(25);
        hash.put(90, 4.0);
        hash.put(85, 3.7);
        hash.put(80, 3.5);
        hash.put(75, 3.2);
        hash.put(70, 3.0);
        hash.put(65, 2.7);
        hash.put(60, 2.5);
        hash.put(0, 0.0);
        Student student = studentDao.read(id);
        Double gpa = hash.get(score(Integer.valueOf(student.getCi()))) * 0.4 +
                hash.get(score(Integer.valueOf(student.getDb()))) * 0.3 +
                hash.get(score(Integer.valueOf(student.getJava()))) * 0.3;
        return gpa.toString().substring(0, 3);
    }

    /**
     * 把成绩转化成绩点能识别的成绩，二分法
     * @param score 成绩
     * @return int
     */
    private int score(int score){
        //二分法
        if (score >= 75){
            if (score >= 80){
                if (score >= 85){
                    if (score >= 90){
                        return 90;
                    }
                    return 85;
                }
                return 80;
            }
            return 75;
        }else if (score < 70){
            if (score < 65){
                if (score < 60){
                    return 0;
                }
                return 60;
            }
            return 70;
        }else {
            return 75;
        }
    }


    /**
     * 处理访问不到相应id的情况
     * @param id  学生id
     */
    private boolean handleNull(String id){
        return studentDao.read(id) != null;
    }
}

