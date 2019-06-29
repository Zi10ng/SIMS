package view;

import control.LogControl;
import control.RegisterControl;
import model.service.LoginService;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zi10ng
 * @date 2019年6月7日18:39:45
 */
public class UpdatePasswordPanel extends JPanel {
    private JButton update = new JButton("更改");
    private JTextField textFieldId = new JTextField(LoginPanel.account);
    private JPasswordField textFieldPass = new JPasswordField();
    private JPasswordField textFieldWord = new JPasswordField();
    private JLabel jLabelId = new JLabel("ID");
    private JLabel jLabelAttribute = new JLabel("更改密码");
    private JLabel jLabelValue = new JLabel("确认密码");

    UpdatePasswordPanel(){

        jLabelId.setBounds(40,40,70, 20);
        jLabelId.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelId.setForeground(new Color(255,200,0));

        textFieldId.setBounds(70, 40,80,20);

        jLabelAttribute.setBounds(170,40,70, 20);
        jLabelAttribute.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelAttribute.setForeground(new Color(255,200,0));

        textFieldPass.setBounds(245,40,80,20);

        jLabelValue.setBounds(345,40,70, 20);
        jLabelValue.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelValue.setForeground(new Color(255,200,0));

        textFieldWord.setBounds(425, 40,80,20);


        update.setBounds(200,80,100,20);
        update.setMargin(new Insets(0,0,0,0));
        update.addActionListener(e -> {
            RegisterControl registerControl = new RegisterControl();
            String id = textFieldId.getText();
            String key = new String(textFieldPass.getPassword());
            String value = new String(textFieldWord.getPassword());
            int flag = registerControl.checkIn(id);
            if (!LoginPanel.root.equals(LoginPanel.account) && !id.equals(LoginPanel.account)) {
                JOptionPane.showMessageDialog(this, "你只能修改自己的密码！");
            } else if ( !key.equals(value)){
                JOptionPane.showMessageDialog(this, "两次密码不一致，请检查输入");
            }else if ( flag != 0){
                JOptionPane.showMessageDialog(this, "该ID没有注册");
            }else {
                LoginService loginService = new LoginService();
                loginService.update(id,key);
                JOptionPane.showMessageDialog(this, "修改成功，请重新查看");
                LogControl logControl = new LogControl();
                logControl.log("root", "修改了" + id + "的密码"  + "为" + value);
            }
        });

        init();
    }

    private void init(){
        setLayout(null);
        setVisible(true);
        add(jLabelId);
        add(jLabelAttribute);
        add(jLabelValue);
        add(textFieldId);
        add(textFieldPass);
        add(textFieldWord);
        add(update);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(UpdatePasswordPanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 0, 0, 550, 200, this);
    }
}
