package view;

import control.InsertControl;
import control.LogControl;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zi10ng
 * @date 2019年6月7日11:22:37
 */
public class InsertPanel extends JPanel {

    private JButton insert = new JButton("插入");
    private JTextField textFieldId = new JTextField("");
    private JTextField textFieldName = new JTextField("");
    private JTextField textFieldJava = new JTextField("");
    private JTextField textFieldDb = new JTextField("");
    private JTextField textFieldCi = new JTextField("");
    private JComboBox selectSex = new JComboBox();
    private JComboBox selectClass = new JComboBox();
    private JLabel jLabelName = new JLabel("输入姓名");
    private JLabel jLabelId = new JLabel("输入账号");
    private JLabel jLabelSex = new JLabel("学生性别");
    private JLabel jLabelClass = new JLabel("学生班级");
    private JLabel jLabelJava = new JLabel("Java");
    private JLabel jLabelDb = new JLabel("数据库");
    private JLabel jLabelCi = new JLabel("计网");

    InsertPanel(){

        jLabelId.setBounds(50,40,70, 20);
        jLabelId.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelId.setForeground(new Color(255,200,0));

        textFieldId.setBounds(120, 40,80,20);

        jLabelName.setBounds(220,40,70, 20);
        jLabelName.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelName.setForeground(new Color(255,200,0));

        textFieldName.setBounds(290, 40,80,20);

        jLabelSex.setBounds(50,80,70, 20);
        jLabelSex.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelSex.setForeground(new Color(255,200,0));

        selectSex.setBounds(120, 80,80,20);
        //?
        selectSex.addItem("男");
        selectSex.addItem("女");
        selectSex.setVisible(true);

        jLabelClass.setBounds(220,80,70, 20);
        jLabelClass.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelClass.setForeground(new Color(255,200,0));

        selectClass.setBounds(290, 80,80,20);
        //?
        selectClass.addItem("一班");
        selectClass.addItem("二班");
        selectClass.setVisible(true);

        jLabelJava.setBounds(50,120,40, 20);
        jLabelJava.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelJava.setForeground(new Color(255,200,0));

        textFieldJava.setBounds(90, 120,50,20);

        jLabelDb.setBounds(160,120,50, 20);
        jLabelDb.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelDb.setForeground(new Color(255,200,0));

        textFieldDb.setBounds(210, 120,50,20);

        jLabelCi.setBounds(280,120,40, 20);
        jLabelCi.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelCi.setForeground(new Color(255,200,0));

        textFieldCi.setBounds(320, 120,50,20);

        insert.setBounds(180,170,70,30);
        insert.setMargin(new Insets(0,0,0,0));
        insert.addActionListener(e -> {
            String id = textFieldId.getText();
            String name = textFieldName.getText();
            String sex = selectSex.getSelectedItem().toString();
            String clas = selectClass.getSelectedItem().toString();
            String java = textFieldJava.getText();
            String db = textFieldDb.getText();
            String ci = textFieldCi.getText();
            InsertControl insertControl = new InsertControl();
            int flag = insertControl.insert(id,name,sex,clas,java,db,ci);
            if (flag == 0){
                JOptionPane.showMessageDialog(this,
                        "不能为空，请检查输入！");
            }else if (flag == -1){
                JOptionPane.showMessageDialog(this,
                        "存在该id，请检查输入！");
            }else if (flag == -2){
                JOptionPane.showMessageDialog(this,
                        "成绩不能大于100分，请检查输入！");
            }else if (flag == 2){
                JOptionPane.showMessageDialog(this,
                        "成绩只能是整数，请检查输入！");
            } else {
                LogControl logControl = new LogControl();
                logControl.log("root", "插入了" + id);
                JOptionPane.showMessageDialog(this, "插入成功！");
            }

        });

        init();
    }

    private void init(){
        setLayout(null);
        setVisible(true);
        add(jLabelId);
        add(jLabelName);
        add(jLabelSex);
        add(jLabelClass);
        add(jLabelJava);
        add(jLabelDb);
        add(jLabelCi);
        add(textFieldId);
        add(textFieldName);
        add(textFieldJava);
        add(textFieldDb);
        add(textFieldCi);
        add(selectSex);
        add(selectClass);
        add(insert);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(InsertPanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 0, 0, 475, 250, this);
    }
}
