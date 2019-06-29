package view;

import javax.swing.*;

/**
 * @author Zi10ng
 * @date 2019年6月7日18:38:10
 */
class UpdatePasswordFrame extends JFrame{
    UpdatePasswordFrame(){
        add(new UpdatePasswordPanel());
        init();
    }
    private void init(){
        setTitle("修改密码 @乙木(stonee.club)");
        //把这个窗体移到其他窗口前面
        toFront();
        setLocation(425,280);
        setSize(540,150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置大小不可拖拽
        setResizable(false);
        setIconImage(new ImageIcon(UpdatePasswordFrame.class.getResource("/").getPath() + "//file//image//icon.jpg").getImage());
        setVisible(true);
    }
}
