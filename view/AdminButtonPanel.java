package view;

import control.LogControl;
import control.TableControl;
import model.service.LoginService;
import model.service.StudentService;

import javax.swing.*;
import java.awt.*;

import static view.AdminPanel.jTable;

/**
 * @author Zi10ng
 * @date 2019年6月6日14:19:00
 */
class AdminButtonPanel extends JPanel {

    static DeleteFrame deleteFrame;
    static QueryFrame queryFrame;
    static String updateId = "";
    private JButton delete = new JButton("删除");
    private JButton insert = new JButton("增加");
    private JButton query = new JButton("查找");
    private JButton update = new JButton("修改");
    private JButton flash = new JButton("刷新");
    private StudentService studentService = new StudentService();
    private LoginService loginService = new LoginService();
    private TableUlit tableUlit = new TableUlit();
    AdminButtonPanel(){

        query.setBounds(60,15,35,20);
        query.setMargin(new Insets(0,0,0,0));
        query.addActionListener(e ->
                EventQueue.invokeLater(() ->
                        queryFrame = new QueryFrame()
                )
        );

        delete.setBounds(150,15,35,20);
        delete.setMargin(new Insets(0,0,0,0));
        delete.addActionListener( e -> {
            int [] index = jTable.getSelectedRows();
            int flag = TableControl.rowCounts;
            //此处吊
            if (index.length == 0 || flag <= index[0]){
                EventQueue.invokeLater(() ->
                        deleteFrame = new DeleteFrame());
            }else {

                LogControl logControl = new LogControl();
                String id = jTable.getValueAt(index[0], 0).toString();
                String name = studentService.query(id).getName();
                //先询问
                int res;
                res=JOptionPane.showConfirmDialog(null,"你确定要删除" + name,
                        "删除学生",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                //再删除
                if(res==JOptionPane.YES_OPTION) {
                    studentService.delete(id);
                    loginService.delete(id);
                    logControl.log("root", "删除了" + id);
                    JOptionPane.showMessageDialog(this, "已将" + name + "删除，TA不能登录该系统并查阅成绩");
                }
            }
        });

        insert.setBounds(240,15,35,20);
        insert.setMargin(new Insets(0,0,0,0));
        insert.addActionListener(e ->
            EventQueue.invokeLater(InsertFrame::new));

        update.setBounds(330,15,35,20);
        update.setMargin(new Insets(0,0,0,0));
        update.addActionListener( e -> {
            int[] index = jTable.getSelectedRows();
            int flag = TableControl.rowCounts;
            if (index.length != 0 && flag > index[0]) {
                updateId = jTable.getValueAt(index[0], 0).toString();
           }else{
                updateId = "";
            }
            EventQueue.invokeLater(UpdateFrame::new);
        });

        flash.setBounds(420,15,35,20);
        flash.setMargin(new Insets(0,0,0,0));
        flash.addActionListener( e ->
            tableUlit.setTable()
        );
        init();
    }
    private void init(){
        setLayout(null);
        setBounds(80, 320, 520 , 50);
        if (LoginPanel.root.equals(LoginPanel.account)) {
            add(insert);
            add(delete);
            add(update);
        }
        add(query);
        add(flash);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(AdminButtonPanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), 80, 320, 520, 50, this);
    }
}
