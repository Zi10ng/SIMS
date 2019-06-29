package view;

import control.LogControl;
import control.QueryMoreControl;
import model.domin.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static view.AdminButtonPanel.queryFrame;
import static view.QueryFrame.queryIdPanel;
import static view.QueryIdPanel.queryMorePanel;

/**
 * 多条件查询panel
 * @author Zi10ng
 * @date 2019年6月6日23:01:07
 */
public class QueryMorePanel extends JPanel {

    private JButton query = new JButton("按ID查询");
    private JTextField textFieldName = new JTextField("(可选)");
    private JComboBox selectSex = new JComboBox();
    private JComboBox selectClass = new JComboBox();
    private JLabel jLabelName = new JLabel("输入姓名");
    private JLabel jLabelSex = new JLabel("学生性别");
    private JLabel jLabelClass = new JLabel("学生班级");
    private JButton trans = new JButton("多条件查询");

    QueryMorePanel(){

        jLabelName.setBounds(15,40,70, 20);
        jLabelName.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelName.setForeground(new Color(255,200,0));

        textFieldName.setBounds(85, 40,80,20);

        jLabelSex.setBounds(185,40,70, 20);
        jLabelSex.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelSex.setForeground(new Color(255,200,0));

        selectSex.setBounds(255, 40,80,20);
        //?
        selectSex.addItem("(可选)");
        selectSex.addItem("男");
        selectSex.addItem("女");
        selectSex.setVisible(true);

        jLabelClass.setBounds(355,40,70, 20);
        jLabelClass.setFont(new Font("黑体",Font.BOLD, 15));
        jLabelClass.setForeground(new Color(255,200,0));

        selectClass.setBounds(425, 40,80,20);
        //?
        selectClass.addItem("(可选)");
        selectClass.addItem("一班");
        selectClass.addItem("二班");
        selectClass.setVisible(true);

        trans.setBounds(150,80,100,20);
        trans.setMargin(new Insets(0,0,0,0));
        trans.addActionListener( e -> {
            QueryMoreControl queryMoreControl = new QueryMoreControl();
            TableUlit tableUlit = new TableUlit();
            ArrayList<Student> students = queryMoreControl.queryMore(textFieldName.getText(),selectSex.getSelectedItem().toString(),selectClass.getSelectedItem().toString());
            if ( students == null){
                //此处students不能为空？
                JOptionPane.showMessageDialog(this, "不存在该学生，请检查输入！");
            }else {
                tableUlit.setTable(students);
                LogControl logControl = new LogControl();
                logControl.log(LoginPanel.account,"进行了多条件的查询");
            }
        });

        query.setBounds(260,80,100,20);
        query.setMargin(new Insets(0,0,0,0));
        query.addActionListener(e -> {
            queryIdPanel = new QueryIdPanel();
            queryFrame.add(queryIdPanel);
            queryMorePanel.setVisible(false);
            queryFrame.remove(queryMorePanel);
        });

        init();
    }

    private void init(){
        setLayout(null);
        setVisible(true);
        add(jLabelName);
        add(jLabelSex);
        add(jLabelClass);
        add(textFieldName);
        add(selectSex);
        add(selectClass);
        add(query);
        add(trans);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(QueryMorePanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 0, 0, 550, 200, this);
    }
}
