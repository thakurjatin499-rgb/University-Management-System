package UMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main_class extends JFrame implements ActionListener {
    Main_class(){
        setSize(1250,670);
        setTitle("Main Page");
        getContentPane().setBackground(new Color(210, 232, 252));
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("UMS/icons/mp.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(270,50,700,300);
        add(img);

        JLabel msg = new JLabel("Welcome to University Management System");
        msg.setBounds(270, 400, 700, 40);
        msg.setFont(new Font("serif", Font.BOLD, 35));
        msg.setForeground(Color.black);
        add(msg);

        JMenuBar mb = new JMenuBar();

        //new info
        JMenu NewInfo = new JMenu("New Information");
        NewInfo.setForeground(Color.black);
        mb.add(NewInfo);

        JMenuItem FacultyInfo = new JMenuItem("New Faculty Information");
        FacultyInfo.setBackground(Color.white);
        FacultyInfo.addActionListener(this);
        NewInfo.add(FacultyInfo);

        JMenuItem StudentInfo = new JMenuItem("New Student Information");
        StudentInfo.setBackground(Color.white);
        StudentInfo.addActionListener(this);
        NewInfo.add(StudentInfo);

        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.black);
        mb.add(details);

        JMenuItem FacultyDetails = new JMenuItem("View Faculty Details");
        FacultyDetails.setBackground(Color.white);
        FacultyDetails.addActionListener(this);
        details.add(FacultyDetails);

        JMenuItem StudentDetails = new JMenuItem("View Student Details");
        StudentDetails.setBackground(Color.white);
        StudentDetails.addActionListener(this);
        details.add(StudentDetails);

         //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.black);
        mb.add(leave);

        JMenuItem FacultyL = new JMenuItem("Faculty Leave");
        FacultyL.setBackground(Color.white);
        FacultyL.addActionListener(this);
        leave.add(FacultyL);

        JMenuItem StudentL = new JMenuItem ("Student Leave");
        StudentL.setBackground(Color.white);
        StudentL.addActionListener(this);
        leave.add(StudentL);

        //LeaveDeatils
        JMenu LeaveD = new JMenu("Leave Details");
        leave.setForeground(Color.black);
        mb.add(LeaveD);

        JMenuItem FacultyLD = new JMenuItem("Faculty Leave Details");
        FacultyLD.setBackground(Color.white);
        FacultyLD.addActionListener(this);
        LeaveD.add(FacultyLD);

        JMenuItem StudentLD = new JMenuItem ("Student Leave Details");
        StudentLD.setBackground(Color.white);
        StudentLD.addActionListener(this);
        LeaveD.add(StudentLD);

        //Exams
        JMenu Exam = new JMenu("Examination");
        Exam.setForeground(Color.black);
        mb.add(Exam);

        JMenuItem ExamR = new JMenuItem("Examination Results");
        ExamR.setBackground(Color.white);
        ExamR.addActionListener(this);
        Exam.add(ExamR);

        JMenuItem ExamM = new JMenuItem ("Enter Marks");
        ExamM.setBackground(Color.white);
        ExamM.addActionListener(this);
        Exam.add(ExamM);

        //update details
        JMenu Update = new JMenu("Update Details");
        Update.setForeground(Color.black);
        mb.add(Update);

        JMenuItem UpdateF = new JMenuItem("Faculty Details");
        UpdateF.setBackground(Color.white);
        UpdateF.addActionListener(this);
        Update.add(UpdateF);

        JMenuItem UpdateS = new JMenuItem("Student Details");
        UpdateS.setBackground(Color.white);
        UpdateS.addActionListener(this);
        Update.add(UpdateS);

        //Fees
        JMenu Fees = new JMenu("Fees Details");
        Fees.setForeground(Color.black);
        mb.add(Fees);

        JMenuItem FeesD = new JMenuItem("Fees Structure");
        FeesD.setBackground(Color.white);
        FeesD.addActionListener(this);
        Fees.add(FeesD);

        JMenuItem FeesP = new JMenuItem("Fees Form");
        FeesP.setBackground(Color.white);
        FeesP.addActionListener(this);
        Fees.add(FeesP);

        //About
        JMenu About = new JMenu("About");
        About.setForeground(Color.black);
        mb.add(About);

        JMenuItem about = new JMenuItem("About");
        about.setBackground(Color.white);
        about.addActionListener(this);
        About.add(about);

        //Exit
        JMenu Exit = new JMenu("Exit");
        Exit.setForeground(Color.black);
        mb.add(Exit);

        JMenuItem ExitM = new JMenuItem("Exit");
        ExitM.setBackground(Color.white);
        ExitM.addActionListener(this);
        Exit.add(ExitM);

        setJMenuBar(mb);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
        if (s.equals("Exit")) {
            System.exit(1);
        } else if (s.equals("New Faculty Information")) {
            try {
                new AddFaculty();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(s.equals("New Student Information")){
            try {
                new AddStudent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(s.equals("View Faculty Details")){
                new FacultyDetails();
        }else if(s.equals("View Student Details")){
                new StudentDetails();
        }else if(s.equals("Faculty Leave")){
                new FacultyLeave();
        }else if(s.equals("Student Leave")){
                new StudentLeave();
        }else if(s.equals("Faculty Leave Details")){
            new FacultyLeaveDetails();
        }else if(s.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(s.equals("Faculty Details")){
            new UpdateFaculty();
        }else if(s.equals("Student Details")){
            new UpdateStudent();
        }else if(s.equals("Enter Marks")){
            new EnterMarks();
        }else if(s.equals("Examination Results")){
            new ExamDetails();
        }else if(s.equals("Fees Structure")){
            new FeesStructure();
        }else if(s.equals("Fees Form")){
            new Fees();
        }else if(s.equals("About")){
                new About();
        }
    }

    public static void main(String args[]){
        new Main_class();
    }
}

