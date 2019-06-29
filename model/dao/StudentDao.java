package model.dao;

import model.domin.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author Zi10ng
 * @date 2019年6月1日16:54:40
 * 持久层，只负责对student文件的读取和写入，不处理逻辑，即I/O层
 */
public class StudentDao {

    /**
     * 通过ID对读出单个学生的信息
     * @param id 学号
     * @return Student类型值
     */

    public Student read(String id){

        Student student = null;

        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(new FileInputStream(
//                             "src//file//txt//student.txt"))
             StudentDao.class.getResource("/").getPath() + "//file//txt//student.txt"), StandardCharsets.UTF_8))
        ) {
            String message = bufferedReader.readLine();
            while (message != null) {
                String[] values = message.split("-");
                //注意第二个if
                if (id.equals(values[0]) && values.length == 7) {
                    student = new Student(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
                    break;
                }
                message = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件中没有数据，请先插入数据！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 读出文件中所有的学生
     * @return ArrayList<Student> 学生类的数组
     */
    public ArrayList<Student> read(){

        ArrayList<Student> students = new ArrayList<>();

        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(new FileInputStream(
//                            "src//file//txt//student.txt"))
                            StudentDao.class.getResource("/").getPath() + "//file//txt//student.txt"), StandardCharsets.UTF_8))
        ) {
            String  message = bufferedReader.readLine();
            while (message != null){
                String [] values = message.split("-");

                //此处可能出现空指针异常，所以要加if
                if (values.length == 7) {
                    students.add(new Student(values[0], values[1], values[2], values[3], values[4], values[5], values[6]));
                }
                message = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return students;
    }

    /**
     *  写入Student的信息
     * @param student 学生类
     */

    public void write(Student student){

        try (FileWriter writer = new FileWriter(
//                "src//file//txt//student.txt", true)){
                StudentDao.class.getResource("/").getPath() + "//file//txt//student.txt", StandardCharsets.UTF_8,true)){

            // 将写文件指针移到文件尾。
            writer.write("\r\n");
            writer.write(student.getId() + "-" + student.getName() + "-" + student.getSex()+ "-" +
                    student.getClas() + "-" + student.getJava() + "-" + student.getDb() + "-" + student.getCi());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入所有Student的信息
     * @param students 学生集合
     */
    public void write(ArrayList<Student> students) {

        //加这个是为了先清空文件内容
        try (FileWriter fileWriter =new FileWriter(
//                "src//file//txt//student.txt")){
                StudentDao.class.getResource("/").getPath() + "//file//txt//student.txt",StandardCharsets.UTF_8)){

            fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter =new FileWriter(
//                "src//file//txt//student.txt", true)){
                StudentDao.class.getResource("/").getPath() + "//file//txt//student.txt",StandardCharsets.UTF_8,true)) {

            for (int i = 0; i < students.size(); i++) {
                if (i == 0){
                    fileWriter.write(students.get(i).getId() + "-" + students.get(i).getName() + "-" + students.get(i).getSex() + "-" +
                            students.get(i).getClas() + "-" + students.get(i).getJava() + "-" + students.get(i).getDb() + "-" + students.get(i).getCi());
                } else {
                    fileWriter.write("\r\n");
                    fileWriter.write(students.get(i).getId() + "-" + students.get(i).getName() + "-" + students.get(i).getSex() + "-" +
                            students.get(i).getClas() + "-" + students.get(i).getJava() + "-" + students.get(i).getDb() + "-" + students.get(i).getCi());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
