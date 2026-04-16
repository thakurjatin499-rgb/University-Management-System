package UMS;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.*;

public class AddFaculty extends JFrame implements ActionListener {
    JTextField TextName,TextFName, TextAddress,TextEmail;
    JFormattedTextField TextPhone,TextAadhar;
    JLabel TextEid;
    JDateChooser date;
    JComboBox TextQual,TextDept;
    JButton Submit,Cancel;
    MaskFormatter formatter,formatter2;
    Random ran = new Random();
    long f4 = Math.abs(ran.nextLong() % 9000L)+ 1000L;
    AddFaculty() throws ParseException {
        setTitle("Add New Faculty");
        setSize(900,600);
        setLocation(200,50);
        setLayout(null);
        getContentPane().setBackground(new Color(4,200,200));

        JLabel heading = new JLabel("New Faculty Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        TextName = new JTextField();
        TextName.setBounds(200,150,200,30);
        add(TextName);

        //Father's Name
        JLabel FName = new JLabel("Father's Name");
        FName.setBounds(450,150,180,30);
        FName.setFont(new Font("serif",Font.BOLD,20));
        add(FName);

        TextFName = new JTextField();
        TextFName.setBounds(600,150,200,30);
        add(TextFName);

        //Employee id
        JLabel EName = new JLabel("Employee Id");
        EName.setBounds(50,200,180,30);
        EName.setFont(new Font("serif",Font.BOLD,20));
        add(EName);

        TextEid = new JLabel("K"+f4);
        TextEid.setBounds(200,200,180,30);
        TextEid.setFont(new Font("serif",Font.BOLD,20));
        add(TextEid);

        //Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(450,200,180,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        try {
            date = new JDateChooser();
            date.setBounds(600, 200, 200, 30);
            add(date);
        }catch(Exception e){System.out.println(e);}

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

         try {
            formatter2 = new MaskFormatter("############");
             formatter2.setValueClass(String.class);
             formatter2.setAllowsInvalid(false);
         } catch (Exception e) {
             System.out.println(e);
         }

         TextAadhar = new JFormattedTextField(formatter2);
         TextAadhar.setBounds(600,300,200,30);
         add(TextAadhar);

         //Qualification
        JLabel Qual = new JLabel("Qualification");
        Qual.setBounds(50,350,180,30);
        Qual.setFont(new Font("serif",Font.BOLD,20));
        add(Qual);

        String[] courses = {"Select","B.Tech", "BBA", "BCA","BSc", "BA", "M.Tech", "MBA", "MCA", "MSc","MA", "Phd"};
        TextQual = new JComboBox(courses);
        TextQual.setBounds(200,350,200,30);
        add(TextQual);

        //Department
        JLabel Dept = new JLabel("Department");
        Dept.setBounds(450,350,200,30);
        Dept.setFont(new Font("serif",Font.BOLD,20));
        add(Dept);

        String[] Depart = {"Select","Civil", "Computer Science", "Electronics","Management","Mechanical"};
        TextDept = new JComboBox(Depart);
        TextDept.setBounds(600,350,200,30);
        add(TextDept);

        //Submit
        Submit = new JButton("Submit");
        Submit.setBounds(220,450,150,40);
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.white);
        Submit.addActionListener(this);
        add(Submit);

        //Cancel
        Cancel = new JButton("Exit");
        Cancel.setBounds(480,450,150,40);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(this);
        add(Cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Submit){
           String name = TextName.getText();
           String fname = TextFName.getText();
           String eid = TextEid.getText();
           String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
           String address = TextAddress.getText();
           String phone = TextPhone.getText();
           String email = TextEmail.getText();
           String aadhar = TextAadhar.getText();
           String qual = (String) TextQual.getSelectedItem();
           String dept = (String) TextDept.getSelectedItem();
           try{
               String q = "insert into faculty value('"+name+"','"+fname+"','"+eid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+aadhar+"','"+qual+"','"+dept+"')";
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


    public static void main(String [] args) throws ParseException {
            new AddFaculty();
    }
}