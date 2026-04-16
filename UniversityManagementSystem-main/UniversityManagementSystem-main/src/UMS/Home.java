package UMS;
import java.awt.*;
import javax.swing.*;
public class Home extends JFrame implements Runnable{
    Thread t;
    Home(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("UMS/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        setSize(700,400);
        setLocation(250,50);

        t = new Thread(this);
        t.start();

        setVisible(true);
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        }
        catch(Exception e){e.printStackTrace();}
    }
    public static void main(String[] args){
        new Home();
    }
}