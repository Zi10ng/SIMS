package view;

import control.LogControl;
import control.LoginControl;
import model.service.StudentService;

import javax.swing.*;
import java.awt.*;

import static view.LoginRun.loginFrame;

/**
 * 继承面板
 * @author Zi10ng
 * @date 2019年6月4日17:06:57
 */
public class LoginPanel extends JPanel {
    //new组件

    public static String root = "root";
    private static JLabel accountLabel = new JLabel("账号");
    public static String account = accountLabel.getText();
    static RegisterFrame registerFrame;
    static AdminFrame adminFrame;
    private JLabel titleLabel = new JLabel("郑州大学2017级软卓成绩管理系统");
    private JLabel passwordLabel = new JLabel("密码");
    private JLabel confirm = new JLabel("验证码");
    private JTextField accountText = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextField confirmText = new JTextField();
    private JButton loginButton = new JButton("登录");
    private JButton registerButton = new JButton("注册");
    private LoginConfirm loginConfirm = new LoginConfirm();

    /**
     * 对组件进行自定义
     */
    LoginPanel(){
        //自定义组件位置和功能

        //标题组件设置
        titleLabel.setBounds(80,40,400, 35);
        titleLabel.setFont(new Font("黑体", Font.BOLD, 25));
        titleLabel.setForeground(new Color(255, 200, 0));

        //用户名设置
        accountLabel.setBounds(140,110,90,30);
        accountLabel.setFont(new Font("黑体",Font.BOLD,20));
        accountLabel.setForeground(new Color(255, 200, 0));

        //密码设置
        passwordLabel.setBounds(140,155,90,30);
        passwordLabel.setFont(new Font("黑体",Font.BOLD,20));
        passwordLabel.setForeground(new Color(255, 200, 0));

        //验证码
        confirm.setBounds(140,200,90,30);
        confirm.setFont(new Font("黑体",Font.BOLD,20));
        confirm.setForeground(new Color(255, 200, 0));

        //用户名框
        accountText.setBounds(210, 110,180,30);

        //密码框
        passwordField.setBounds(210, 155,180,30);

        //验证码框
        confirmText.setBounds(210,200,70,30);

        //验证码
        loginConfirm.setBounds(295,200,90,30);

        //登录button
        loginButton.setBounds(130, 250, 100, 30);
        loginButton.addActionListener(event -> {
            LoginControl loginControl = new LoginControl();
            StudentService studentService = new StudentService();
            LogControl logControl = new LogControl();
            account = accountText.getText();
            String password = new String( passwordField.getPassword());
            int flag = loginControl.checkIn(account, password);
            //判断验证码
            if (!loginConfirm.getCode().equals(confirmText.getText())) {
                JOptionPane.showMessageDialog(loginFrame, "验证码错误，请核查");
            } else if (flag == 1){
                if (root.equals(account)){
                    JOptionPane.showMessageDialog(loginFrame, "登录成功！欢迎" +
                            account + "查阅本次考试成绩！");
                }
                else {
                    JOptionPane.showMessageDialog(loginFrame, "登录成功！欢迎" +
                            studentService.query(account).getName() + "快乐地查阅本次考试成绩！");
                }
                logControl.log(account, "登录了系统");
                EventQueue.invokeLater(() -> {
                    adminFrame = new AdminFrame();
                    loginFrame.setVisible(false);
                });
            } else if (flag == 0){
                JOptionPane.showMessageDialog(loginFrame, "你未注册，请注册");
            }else if (flag == -1){
                JOptionPane.showMessageDialog(loginFrame, "你的密码错误，请重新输入");
            }
        });

        //注册
        registerButton.setBounds(350, 250, 100, 30);
        registerButton.addActionListener(event ->
            EventQueue.invokeLater(() ->{
                    registerFrame = new RegisterFrame();
                    loginFrame.setVisible(false);
            }
        ));
        init();
    }

    /**
     * 添加组件并初始化
     */
    private void init(){

        setLayout(null);

        add(titleLabel);
        add(accountLabel);
        add(passwordLabel);
        add(accountText);
        add(passwordField);
        add(loginButton);
        add(registerButton);
        add(confirm);
        add(confirmText);
        add(loginConfirm);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(LoginPanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 0, 0, 550, 310, this);
    }
}
