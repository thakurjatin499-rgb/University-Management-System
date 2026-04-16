package UMS;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);
        setTitle("About");

        JLabel heading = new JLabel("University Management System");
        heading.setBounds(70, 120, 550, 130);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Developed By: Devna Sharma & Isha");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("serif", Font.BOLD, 30));
       add(name);

        setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}

