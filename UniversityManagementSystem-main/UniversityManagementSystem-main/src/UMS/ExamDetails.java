package UMS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ExamDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton res,can;
    JTable table;

    ExamDetails(){
       setSize(1000,475);
       setLocation(100,100);
       setLayout(null);
       setTitle("Result");
       getContentPane().setBackground(new Color(241,252,210));

       JLabel head = new JLabel("Check Result");
       head.setBounds(350,15,400,50);
       head.setFont(new Font("Tahoma",Font.BOLD, 24));
       add(head);

       search = new JTextField();
       search.setBounds(80,90,200,30);
       search.setFont(new Font("Tahoma",Font.PLAIN,18));
       add(search);

       res = new JButton("Result");
       res.setBounds(300,90,120,30);
       res.setBackground(Color.black);
       res.setForeground(Color.white);
       res.addActionListener(this);
       add(res);

        can = new JButton("Exit");
        can.setBounds(440,90,120,30);
        can.setBackground(Color.black);
        can.setForeground(Color.white);
        can.addActionListener(this);
        add(can);

        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);

        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == res){
           setVisible(false);
           new Marks(search.getText());
       }else{
           setVisible(false);
       }
    }

    public static void main(String[] args){
        new ExamDetails();
    }

}
