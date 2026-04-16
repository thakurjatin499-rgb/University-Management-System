package UMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice choiceRoll;
    JComboBox Tsem;
    JTextField sub1, sub2, sub3, sub4, sub5, m1, m2, m3, m4, m5;
    JButton sub,can;

    EnterMarks(){
       setSize(1000,500);
       setLocation(150,100);
       setLayout(null);
       setTitle("Marks");
       getContentPane().setBackground(new Color(252,245,210));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("UMS/icons/em.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(650,100,200,200);
        add(img);

       JLabel head = new JLabel("Enter Marks");
       head.setBounds(50,10,500,50);
       head.setFont(new Font("Tahoma",Font.BOLD,30));
       add(head);

        JLabel roll = new JLabel("Select Roll Number");
        roll.setBounds(50,80,150,20);
        add(roll);

        choiceRoll = new Choice();
        choiceRoll.setBounds(200,80,150,20);
        choiceRoll.add("Select");
        add(choiceRoll);

        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from student");
            while(rs.next()){
                choiceRoll.add(rs.getString("Roll"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        JLabel sem = new JLabel("Select Semester");
        sem.setBounds(50,120,150,20);
        add(sem);

        String[] semester = {"Select","1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        Tsem = new JComboBox(semester);
        Tsem.setBounds(200,120,150,20);
        Tsem.setBackground(Color.white);
        add(Tsem);

        JLabel entersub = new JLabel("Enter Subject");
        entersub.setBounds(100,160,200,40);
        add(entersub);

        JLabel entermarks = new JLabel("Enter Marks");
        entermarks.setBounds(320,160,200,40);
        add(entermarks);

        sub1 = new JTextField();
        sub1.setBounds(50,210,200,20);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(50,240,200,20);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(50,270,200,20);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(50,300,200,20);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(50,330,200,20);
        add(sub5);

        m1 = new JTextField();
        m1.setBounds(280,210,200,20);
        add(m1);

        m2 = new JTextField();
        m2.setBounds(280,240,200,20);
        add(m2);

        m3 = new JTextField();
        m3.setBounds(280,270,200,20);
        add(m3);

        m4 = new JTextField();
        m4.setBounds(280,300,200,20);
        add(m4);

        m5 = new JTextField();
        m5.setBounds(280,330,200,20);
        add(m5);

        sub = new JButton("Submit");
        sub.setBounds(70,380,150,25);
        sub.setBackground(Color.black);
        sub.setForeground(Color.white);
        sub.addActionListener(this);
        add(sub);

        can = new JButton("Exit");
        can.setBounds(280,380,150,25);
        can.setBackground(Color.black);
        can.setForeground(Color.white);
        can.addActionListener(this);
        add(can);

       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == sub){
            try{
                Conn c = new Conn();
                String q1 = "insert into subject values('"+choiceRoll.getSelectedItem()+"','"+Tsem.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                String q2 = "insert into marks values('"+choiceRoll.getSelectedItem()+"','"+Tsem.getSelectedItem()+"','"+m1.getText()+"','"+m2.getText()+"','"+m3.getText()+"','"+m4.getText()+"','"+m5.getText()+"')";
                c.st.executeUpdate(q1);
                c.st.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new EnterMarks();
    }

}
