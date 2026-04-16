package UMS;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField TextAddress,TextEmail,TextCourse,TextBranch;
    JFormattedTextField TextPhone;
    JButton Submit,Cancel;
    JLabel TextRoll,TextAadhar;
    Choice choiceRoll;
    MaskFormatter formatter,formatter2;

    UpdateStudent(){
        setTitle("Update Student Information");
        setSize(900,600);
        setLocation(200,50);
        setLayout(null);
        getContentPane().setBackground(new Color(128,176,255));

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel empid = new JLabel("Select Roll Number");
        empid.setBounds(50,100,200,20);
        empid.setFont(new Font("serif", Font.PLAIN,20));
        add(empid);

        choiceRoll = new Choice();
        choiceRoll.setBounds(250,100,200,20);
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

        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel TextName = new JLabel();
        TextName.setBounds(200,150,200,30);
        add(TextName);

        //Father's Name
        JLabel FName = new JLabel("Father's Name");
        FName.setBounds(450,150,180,30);
        FName.setFont(new Font("serif",Font.BOLD,20));
        add(FName);

        JLabel TextFName = new JLabel();
        TextFName.setBounds(600,150,200,30);
        add(TextFName);

        //Employee id
        JLabel EName = new JLabel("Employee Id");
        EName.setBounds(50,200,180,30);
        EName.setFont(new Font("serif",Font.BOLD,20));
        add(EName);

        TextRoll = new JLabel();
        TextRoll.setBounds(200,200,180,30);
        TextRoll.setFont(new Font("serif",Font.BOLD,20));
        add(TextRoll);

        //Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(450,200,180,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel date = new JLabel();
        date.setBounds(600, 200, 200, 30);
        add(date);

        //Address
        JLabel address = new JLabel("Address");
        address.setBounds(50,250,100,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        TextAddress = new JTextField();
        TextAddress.setBounds(200,250,200,30);
        add(TextAddress);

        //PhoneNumber
        JLabel phone = new JLabel("Phone number");
        phone.setBounds(450,250,180,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        try {
            formatter = new MaskFormatter("##########");
            formatter.setValueClass(String.class);
            formatter.setAllowsInvalid(false);
        } catch (Exception e) {
            System.out.println(e);
        }

        TextPhone = new JFormattedTextField(formatter);
        TextPhone.setBounds(600,250,200,30);
        add(TextPhone);

        //Email
        JLabel Email = new JLabel("Email");
        Email.setBounds(50,300,100,30);
        Email.setFont(new Font("serif",Font.BOLD,20));
        add(Email);

        TextEmail = new JTextField();
        TextEmail.setBounds(200,300,200,30);
        add(TextEmail);

        //Aadhar Number
        JLabel Aadhar = new JLabel("Aadhar Number");
        Aadhar.setBounds(450,300,200,30);
        Aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(Aadhar);

        TextAadhar = new JLabel();
        TextAadhar.setBounds(600,300,200,30);
        add(TextAadhar);

        //XII marks
        JLabel XII = new JLabel("12th percentage");
        XII.setBounds(50,350,180,30);
        XII.setFont(new Font("serif",Font.BOLD,20));
        add(XII);

        JLabel SXII = new JLabel();
        SXII.setBounds(200,350,200,30);
        add(SXII);

        //X marks
        JLabel X = new JLabel("10th percentage");
        X.setBounds(450,350,200,30);
        X.setFont(new Font("serif",Font.BOLD,20));
        add(X);

        JLabel SX = new JLabel();
        SX.setBounds(600,350,200,30);
        add(SX);

        //Course
        JLabel Course = new JLabel("Course");
        Course.setBounds(50,400,180,30);
        Course.setFont(new Font("serif",Font.BOLD,20));
        add(Course);

        TextCourse = new JTextField();
        TextCourse.setBounds(200,400,200,30);
        add(TextCourse);

        //Branch
        JLabel Branch = new JLabel("Branch");
        Branch.setBounds(450,400,200,30);
        Branch.setFont(new Font("serif",Font.BOLD,20));
        add(Branch);

        TextBranch = new JTextField();
        TextBranch.setBounds(600,400,200,30);
        add(TextBranch);

        choiceRoll.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String q = "select * from student where Roll = '"+choiceRoll.getSelectedItem()+"'";
                    ResultSet rs = c.st.executeQuery(q);
                    while(rs.next()) {
                        TextName.setText(rs.getString("Name"));
                        TextFName.setText(rs.getString("FName"));
                        TextRoll.setText(rs.getString("Roll"));
                        date.setText(rs.getString("Dob"));
                        TextAddress.setText(rs.getString("Address"));
                        TextPhone.setText(rs.getString("Phone"));
                        TextEmail.setText(rs.getString("Email"));
                        TextAadhar.setText(rs.getString("Aadhar"));
                        SXII.setText(rs.getString("XIImarks"));
                        SX.setText(rs.getString("Xmarks"));
                        TextCourse.setText(rs.getString("Course"));
                        TextBranch.setText(rs.getString("Branch"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });
        //Submit
        Submit = new JButton("Update");
        Submit.setBounds(220,480,150,40);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        //Cancel
        Cancel = new JButton("Exit");
        Cancel.setBounds(480,480,150,40);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        add(Cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Submit){
            String roll = TextRoll.getText();
            String address = TextAddress.getText();
            String phone = TextPhone.getText();
            String email = TextEmail.getText();
            String course = TextCourse.getText();
            String branch = TextBranch.getText();
            try{
                String q = "Update student set Address ='"+address+"', Phone = '"+phone+"', Email = '"+email+"',Course = '"+course+"', Branch = '"+branch+"' where Roll = '"+roll+"'";
                Conn c = new Conn();
                c.st.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Updated");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new UpdateStudent();
    }
}

