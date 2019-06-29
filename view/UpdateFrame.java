package view;

import javax.swing.*;

/**
 * @author Zi10ng
 * @date 2019年6月7日13:59:23
 */
class UpdateFrame extends JFrame {
    UpdateFrame(){
        add(new UpdatePanel());
        init();
    }
    private void init(){
        setTitle("更改 @乙木(stonee.club)");
        //把这个窗体移到其他窗口前面
        toFront();
        setLocation(425,280);
        setSize(540,150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置大小不可拖拽
        setResizable(false);
        setIconImage(new ImageIcon(UpdateFrame.class.getResource("/").getPath() + "//file//image//icon.jpg").getImage());
        setVisible(true);
    }
}

