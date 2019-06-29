package view;

import javax.swing.*;
import java.io.File;


/**
 * @author Zi10ng
 * @date 2019年6月5日17:25:51
 */
public class DeleteFrame extends JFrame {
    DeleteFrame(){
        add(new DeletePanel());
        init();
    }
    private void init(){
        setTitle("删除 @乙木(stonee.club)");
        //把这个窗体移到其他窗口前面
        toFront();
        setLocation(425,280);
        setSize(540,150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置大小不可拖拽
        setResizable(false);
        setIconImage(new ImageIcon(DeleteFrame.class.getResource("/").getPath()  + "//file//image//icon.jpg").getImage());
        setVisible(true);
    }
}
