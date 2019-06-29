package view;

import javax.swing.*;
import java.io.File;

/**
 * @author Zi10ng
 * @date 2019年6月7日11:21:23
 */
public class InsertFrame extends JFrame {
    public InsertFrame() {
        add(new InsertPanel());
        init();
    }

    private void init() {
        setTitle("增加 @乙木(stonee.club)");
        //把这个窗体移到其他窗口前面
        toFront();
        setLocation(460, 235);
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置大小不可拖拽
        setResizable(false);
        setIconImage(new ImageIcon(InsertFrame.class.getResource("/").getPath() + "//file//image//icon.jpg").getImage());
        setVisible(true);
    }
}
