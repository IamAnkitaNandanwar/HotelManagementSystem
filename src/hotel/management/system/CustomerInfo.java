
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;
    
    CustomerInfo(){
        t1 = new JTable();
        t1.setBounds(0,50,1280,500);
        t1.setBackground(Color.WHITE);
        t1.setFont(new Font("serif",Font.PLAIN,15));
        add(t1);
        
        JLabel l1 = new JLabel("ID");
        l1.setBounds(50,10,100,20);
        l1.setFont(new Font("serif",Font.PLAIN,16));
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(200,10,100,20);
        l2.setFont(new Font("serif",Font.PLAIN,16));
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(370,10,100,20);
        l3.setFont(new Font("serif",Font.PLAIN,16));
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(510,10,120,20);
        l4.setFont(new Font("serif",Font.PLAIN,16));
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(680,10,100,20);
        l5.setFont(new Font("serif",Font.PLAIN,16));
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(830,10,150,20);
        l6.setFont(new Font("serif",Font.PLAIN,16));
        add(l6);
        
        JLabel l7 = new JLabel("Status");
        l7.setBounds(980,10,150,20);
        l7.setFont(new Font("serif",Font.PLAIN,16));
        add(l7);
        
        JLabel l8 = new JLabel("Deposite");
        l8.setBounds(1150,10,100,20);
        l8.setFont(new Font("serif",Font.PLAIN,16));
        add(l8);
        
        b1 = new JButton("Load Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(500, 560, 120, 30);
        add(b1);
        
        b2 = new JButton("back");
        b2.setBounds(640, 560, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
       getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(100,100,1300,650);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
          try{
              conn c = new conn();
              String str = "select * from customer";
              ResultSet rs = c.s.executeQuery(str);
              t1.setModel(DbUtils.resultSetToTableModel(rs));
          }catch(Exception e){
               e.printStackTrace();
          }
        }else if (ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
     public static void main(String[] args) {
        new CustomerInfo();  
    }
}
