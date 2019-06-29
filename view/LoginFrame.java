package view;



import javax.swing.*;
import java.io.File;


/**
 * 登录主界面
 * @author Zi10ng
 * @date 2019年6月4日09:30:07
 */
public class LoginFrame extends JFrame {

    LoginFrame(){

        add(new LoginPanel());
        init();
    }

    /**
     * 初始化Frame结构
     */
    private void init(){
        setTitle("登录 @乙木(stonee.club)");
        //把这个窗体移到其他窗口前面
        toFront();
        setLocation(400,200);
        setSize(560,340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(LoginFrame.class.getResource("/").getPath());
        //设置大小不可拖拽
        setResizable(false);
        setIconImage(new ImageIcon(LoginFrame.class.getResource("/").getPath()+ "//file//image//icon.jpg").getImage());
        try {
            UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[3].getClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

}
