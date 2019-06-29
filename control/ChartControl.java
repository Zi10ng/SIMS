package control;

import model.domin.Student;
import model.service.StudentService;

import java.util.ArrayList;

/**
 * @author Zi10ng
 * @date 2019年6月16日18:48:35
 * 计算表格要显示的内容，如二班的不及格人数比
 */
public class ChartControl {
    public double java1FailRate, db1FailRate, ci1FailRate, java2FailRate, db2FailRate, ci2FailRate, gpa1MaxRate, gpa2MaxRate, gpa1MinRate, gpa2MinRate;

    private StudentService studentService = new StudentService();
    private ArrayList<Student> students = studentService.query();

    private double java1Fail, db1Fail, ci1Fail, java2Fail, db2Fail, ci2Fail, gpa1Max, gpa2Max, gpa1Min, gpa2Min, sum1, sum2;

    /**
     * 算出数量
     */
    private void sum(){
        int fail = 60;
        String  gpaMax = "4.0";
        String  gpaMin = "2.0";
        String class1 = "一班";
        String class2 = "二班";
        java1Fail=java2Fail=db1Fail=db2Fail=ci1Fail=ci2Fail=gpa1Min=gpa2Min=gpa1Max=gpa2Max=sum1=sum2=0;
        for (Student student :students
            ) {
            if (class1.equals(student.getClas())){
                sum1 ++;
                if (gpaMax.equals(studentService.gpa(student.getId()))){
                    gpa1Max ++;
                }else {
                    if (Integer.valueOf(student.getJava()) < fail) {
                        java1Fail++;
                    }
                    if (Integer.valueOf(student.getDb()) < fail) {
                        db1Fail++;
                    }
                    if (Integer.valueOf(student.getCi()) < fail) {
                        ci1Fail++;
                    }
                    if (gpaMin.equals(studentService.gpa(student.getId()))){
                        gpa1Min ++;
                    }
                }
            }else if (class2.equals(student.getClas())){
                sum2 ++;
                if (gpaMax.equals(studentService.gpa(student.getId()))){
                    gpa2Max ++;
                }else {
                    if (Integer.valueOf(student.getJava()) < fail) {
                        java2Fail++;
                    }
                    if (Integer.valueOf(student.getDb()) < fail) {
                        db2Fail++;
                    }
                    if (Integer.valueOf(student.getCi()) < fail) {
                        ci2Fail++;
                    }
                    if (gpaMin.equals(studentService.gpa(student.getId()))){
                        gpa2Min ++;
                    }
                }
            }
        }
    }

    /**
     * 传递参数以供图表使用
     */
    public void chart(){
        sum();
        java1FailRate = java1Fail/sum1;
        db1FailRate = db1Fail/sum1;
        ci1FailRate = ci1Fail/sum1;
        gpa1MaxRate = gpa1Max/sum1;
        gpa1MinRate = gpa1Min/sum1;

        java2FailRate =java2Fail/sum2;
        db2FailRate = db2Fail /sum2;
        ci2FailRate =ci2Fail/sum2;
        gpa2MaxRate =gpa2Max/sum2;
        gpa2MinRate =gpa2Min/sum2;

    }
}
