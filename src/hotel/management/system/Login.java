
package hotel.management.system;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Login extends JFrame implements ActionListener {
    
    JLabel l1,l2,lb;
    JTextField t1,t2;
    //JPasswordField t2;
    JButton b1, b2 , b3;

    Login(){
        lb = new JLabel("Sign In");
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
        
        b1 = new JButton("Login");
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
        
        l2 = new JLabel("For new account sign up here -> ");
        l2.setBounds(40,300, 200, 30);
        add(l2);
        
        b3 = new JButton("Sign Up");
        b3.setBounds(250,300,100,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/images.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,30,200,200);
        add(l3);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(500,200,600,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();
            String str = "select * from login where username = '"+username+"' and passwaord = '"+password+"'";
            try{
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username and password Try Again");
                }
            }catch(Exception e){
                 e.printStackTrace();
            }
        }else if (ae.getSource() == b2){
            System.exit(0);
        }else if (ae.getSource() == b3){
            new signUp().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
    
}
