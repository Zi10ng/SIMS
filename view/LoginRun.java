package view;

import java.awt.*;

/**
 * 登录主界面
 * @author Zi10ng
 * @date 2019年6月4日09:26:42
 */
public class LoginRun {
    static LoginFrame loginFrame;
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
            loginFrame = new LoginFrame());
    }
}
