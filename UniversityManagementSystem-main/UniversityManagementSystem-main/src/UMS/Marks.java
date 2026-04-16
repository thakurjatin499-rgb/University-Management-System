package UMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
    String roll;
    JButton can;
    Marks(String roll){
        this.roll= roll;

        setSize(500, 600);
        setLocation(400, 50);
        setTitle("Result");
        setLayout(null);

        getContentPane().setBackground(new Color(210, 252, 248));

        JLabel heading = new JLabel("KIIT Univeristy");
        heading.setBounds(150, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Semester Grade Report");
        subheading.setBounds(130, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number " + roll);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);

        try {
            Conn c = new Conn();

            ResultSet rs1 = c.st.executeQuery("select * from subject where Roll = '"+roll+"'");
            while(rs1.next()) {
                sub1.setText(rs1.getString("sub1"));
                sub2.setText(rs1.getString("sub2"));
                sub3.setText(rs1.getString("sub3"));
                sub4.setText(rs1.getString("sub4"));
                sub5.setText(rs1.getString("sub5"));
            }

            ResultSet rs2 = c.st.executeQuery("select * from marks where Roll = '"+roll+"'");
            while(rs2.next()) {
                sub1.setText(sub1.getText() + "  " + rs2.getString("m1"));
                sub2.setText(sub2.getText() + "  " + rs2.getString("m2"));
                sub3.setText(sub3.getText() + "  " + rs2.getString("m3"));
                sub4.setText(sub4.getText() + "  " + rs2.getString("m4"));
                sub5.setText(sub5.getText() + "  " + rs2.getString("m5"));
                lblsemester.setText("Semester " + rs2.getString("Sem"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        can = new JButton("Back");
        can.setBounds(250, 500, 120, 25);
        can.setBackground(Color.BLACK);
        can.setForeground(Color.WHITE);
        can.addActionListener(this);
        can.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(can);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Marks("22054888");
    }
}
