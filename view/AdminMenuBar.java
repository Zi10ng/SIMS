package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control.LogControl;
import control.LoginControl;
import model.dao.HelpDao;
import model.service.StudentService;

import java.awt.*;

import static view.AdminPanel.*;
import static view.LoginPanel.account;
import static view.LoginPanel.adminFrame;
import static view.LoginRun.loginFrame;
import static view.LoginPanel.root;

/**
 * @author Zi10ng
 * @date 2019年6月5日13:15:28
 */
class AdminMenuBar extends JMenuBar {

    private LogControl logControl = new LogControl();
    private JMenu menu = new JMenu("菜单");
    private JMenu manage = new JMenu("学生管理");
    private JMenu help = new JMenu("帮助");
    private JMenu regist = new JMenu("注册信息");

    private JMenuItem query = new JMenuItem("查看注册信息");
    private JMenuItem id = new JMenuItem("查看身份");
    private JMenuItem logout = new JMenuItem("退出");
    private JMenuItem analysis = new JMenuItem("分析成绩");
    private JMenuItem log = new JMenuItem("查看日志");
    private JMenuItem manual = new JMenuItem("查看手册");

    private JMenuItem studentInfo = new JMenuItem("查看学生信息");
    private JMenuItem changeInfo = new JMenuItem("修改注册信息");


    AdminMenuBar(){
        add(menu);
        add(manage);
        add(help);
        setMenu();
        setAction();
    }

    private void setMenu(){
        manage.add(regist);
        manage.add(studentInfo);
        if (LoginPanel.root.equals(LoginPanel.account)){
            manage.add(analysis);
            help.add(log);
        }
        regist.add(query);
        regist.add(changeInfo);
        menu.add(id);
        menu.add(logout);
        help.add(manual);

    }

    private void setAction(){
        HelpDao helpDao = new HelpDao();
        StudentService studentService = new StudentService();
        id.addActionListener(e -> {
            if (root.equals(LoginPanel.account)) {
                JOptionPane.showMessageDialog(adminFrame, "您是管理员，可以执行任何合理操作");
            }else {
                JOptionPane.showMessageDialog(adminFrame, studentService.query(LoginPanel.account).getName() +
                        ", 你是普通学生，只能查看成绩或者修改自己的账号密码~");
            }
        });

        logout.addActionListener(e -> {
            JOptionPane.showMessageDialog(adminFrame, "退出成功！");
            adminFrame.setVisible(false);
            loginFrame.setVisible(true);
            logControl.log(account, "退出了该系统" );
        });

        query.addActionListener( e -> {
            adminTextPanel.setVisible(false);
            jTextArea.setVisible(false);
            adminScrollPane.setVisible(false);
            adminButtonPanel.setVisible(false);
            adminScrollPaneUser.setVisible(true);
            tableUlit.setTableUser();
            analysisPanel.setVisible(false);
            jUserTable.setVisible(true);
        });
        changeInfo.addActionListener(e ->
            EventQueue.invokeLater(UpdatePasswordFrame::new)
        );
        log.addActionListener(e -> {
            jTextArea.setText(logControl.display());
            adminTextPanel.setVisible(true);
            jTextArea.setVisible(true);
            adminScrollPaneUser.setVisible(false);
            jUserTable.setVisible(false);
            adminScrollPane.setVisible(false);
            adminButtonPanel.setVisible(false);
            analysisPanel.setVisible(false);
        });

        analysis.addActionListener(e -> {
            analysisPanel.setVisible(true);
            adminTextPanel.setVisible(false);
            jTextArea.setVisible(false);
            adminScrollPaneUser.setVisible(false);
            jUserTable.setVisible(false);
            adminScrollPane.setVisible(false);
            adminButtonPanel.setVisible(false);
        });

        studentInfo.addActionListener(e -> {
            jTextArea.setVisible(false);
            adminTextPanel.setVisible(false);
            analysisPanel.setVisible(false);
            adminScrollPane.setVisible(true);
            adminButtonPanel.setVisible(true);
        });
        manual.addActionListener(e -> {
            jTextArea.setText(helpDao.read());
            jTextArea.setVisible(true);
            adminScrollPane.setVisible(false);
            adminButtonPanel.setVisible(false);
            adminScrollPaneUser.setVisible(false);
            jUserTable.setVisible(false);
            analysisPanel.setVisible(false);
            adminTextPanel.setVisible(true);
        });
    }
}
