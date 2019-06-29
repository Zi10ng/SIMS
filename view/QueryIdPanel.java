package view;

import control.LogControl;
import model.domin.Student;
import model.service.StudentService;

import javax.swing.*;
import java.awt.*;

import static view.AdminButtonPanel.queryFrame;
import static view.QueryFrame.queryIdPanel;

/**
 * 目前UI未构思好，先不写
 * 2019年6月6日21:32:03构思好了
 * @author Zi10ng
 * @date 2019年6月6日19:58:46
 */

public class QueryIdPanel extends JPanel {

    static QueryMorePanel queryMorePanel;
    private JButton query = new JButton("按ID查询");
    private JTextField textField = new JTextField();
    private JLabel jLabel = new JLabel("请输入查询学生ID");
    private JButton trans = new JButton("多条件查询");

    QueryIdPanel(){

        StudentService studentService = new StudentService();

        jLabel.setBounds(100,40,150, 20);
        jLabel.setFont(new Font("黑体",Font.BOLD, 15));
        jLabel.setForeground(new Color(255,200,0));

        textField.setBounds(250, 40,160,20);

        trans.setBounds(150,80,100,20);
        trans.setMargin(new Insets(0,0,0,0));
        trans.addActionListener( e -> {
            //切换panel
            queryMorePanel = new QueryMorePanel();
            queryFrame.add(queryMorePanel);
            queryIdPanel.setVisible(false);
            queryFrame.remove(queryIdPanel);
        });

        query.setBounds(260,80,100,20);
        query.setMargin(new Insets(0,0,0,0));
        query.addActionListener(e -> {
            String id = textField.getText();
            Student student =studentService.query(id);
            if (student == null){
                JOptionPane.showMessageDialog(this, "不存在该学生，请检查输入！");
            }else {
                AdminPanel.tableUlit.setTable(student);
                LogControl logControl = new LogControl();
                logControl.log(LoginPanel.account,"查询了" + id + "的成绩");
            }
        });

    init();
}

    private void init(){
        setLayout(null);
        add(jLabel);
        add(textField);
        add(query);
        add(trans);
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(QueryIdPanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 0, 0, 550, 200, this);
    }
}
