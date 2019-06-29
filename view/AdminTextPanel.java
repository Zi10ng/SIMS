package view;

import javax.swing.*;
import java.awt.*;

/**
 * 用于展示文本信息，和滚动pane替换
 * 主要用于显示日志，手册，等
 * @author Zi10ng
 * @date 2019年6月7日14:59:31
 */
class AdminTextPanel extends JScrollPane {

    AdminTextPanel(JTextArea jTextArea){
        super(jTextArea);
        jTextArea.setBounds(80, 35, 520 , 320);
        jTextArea.setFont(new Font("幼圆", Font.PLAIN, 12));
        jTextArea.setLineWrap(true);
        jTextArea.setEnabled(false);
        jTextArea.setBackground(new Color(21, 20, 99));
        jTextArea.setDisabledTextColor(new Color(255, 251, 199));
        init();
    }
    private void init(){
        setBounds(80, 35, 520 , 320);
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(AdminTextPanel.class.getResource("/").getPath() + "//file//image//background2.jpg").getImage(), -80, -35, 700, 450, this);
    }
}
