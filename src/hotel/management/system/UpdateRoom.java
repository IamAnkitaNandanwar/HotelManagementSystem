
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener{
    JTextField t1,t2,t3;
     Choice c1;
     JButton b1,b2,b3;
     
    UpdateRoom(){
        JLabel lb = new JLabel("Update Room Status");
        lb.setForeground(Color.BLUE);
        lb.setBounds(90,20,200,30);
        lb.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lb);
        
        JLabel l1 = new JLabel("Guest ID :");
        l1.setBounds(30,80,100,20);
        l1.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(l1);
        
        c1 = new Choice();
        c1.setBounds(200,80,150,25);
        add(c1);
        try{
            conn c = new conn();
            String str2 = "select * from customer";
            ResultSet rs = c.s.executeQuery(str2);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
            
        }catch(Exception e){
               e.printStackTrace();
          }
        
        JLabel l3 = new JLabel("Room Number :");
        l3.setBounds(30,120,120,20);
        l3.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Availability :");
        l4.setBounds(30,160,100,25);
        l4.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Clean Status :");
        l5.setBounds(30,200,100,20);
        l5.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);
        
        b1 = new JButton("Check");
        b1.setBounds(30,270,150,30);
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBounds(200, 270, 150, 30);
        b2.setBackground(Color.ORANGE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("back");
        b3.setBounds(120, 320, 150, 30);
        b3.setBackground(Color.ORANGE);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image ic2 = ic.getImage().getScaledInstance(500,320,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel ll = new JLabel(ic3);
        ll.setBounds(400,30,500,320);
        add(ll);
        
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,180,950,410);
        setVisible(true);
    }
            
     public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == b1){
           String room = null;
        String s1 = c1.getSelectedItem();
        conn c = new conn();
       
        try{
             String str = "select * from customer where number = '"+s1+"'";
             
              ResultSet rs = c.s.executeQuery(str);
             while(rs.next()){
                 t1.setText(rs.getString("room"));
                 room = rs.getString("room");
             }
             String str1 = "select * from room where room = '"+room+"'";
               ResultSet rs2 = c.s.executeQuery(str1);
             while(rs2.next()){
                 t2.setText(rs2.getString("available"));
                 t3.setText(rs2.getString("status")); 
             }
        }catch(Exception e){
            e.printStackTrace();
        }
      }else if (ae.getSource() == b2){
            try{
                 conn c = new conn();
                 
                 String room =t1.getText();
                 String available = t2.getText();
                 String status = t3.getText();
                 String str1 = "update room set available = '"+available+"', status = '"+status+"' where room = '"+room+"'";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "New Update Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
      }else if (ae.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
      }
    }
     
     public static void main(String[] args) {
        // TODO code application logic here
        new UpdateRoom();
        
    }
            
}
