package view;

import control.TableControl;
import model.domin.Student;

import java.util.ArrayList;

class TableUlit {
    private String [] name = {"学号","姓名","性别","班级","Java","数据库","计网","GPA","排名"};
    private String [] user = {"学号","密码"};
    private TableControl tableControl = new TableControl();
    void setTable(){
        AdminPanel.model.setDataVector(tableControl.displayTable(),name);
    }
    void setTable(ArrayList<Student> students){
        AdminPanel.model.setDataVector(tableControl.displayTable(students),name);
    }
    void setTable(Student student){
        AdminPanel.model.setDataVector(tableControl.displayTable(student),name);
    }
    void setTableUser(){
        if (LoginPanel.root.equals(LoginPanel.account)) {
            AdminPanel.modelUser.setDataVector(tableControl.displayUser(), user);
        }else {
            AdminPanel.modelUser.setDataVector(tableControl.displayUser(LoginPanel.account), user);
        }
    }
}
