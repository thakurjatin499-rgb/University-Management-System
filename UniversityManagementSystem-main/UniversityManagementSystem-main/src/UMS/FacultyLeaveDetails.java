package UMS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class FacultyLeaveDetails extends JFrame implements ActionListener {

    Choice empid;
    JTable table;
    JButton search, printinfo, cancel;

    FacultyLeaveDetails(){
        getContentPane().setBackground(Color.white);
        setSize(1000,600);
        setLocation(200,50);
        setLayout(null);
        setTitle("Faculty Leave Details");

        JLabel heading = new JLabel("Faculty Leave Details");
        heading.setBounds(380,20,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel seleid = new JLabel("Search by Emp id");
        seleid.setBounds(20,100,150,20);
        add(seleid);

        empid = new Choice();
        empid.setBounds(180,100,150,20);
        add(empid);

        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from FacultyLeave");
            while(rs.next()){
                empid.add(rs.getString("EId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from FacultyLeave");
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
            String q = "select * from FacultyLeave where EId = '"+empid.getSelectedItem()+"'";
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
       new FacultyLeaveDetails();
    }
}
