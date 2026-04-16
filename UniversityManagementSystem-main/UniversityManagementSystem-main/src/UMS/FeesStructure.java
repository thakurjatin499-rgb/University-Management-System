package UMS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class FeesStructure extends JFrame implements ActionListener {

    FeesStructure(){
       setSize(1000,600);
       setLocation(100,50);
       setTitle("Fees Structure");
       setLayout(null);

       getContentPane().setBackground(Color.white);

       JLabel head = new JLabel("Fees Structure");
       head.setBounds(350,10,400,30);
       head.setFont(new Font("Tahoma",Font.BOLD,30));
       add(head);

       JTable table = new JTable();

       try{
           Conn c = new Conn();
           ResultSet rs = c.st.executeQuery("select * from fee");
           table.setModel(DbUtils.resultSetToTableModel(rs));

       }catch(Exception E){
           E.printStackTrace();
       }

       JScrollPane jsp = new JScrollPane(table);
       jsp.setBounds(0,60,1000,600);
       add(jsp);

       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

    }

    public static void main(String[] args){
        new FeesStructure();
    }
}
