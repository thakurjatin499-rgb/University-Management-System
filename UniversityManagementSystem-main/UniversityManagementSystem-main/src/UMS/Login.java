package UMS;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
    JTextField nameField;
    JPasswordField passwordField;
    JButton login, back;
    Login(){
        setSize(600,300);
        setLocation(250,150);
        setTitle("SAP Portal");
        setLayout(null);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(40,20,100,20);
        add(l1);

        nameField = new JTextField();
        nameField.setBounds(150,20,150,20);
        add(nameField);

        JLabel l2 = new JLabel("Enter password");
        l2.setBounds(40,70,100,20);
        add(l2);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,20);
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(180,140,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("UMS/icons/label.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("UMS/icons/bg.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img2 = new JLabel(i33);
        img2.setBounds(0,0,600,300);
        add(img2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = nameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            try{
                Conn obj = new Conn();
                ResultSet resultS = obj.st.executeQuery(query);
                if(resultS.next()){
                    setVisible(false);
                    new Main_class();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}

