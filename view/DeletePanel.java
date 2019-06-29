package view;

import control.LogControl;
import model.domin.Student;
import model.service.LoginService;
import model.service.StudentService;

import javax.swing.*;
import java.awt.*;


import static view.AdminButtonPanel.deleteFrame;

/**
 * @author Zi10ng
 * @date 2019年6月5日18:39:45
 */
class DeletePanel extends JPanel {
    private JButton delete = new JButton("删除");
    private JTextField textField = new JTextField();
    private JLabel jLabel = new JLabel("请输入删除学生ID");

    private LoginService loginService = new LoginService();
    private StudentService studentService = new StudentService();

    DeletePanel(){

        jLabel.setBounds(105,40,150, 20);
        jLabel.setFont(new Font("黑体", Font.BOLD, 15));
        jLabel.setForeground(new Color(255,200,0));

        textField.setBounds(255, 40,160,20);

        delete.setBounds(225,80,50,20);
        delete.setMargin(new Insets(0,0,0,0));
        delete.addActionListener( e -> {
            String account = textField.getText();
            if (studentService.query(account) == null){
                JOptionPane.showMessageDialog(this, "不存在该学生，请检查输入！");
            } else {
                LogControl logControl = new LogControl();
                String name = studentService.query(account).getName();
                studentService.delete(account);
                loginService.delete(account);
                JOptionPane.showMessageDialog(this, "已将" + name + "删除，TA不能登录该系统并查阅成绩");
                logControl.log("root", "删除了" + account);
            }
        });
        init();
    }

    private void init(){
        setLayout(null);
        add(jLabel);
        add(textField);
        add(delete);
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(DeletePanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 0, 0, 550, 200, this);
    }
}
