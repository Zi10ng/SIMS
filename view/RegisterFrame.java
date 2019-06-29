package view;

import javax.swing.*;

/**
 * 注册界面
 * @author Zi10ng
 * @date 2019年6月4日21:10:03
 */
public class RegisterFrame extends JFrame {
    public RegisterFrame(){
        add(new RegisterPanel());
        init();
    }
    /**
     * 初始化Frame结构
     */
    private void init(){

        setTitle("注册 @乙木(stonee.club)");
        //把这个窗体移到其他窗口前面
        toFront();
        setLocation(500,200);
        setSize(350,340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置大小不可拖拽
        setResizable(false);
        setIconImage(new ImageIcon(RegisterFrame.class.getResource("/").getPath() + "//file//image//icon.jpg").getImage());
        setVisible(true);
    }
}
