
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    
    Reception(){
        b1 = new JButton("New Customer form");
        b1.setBounds(20,30,200,30);
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Room");
        b2.setBounds(20,70,200,30);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Department");
        b3.setBounds(20,110,200,30);
        b3.setBackground(Color.ORANGE);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
        
        b4 = new JButton("All Employee Info");
        b4.setBounds(20,150,200,30);
        b4.setBackground(Color.RED);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);
        
        b5 = new JButton("Customer info");
        b5.setBounds(20,190,200,30);
        b5.setBackground(Color.ORANGE);
        b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        add(b5);
        
        b6 = new JButton("Manager Info");
        b6.setBounds(20,230,200,30);
        b6.setBackground(Color.RED);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        add(b6);
        
        b7 = new JButton("Check Out");
        b7.setBounds(20,270,200,30);
        b7.setBackground(Color.ORANGE);
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        add(b7);
        
        b8 = new JButton("Update Check Status");
        b8.setBounds(20,310,200,30);
        b8.setBackground(Color.RED);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        add(b8);
        
        b9 = new JButton("Update Room Status");
        b9.setBounds(20,350,200,30);
        b9.setBackground(Color.ORANGE);
        b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        add(b9);
        
        b10 = new JButton("Pick Up Service");
        b10.setBounds(20,390,200,30);
        b10.setBackground(Color.RED);
        b10.setForeground(Color.WHITE);
        b10.addActionListener(this);
        add(b10);
        
        b11 = new JButton("Search Room");
        b11.setBounds(20,430,200,30);
        b11.setBackground(Color.ORANGE);
        b11.setForeground(Color.WHITE);
        b11.addActionListener(this);
        add(b11);
        
        b12 = new JButton("Log Out");
        b12.setBounds(20,470,200,30);
        b12.setBackground(Color.RED);
        b12.setForeground(Color.WHITE);
        b12.addActionListener(this);
        add(b12);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        Image ic2 = ic.getImage().getScaledInstance(500,470,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel l1 = new JLabel(ic);
        l1.setBounds(250,30,500,470);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,180,800,550);
        setVisible(true);
     
    }
     public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            new AddCustomer().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b2){
            new Room().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b3){
            new department().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b4){
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b5){
             new CustomerInfo().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b6){
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b7){
            new CheckOut().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b8){
            new UpdateCheck().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b9){
            new UpdateRoom().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b10){
             new pickUp().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b11){
            new searchRoom().setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == b12){
            System.exit(0); 
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Reception();        
    }
    
}
