package view;

import control.LogControl;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static view.LoginPanel.account;

/**
 * 管理员界面
 * @author Zi10ng
 * @date 2019年6月5日08:32:52
 */
public class AdminFrame extends JFrame {

    public AdminFrame(){

        add(new AdminPanel());
        //add(new AdminMenuBar());
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                LogControl logControl = new LogControl();
                logControl.log(account, "退出了系统" );
            }
        });
        init();
    }

    /**
     * 初始化Frame结构
     */
    private void init(){
        setTitle("郑州大学17软卓成绩管理系统 @乙木(stonee.club)");
        //把这个窗体移到其他窗口前面
        toFront();
        setLocation(350,150);
        setSize(700,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小不可拖拽
        setResizable(false);
        setIconImage(new ImageIcon(AdminFrame.class.getResource("/").getPath() + "//file//image//icon.jpg").getImage());
        setJMenuBar(new AdminMenuBar());
        setVisible(true);
    }
}
