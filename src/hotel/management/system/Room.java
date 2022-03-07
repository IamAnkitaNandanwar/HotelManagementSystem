
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;
    
    Room(){
        
        t1 = new JTable();
        t1.setBounds(0,50,600,400);
        t1.setBackground(Color.WHITE);
        t1.setFont(new Font("serif",Font.PLAIN,15));
        add(t1);
        
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        l1.setFont(new Font("serif",Font.PLAIN,16));
        add(l1);
        
        JLabel l2 = new JLabel("Avaialable");
        l2.setBounds(130,10,100,20);
        l2.setFont(new Font("serif",Font.PLAIN,16));
        add(l2);
        
        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(240,10,100,20);
        l3.setFont(new Font("serif",Font.PLAIN,16));
        add(l3);
        
        JLabel l4 = new JLabel("Bed Type");
        l4.setBounds(380,10,120,20);
        l4.setFont(new Font("serif",Font.PLAIN,16));
        add(l4);
        
        JLabel l5 = new JLabel("Price");
        l5.setBounds(490,10,100,20);
        l5.setFont(new Font("serif",Font.PLAIN,16));
        add(l5);
        
        b1 = new JButton("Load Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(450, 500, 120, 30);
        add(b1);
        
        b2 = new JButton("back");
        b2.setBounds(600, 500, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image ic2 = ic.getImage().getScaledInstance(500,430,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel lb = new JLabel(ic3);
        lb.setBounds(630,30,500,430);
        add(lb);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(160,100,1180,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
          try{
              conn c = new conn();
             String str = "select * from room";
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
        new Room();  
    }
    
}
