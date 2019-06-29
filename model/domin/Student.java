package model.domin;


import model.service.StudentService;

/**
 * @author 王石博
 * @date 2019年6月1日16:46:23
 * domin 用来存放实体属性，不做操作
 *       直接和文件进行交互
 */
public class Student implements Comparable<Student> {

    /**
     * 学生信息
     */
    private String id;
    private String name;
    private String sex;
    private String clas;
    private String java;
    private String db;
    private String ci;


    public Student(){}
    public Student(String id, String name, String sex, String clas, String java, String db, String ci) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.clas = clas;
        this.java = java;
        this.db = db;
        this.ci = ci;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public int compareTo(Student s) {
        StudentService studentService = new StudentService();
        return studentService.gpa(s.getId()).compareTo(studentService.gpa(id));
    }

    @Override
    public String toString() {
        return getId() + getName();
    }
}
