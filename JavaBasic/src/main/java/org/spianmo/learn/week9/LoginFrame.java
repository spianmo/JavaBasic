package org.spianmo.learn.week9;

import org.spianmo.learn.week9.entity.User;
import org.spianmo.learn.week9.service.Impl.LoginServiceImpl;
import org.spianmo.learn.week9.service.Impl.callback.OnLoginCallback;
import org.spianmo.learn.week9.service.LoginService;
import org.springframework.util.DigestUtils;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @ClassName LoginFrame
 * @Description TODO
 * @Author Finger
 * @Date 11/9/2020
 **/
public class LoginFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel topPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    private JPanel logoPanel;
    private JPanel formPanel;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginButton;


    public LoginFrame() {
        initComponent();
        LoginService loginService = new LoginServiceImpl();
        loginButton.addActionListener(e -> {
            String username = userNameField.getText();
            char[] password = passwordField.getPassword();
            loginService.login(username, DigestUtils.md5DigestAsHex(String.valueOf(password).getBytes()), new OnLoginCallback() {
                @Override
                public void onSuccess(User user) {
                    JOptionPane.showMessageDialog(null, "登录成功："+user);
                    LoginFrame.this.dispose();
                }

                @Override
                public void onFailure(String errMsg) {
                    JOptionPane.showMessageDialog(null, "登录失败：" + errMsg);
                }
            });
        });
    }

    public void initComponent() {
        userNameField.setBorder(new RoundBorder(Color.LIGHT_GRAY));
        passwordField.setBorder(new RoundBorder(Color.LIGHT_GRAY));
        loginButton.setBorder(new RoundBorder(Color.LIGHT_GRAY));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LoginFrame");
        frame.setContentPane(new LoginFrame().mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }
}
