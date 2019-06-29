package view;


import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *  滚动panel，这个主要是为了设置位置和背景图片（好像图片没什么用）
 * @author Zi10ng
 * @date 2019年6月6日12:40:17
 */
class AdminScrollPane extends JScrollPane {


    AdminScrollPane(JTable jTable){
        super(jTable);
        init();
    }

    private void init(){
        setBounds(80, 35, 520 , 280);
        setForeground(new Color(255, 251, 199));
        setBackground(new Color(21, 20, 99));
        //setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(AdminScrollPane.class.getResource("/").getPath()  + "//file//image//background2.jpg").getImage(), 0, 0, 700, 450, this);
    }
}
