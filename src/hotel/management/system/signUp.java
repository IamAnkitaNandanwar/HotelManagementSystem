
package hotel.management.system;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class signUp extends JFrame implements ActionListener {
    
    JLabel l1,l2,lb;
    JTextField t1,t2;
    //JPasswordField t2;
    JButton b1, b2 , b3;

    signUp(){
        lb = new JLabel("Sign Up");
        lb.setBounds(100, 20, 100, 38);
        lb.setForeground(Color.BLUE);
        lb.setFont(new Font("serif",Font.PLAIN,30));
        add(lb);
        
        l1 = new JLabel("Username : ");
        l1.setBounds(40, 80, 100, 30);
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(160,80,150,30);
        add(t1);
        
        l2 = new JLabel("Password : ");
        l2.setBounds(40,130, 100, 30);
        add(l2);
       
        t2 = new JTextField();
        t2.setBounds(160,130,150,30);
        add(t2);
        
        b1 = new JButton("Sign Up");
        b1.setBounds(50,200,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(170,200,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500,200,350,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();
            String str = "insert into login values('"+username+"','"+password+"')";
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Sign Up Successfully");
                new Login().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){
                 e.printStackTrace();
            }
        }else if (ae.getSource() == b2){
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new signUp();
    }
    
}
