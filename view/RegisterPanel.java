package view;

import control.LogControl;
import control.RegisterControl;
import model.domin.User;
import model.service.LoginService;

import javax.swing.*;
import java.awt.*;

import static view.LoginPanel.registerFrame;
import static view.LoginRun.loginFrame;

/**
 * @author Zi10ng
 * @date 2019年6月4日21:44:41
 */
class RegisterPanel extends JPanel {

    private RegisterControl registerControl = new RegisterControl();
    private JLabel titleLabel = new JLabel("郑州大学2017级软卓成绩管理系统");
    private JLabel accountLabel = new JLabel("账号");
    private JLabel passwordLabel1 = new JLabel("密码");
    private JLabel passwordLabel2 = new JLabel("确认");
    private JTextField accountText = new JTextField("");
    private JPasswordField passwordField1 = new JPasswordField();
    private JPasswordField passwordField2 = new JPasswordField();
    private JButton registerButton = new JButton("注册");
    private JButton loginButton = new JButton("返回登录");

    /**
     * 对组件进行自定义
     */
    RegisterPanel(){
        //自定义组件位置和功能

        //标题组件设置
        titleLabel.setBounds(25,40,400, 20);
        titleLabel.setFont(new Font("黑体", Font.BOLD, 18));
        titleLabel.setForeground(new Color(255, 200, 0));

        //用户名设置
        accountLabel.setBounds(70,90,90,30);
        accountLabel.setFont(new Font("黑体",Font.BOLD,15));
        accountLabel.setForeground(new Color(255, 200, 0));

        //密码设置
        passwordLabel1.setBounds(70,125,90,30);
        passwordLabel1.setFont(new Font("黑体",Font.BOLD,15));
        passwordLabel1.setForeground(new Color(255, 200, 0));

        //密码设置
        passwordLabel2.setBounds(70,160,90,30);
        passwordLabel2.setFont(new Font("黑体",Font.BOLD,15));
        passwordLabel2.setForeground(new Color(255, 200, 0));

        //用户名框
        accountText.setBounds(120, 95,150,20);

        //密码框
        passwordField1.setBounds(120, 130,150,20);
        passwordField2.setBounds(120, 165,150,20);

        //注册
        registerButton.setBounds(95, 220, 50, 20);
        registerButton.setMargin(new Insets(0,0,0,0));
        registerButton.addActionListener(event -> {
            String account = accountText.getText();
            String password1 = new String(passwordField1.getPassword());
            String password2 = new String(passwordField2.getPassword());
            int flag = registerControl.checkIn(account);
            if (flag == -1){
                JOptionPane.showMessageDialog(registerFrame, "你不是本专业学生，请联系姜老师");
            }else if (flag == 0){
                JOptionPane.showMessageDialog(registerFrame, "你已经注册过了，请联系姜老师查看密码");
            }else if (!password1.equals(password2)){
                JOptionPane.showMessageDialog(registerFrame, "密码两次不一致，请重新输入");
            }else if (flag == 1){
                LogControl logControl = new LogControl();
                logControl.log(account, "注册了该系统");
                JOptionPane.showMessageDialog(registerFrame, "注册成功");
                LoginService loginService = new LoginService();
                loginService.insert(new User(account, password1));
            }else {
                //冗余
                JOptionPane.showMessageDialog(registerFrame, "请输入信息！");
            }
        });

        //登录button
        loginButton.setBounds(200, 220, 80, 20);
        loginButton.setMargin(new Insets(0,0,0,0));
        loginButton.addActionListener(event -> {
            //这个方法不能在包外用，所以只能合到一个包里了
            loginFrame.setVisible(true);
            //发现下面的也可以，但是不想重构了
            //new LoginFrame();
            registerFrame.setVisible(false);
        });

        init();
    }

    /**
     * 添加组件并初始化
     */
    private void init(){

        setLayout(null);

        add(titleLabel);
        add(accountLabel);
        add(passwordLabel1);
        add(passwordLabel2);
        add(accountText);
        add(passwordField1);
        add(passwordField2);
        add(loginButton);
        add(registerButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(RegisterPanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 0, 0, 350, 340, this);
    }
}
