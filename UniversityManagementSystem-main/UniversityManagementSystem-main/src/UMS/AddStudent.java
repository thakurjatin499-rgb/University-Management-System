package UMS;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener {
        JTextField STextName,STextFName, STextAddress,STextEmail,SXII,SX;
        JFormattedTextField STextPhone,STextAadhar;
        JLabel STextRoll;
        JDateChooser Sdate;
        JComboBox STextCourse, STextBranch;
        JButton Submit,Cancel;
        MaskFormatter formatter,formatter2;
        Random ran = new Random();
        long f4 = Math.abs(ran.nextLong() % 9000L)+ 1000L;
        AddStudent() throws ParseException {
            setTitle("Add New Student");
            setSize(900,600);
            setLocation(200,50);
            setLayout(null);
            getContentPane().setBackground(new Color(128,176,255));

            JLabel heading = new JLabel("New Student Details");
            heading.setBounds(310,30,500,50);
            heading.setFont(new Font("serif", Font.BOLD, 30));
            add(heading);

            //Name
            JLabel name = new JLabel("Name");
            name.setBounds(50,150,100,30);
            name.setFont(new Font("serif", Font.BOLD, 20));
            add(name);

            STextName = new JTextField();
            STextName.setBounds(200,150,200,30);
            add(STextName);

            //Father's Name
            JLabel FName = new JLabel("Father's Name");
            FName.setBounds(450,150,180,30);
            FName.setFont(new Font("serif",Font.BOLD,20));
            add(FName);

            STextFName = new JTextField();
            STextFName.setBounds(600,150,200,30);
            add(STextFName);

            //Employee id
            JLabel EName = new JLabel("Roll Number");
            EName.setBounds(50,200,180,30);
            EName.setFont(new Font("serif",Font.BOLD,20));
            add(EName);

            STextRoll = new JLabel("2205"+f4);
            STextRoll.setBounds(200,200,180,30);
            STextRoll.setFont(new Font("serif",Font.BOLD,20));
            add(STextRoll);

            //Date of Birth
            JLabel dob = new JLabel("Date of Birth");
            dob.setBounds(450,200,180,30);
            dob.setFont(new Font("serif",Font.BOLD,20));
            add(dob);
            try {
                Sdate = new JDateChooser();
                Sdate.setBounds(600, 200, 200, 30);
                add(Sdate);
            }catch(Exception e){System.out.println(e);}

            //Address
            JLabel address = new JLabel("Address");
            address.setBounds(50,250,100,30);
            address.setFont(new Font("serif",Font.BOLD,20));
            add(address);

            STextAddress = new JTextField();
            STextAddress.setBounds(200,250,200,30);
            add(STextAddress);

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

            STextPhone = new JFormattedTextField(formatter);
            STextPhone.setBounds(600,250,200,30);
            add(STextPhone);

            //Email
            JLabel Email = new JLabel("Email");
            Email.setBounds(50,300,100,30);
            Email.setFont(new Font("serif",Font.BOLD,20));
            add(Email);

            STextEmail = new JTextField();
            STextEmail.setBounds(200,300,200,30);
            add(STextEmail);

            //Aadhar Number
            JLabel Aadhar = new JLabel("Aadhar Number");
            Aadhar.setBounds(450,300,200,30);
            Aadhar.setFont(new Font("serif",Font.BOLD,20));
            add(Aadhar);

            try {
                formatter2 = new MaskFormatter("############");
                formatter2.setValueClass(String.class);
                formatter2.setAllowsInvalid(false);
            } catch (Exception e) {
                System.out.println(e);
            }

            STextAadhar = new JFormattedTextField(formatter2);
            STextAadhar.setBounds(600,300,200,30);
            add(STextAadhar);

            //XII marks
            JLabel XII = new JLabel("12th percentage");
            XII.setBounds(50,350,180,30);
            XII.setFont(new Font("serif",Font.BOLD,20));
            add(XII);

            SXII = new JTextField();
            SXII.setBounds(200,350,200,30);
            add(SXII);

            //X marks
            JLabel X = new JLabel("10th percentage");
            X.setBounds(450,350,200,30);
            X.setFont(new Font("serif",Font.BOLD,20));
            add(X);

            SX = new JTextField();
            SX.setBounds(600,350,200,30);
            add(SX);

            //Course
            JLabel Course = new JLabel("Course");
            Course.setBounds(50,400,180,30);
            Course.setFont(new Font("serif",Font.BOLD,20));
            add(Course);

            String[] courses = {"Select","B.Tech", "BBA", "BCA","BSc", "BA", "M.Tech", "MBA", "MCA", "MSc","MA", "Phd"};
            STextCourse = new JComboBox(courses);
            STextCourse.setBounds(200,400,200,30);
            add(STextCourse);

            //Branch
            JLabel Branch = new JLabel("Branch");
            Branch.setBounds(450,400,200,30);
            Branch.setFont(new Font("serif",Font.BOLD,20));
            add(Branch);

            String[] Branches = {"Select","Civil", "Computer Science","Computer Application", "Electronics","Management","Mechanical"};
            STextBranch = new JComboBox(Branches);
            STextBranch.setBounds(600,400,200,30);
            add(STextBranch);

            //Submit
            Submit = new JButton("Submit");
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
                String name = STextName.getText();
                String fname = STextFName.getText();
                String roll = STextRoll.getText();
                String dob = ((JTextField) Sdate.getDateEditor().getUiComponent()).getText();
                String address = STextAddress.getText();
                String phone = STextPhone.getText();
                String email = STextEmail.getText();
                String aadhar = STextAadhar.getText();
                String xii = SXII.getText();
                String x = SX.getText();
                String course = (String) STextCourse.getSelectedItem();
                String branch= (String) STextBranch.getSelectedItem();
                try{
                    String q = "insert into student value('"+name+"','"+fname+"','"+roll+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+aadhar+"','"+xii+"','"+x+"','"+course+"','"+branch+"')";
                    Conn c = new Conn();
                    c.st.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details Inserted");
                    setVisible(false);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                setVisible(false);
            }
        }
    public static void main(String[] args) throws ParseException {
        new AddStudent();
    }
}
