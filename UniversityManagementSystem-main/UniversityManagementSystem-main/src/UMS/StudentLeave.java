package UMS;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentLeave extends JFrame implements ActionListener{
    Choice choiceroll, choiceT;
    JDateChooser fdate,tdate;
    JButton sub,can;
    StudentLeave() {
        getContentPane().setBackground(new Color(128,176,255));
        setSize(500,550);
        setLocation(400,100);
        setLayout(null);
        setTitle("Student Leave");
        setVisible(true);

        JLabel head = new JLabel("Apply Leave");
        head.setBounds(175,30,300,30);
        head.setFont(new Font("Tahoma", Font.BOLD,20));
        add(head);

        JLabel roll = new JLabel("Select Roll Number");
        roll.setBounds(60,100,200,20);
        roll.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(roll);

        choiceroll = new Choice();
        choiceroll.setBounds(60,130,200,20);
        choiceroll.add("Select");
        add(choiceroll);

        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from student");
            while(rs.next()){
                choiceroll.add(rs.getString("Roll"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        JLabel from = new JLabel("Leave starts");
        from.setBounds(60,180,200,20);
        from.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(from);

        fdate = new JDateChooser();
        fdate.setBounds(60,210,200,20);
        add(fdate);

        JLabel to = new JLabel("Leave ends");
        to.setBounds(60,240,200,20);
        to.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(to);

        tdate = new JDateChooser();
        tdate.setBounds(60,270,200,20);
        add(tdate);

        JLabel duration = new JLabel("Duration");
        duration.setBounds(60,300,200,20);
        duration.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(duration);

        choiceT = new Choice();
        choiceT.setBounds(60,330,200,20);
        choiceT.add("Select");
        choiceT.add("Full Day");
        choiceT.add("Half Day");
        add(choiceT);

        sub = new JButton("Submit");
        sub.setBounds(60,390,100,25);
        sub.setBackground(Color.black);
        sub.setForeground(Color.white);
        sub.addActionListener(this);
        add(sub);

        can = new JButton("Exit");
        can.setBounds(200,390,100,25);
        can.setBackground(Color.black);
        can.setForeground(Color.white);
        can.addActionListener(this);
        add(can);

    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== sub){
           String roll = choiceroll.getSelectedItem();
           String from = ((JTextField) fdate.getDateEditor().getUiComponent()).getText();
           String to = ((JTextField) tdate.getDateEditor().getUiComponent()).getText();
           String duration = choiceT.getSelectedItem();
           String q = "insert into StudentLeave value('"+roll+"','"+from+"','"+to+"','"+duration+"')";

           try{
               Conn c = new Conn();
               c.st.executeUpdate(q);
               JOptionPane.showMessageDialog(null,"Leave Submitted");
               setVisible(false);
           }catch(Exception E){
               E.printStackTrace();
           }
       }else{
           setVisible(false);
       }
    }

    public static void main(String[] args){
        new StudentLeave();
    }
}
