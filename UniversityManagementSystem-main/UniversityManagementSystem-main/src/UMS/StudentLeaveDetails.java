package UMS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice roll;
    JTable table;
    JButton search, printinfo, cancel;

    StudentLeaveDetails(){
        getContentPane().setBackground(Color.white);
        setSize(1000,600);
        setLocation(200,50);
        setLayout(null);
        setTitle("Student Leave Details");

        JLabel heading = new JLabel("Student Leave Details");
        heading.setBounds(380,20,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel seleid = new JLabel("Search by Roll Number");
        seleid.setBounds(20,100,150,20);
        add(seleid);

        roll = new Choice();
        roll.setBounds(180,100,150,20);
        add(roll);

        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from StudentLeave");
            while(rs.next()){
                roll.add(rs.getString("Roll"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from StudentLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,200,1000,600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 150, 80, 20);
        search.addActionListener(this);
        add(search);

        printinfo = new JButton("Print");
        printinfo.setBounds(120, 150, 80, 20);
        printinfo.addActionListener(this);
        add(printinfo);

        cancel = new JButton("Exit");
        cancel.setBounds(220, 150, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String q = "select * from StudentLeave where Roll = '"+roll.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.st.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception E){
                E.printStackTrace();
            }
        }else if(ae.getSource() == printinfo){
            try{
                table.print();
            }catch(Exception E){
                E.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new StudentLeaveDetails();
    }
}
