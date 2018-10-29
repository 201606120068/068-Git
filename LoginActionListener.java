package LoginActionThing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

public class LoginActionListener implements ActionListener{
    private ActionEvent e;
    public JTextField text01;
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JFrame frame01 = new JFrame();
        JButton btnSaveinFormation=new JButton("确定保存用户");
        btnSaveinFormation.addActionListener(this::saveuserinformation);
        frame01.setTitle("用户登录");
        frame01.setBounds(450, 200, 400, 150);
        Container content01 = frame01.getContentPane();
        JPanel panel = new JPanel();
        JPanel panel01 = new JPanel();
        JPanel panel02 = new JPanel();

        JLabel label01 = new JLabel("请输入用户名: ");
        JLabel label02 = new JLabel("请输入密码:      ");
        text01 = new JTextField(20);
        JPasswordField text02 = new JPasswordField(20);
        panel01.add(label01);
        panel01.add(text01);
        panel02.add(label02);
        panel02.add(text02);
        panel.add(panel01);
        panel.add(panel02);
        panel.add(btnSaveinFormation);
        content01.add(panel,BorderLayout.CENTER);
        //frame01.pack();
        frame01.setVisible(true);


        frame01.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               frame01.isDisplayable();
            }
        });


    }

    public String getusername(JTextField text01)
    {
       String name;
       name=text01.getText();
        return  name;
    }

    private void saveuserinformation(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "保存信息成功！");
       // this.setVisible(false);
    }



}
