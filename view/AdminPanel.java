package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


/**
 * 管理员panel
 * @author Zi10ng
 * @date 2019年6月5日08:32:52
 */
class AdminPanel extends JPanel {

    static JTable jTable;
    static JTable jUserTable;
    static DefaultTableModel model = new DefaultTableModel();
    static DefaultTableModel modelUser = new DefaultTableModel();
    static AdminButtonPanel adminButtonPanel;
    static AdminScrollPane adminScrollPane;
    static AdminScrollPane adminScrollPaneUser;
    static AdminTextPanel adminTextPanel;
    static AnalysisPanel analysisPanel;

    static JTextArea jTextArea = new JTextArea();
    static TableUlit tableUlit = new TableUlit();

    /**
     * 该构造方法中添加了一个滚动panel
     */
    AdminPanel(){
        init();

        add(adminScrollPane = new AdminScrollPane(jTable));
        add(adminButtonPanel = new AdminButtonPanel());
        add(adminTextPanel = new AdminTextPanel(jTextArea));
        add(adminScrollPaneUser = new AdminScrollPane(jUserTable));
        add(analysisPanel = new AnalysisPanel());
        analysisPanel.setVisible(false);
        adminTextPanel.setVisible(false);
        adminScrollPaneUser.setVisible(false);
    }
    private void init(){
        setJTable();
        setJUserTable();
        setLayout(null);
    }
    private void setJTable() {
        jTable = new JTable(model) {
            //设置表格不可更改
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableUlit.setTable();
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.setFont(new Font("幼圆", Font.PLAIN, 12));
        jTable.setForeground(new Color(255, 251, 199));
        jTable.setBackground(new Color(21, 20, 99));
        jTable.setSelectionBackground(new Color(255, 150, 98));
    }
    private void setJUserTable(){
        jUserTable = new JTable(modelUser){
            //设置表格不可更改
            @Override
            public boolean isCellEditable(int row, int column) {
                    return false;
                }
        };
        tableUlit.setTableUser();
        jUserTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jUserTable.setFont(new Font("幼圆",Font.PLAIN, 12));
        jUserTable.setForeground(new Color(255, 251, 199));
        jUserTable.setBackground(new Color(21, 20, 99));
        jUserTable.setSelectionBackground(new Color(255, 150, 98));
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon(AdminPanel.class.getResource("/").getPath()  + "//file//image//background2.jpg").getImage(), 0, 0, 700, 450, this);
    }
}
