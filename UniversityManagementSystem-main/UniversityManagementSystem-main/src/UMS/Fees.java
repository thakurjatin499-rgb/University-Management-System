package UMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Fees extends JFrame implements ActionListener {

    Choice Croll;
    JComboBox STextBranch, STextCourse, STextSem;
    JLabel TextTotal;
    JButton pay,update,can;

    Fees(){
        setSize(800,500);
        setLocation(150,50);
        setTitle("Fees Form");
        setLayout(null);

        getContentPane().setBackground(new Color(210,252,251));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("UMS/icons/fees.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500,100,200,200);
        add(img);

        JLabel rollN = new JLabel("Select Roll Number");
        rollN.setBounds(40,60,150,20);
        rollN.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(rollN);

        Croll = new Choice();
        Croll.setBounds(200,60,150,20);
        Croll.add("Select");
        add(Croll);

        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from student");
            while(rs.next()){
                Croll.add(rs.getString("Roll"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(40,100,150,20);
        add(name);

        JLabel TName = new JLabel();
        TName.setBounds(200,100,150,20);
        add(TName);

        JLabel Fname = new JLabel("Father's Name");
        Fname.setBounds(40,140,150,20);
        add(Fname);

        JLabel TFName = new JLabel();
        TFName.setBounds(200,140,150,20);
        add(TFName);

        Croll.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String q = "select * from student where Roll = '"+Croll.getSelectedItem()+"'";
                    ResultSet rs = c.st.executeQuery(q);
                    while(rs.next()) {
                        TName.setText(rs.getString("Name"));
                        TFName.setText(rs.getString("FName"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Course
        JLabel Course = new JLabel("Course");
        Course.setBounds(40,180,150,20);
        add(Course);

        String[] courses = {"Select","BTech", "BCA","Bsc", "MTech","MCA", "MSc", "Bcom","Mcom"};
        STextCourse = new JComboBox(courses);
        STextCourse.setBounds(200,180,150,20);
        add(STextCourse);

        //Branch
        JLabel Branch = new JLabel("Branch");
        Branch.setBounds(40,220,150,20);
        add(Branch);

        String[] Branches = {"Select","Civil", "Computer Science","Computer Application", "Electronics","Management","Mechanical"};
        STextBranch = new JComboBox(Branches);
        STextBranch.setBounds(200,220,150,20);
        add(STextBranch);

        JLabel Sem = new JLabel("Semester");
        Sem.setBounds(40,260,150,20);
        add(Sem);

        String[] Semester = {"Select","semester1", "semester2","semester3", "semester4","semester5","semester6", "semester7","semester8"};
        STextSem = new JComboBox(Semester);
        STextSem.setBounds(200,260,150,20);
        add(STextSem);

        JLabel Total = new JLabel("Total Payable");
        Total.setBounds(40,300,150,20);
        add(Total);

        TextTotal = new JLabel();
        TextTotal.setBounds(200,300,150,20);
        add(TextTotal);

        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150,380,100,25);
        pay.addActionListener(this);
        add(pay);

        can = new JButton("Cancel");
        can.setBounds(270,380,100,25);
        can.addActionListener(this);
        add(can);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
           String course = (String) STextCourse.getSelectedItem();
           String sem = (String) STextSem.getSelectedItem();
           try{
               Conn c = new Conn();
               ResultSet rs = c.st.executeQuery("select * from fee where course = '"+course+"'");
               while(rs.next()){
                   TextTotal.setText(rs.getString(sem));
               }
           }catch(Exception E){
               E.printStackTrace();
           }
        }else if(ae.getSource() == pay){
            String roll = Croll.getSelectedItem();
            String course = (String) STextCourse.getSelectedItem();
            String sem = (String) STextSem.getSelectedItem();
            String branch = (String) STextBranch.getSelectedItem();
            String total = TextTotal.getText();
            try{
                Conn c = new Conn();
                String q = "insert into FeesPaid values('"+roll+"','"+course+"','"+branch+"','"+sem+"','"+total+"')";
                c.st.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Fees Paid Successfully");
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
      new Fees();
    }

}
