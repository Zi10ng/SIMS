package view;

import control.LogControl;
import control.UpdateControl;


import javax.swing.*;
import java.awt.*;


/**
 * @author Zi10ng
 * @date 2019年6月7日13:59:07
 */
public class UpdatePanel extends JPanel {
    private JButton update = new JButton("更改");
    private JTextField textFieldId = new JTextField(AdminButtonPanel.updateId);
    private JComboBox selectAttribute = new JComboBox();
    private JTextField textFieldValue = new JTextField();
    private JLabel jLabelId = new JLabel("ID");
    private JLabel jLabelAttribute = new JLabel("更改属性");
    private JLabel jLabelValue = new JLabel("更改值");

    UpdatePanel(){

        jLabelId.setBounds(15,40,70, 20);
        jLabelId.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelId.setForeground(new Color(255,200,0));

        textFieldId.setBounds(85, 40,80,20);

        jLabelAttribute.setBounds(185,40,70, 20);
        jLabelAttribute.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelAttribute.setForeground(new Color(255,200,0));

        selectAttribute.setBounds(255, 40,80,20);
        //?
        selectAttribute.addItem("姓名");
        selectAttribute.addItem("性别");
        selectAttribute.addItem("班级");
        selectAttribute.addItem("Java");
        selectAttribute.addItem("数据库");
        selectAttribute.addItem("计网");
        selectAttribute.setVisible(true);

        jLabelValue.setBounds(355,40,70, 20);
        jLabelValue.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelValue.setForeground(new Color(255,200,0));

        textFieldValue.setBounds(425, 40,80,20);


        update.setBounds(200,80,100,20);
        update.setMargin(new Insets(0,0,0,0));
        update.addActionListener(e -> {
            UpdateControl updateControl = new UpdateControl();
            String id = textFieldId.getText();
            String attribute = selectAttribute.getSelectedItem().toString();
            String value = textFieldValue.getText();
            int flag = updateControl.update(id,attribute,value);
            if ( flag == 1){
                JOptionPane.showMessageDialog(this, "修改成功，请刷新查看");
                LogControl logControl = new LogControl();
                logControl.log("root", "修改了" + id + "的" + attribute + "为" + value);
            }else if (flag == 0){
                JOptionPane.showMessageDialog(this, "性别班级格式不正确，请查看帮助手册");
            }else if (flag == 3){
                JOptionPane.showMessageDialog(this, "成绩必须是正整数");
            }else if (flag == 2){
                JOptionPane.showMessageDialog(this, "成绩必须要小于100");
            }else if (flag == -1){
                JOptionPane.showMessageDialog(this, "请填写完整信息");
            }else if (flag == -2){
                JOptionPane.showMessageDialog(this, "学号不存在");
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
        add(selectAttribute);
        add(textFieldValue);
        add(update);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(UpdateFrame.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 0, 0, 550, 200, this);
    }
}
