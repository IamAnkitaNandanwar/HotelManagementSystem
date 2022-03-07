
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    Choice c1;
    JButton b1,b2,b3;
    
    CheckOut(){
        JLabel lb = new JLabel("Check-Out Details");
        lb.setForeground(Color.BLUE);
        lb.setBounds(90,20,200,30);
        lb.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lb);
        
        JLabel l1 = new JLabel("Customer-ID :");
        l1.setBounds(30,100,100,20);
        l1.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(l1);
        
        c1 = new Choice();
        c1.setBounds(200,100,150,25);
        add(c1);
        try{
            conn c = new conn();
            String str2 = "select * from customer";
            ResultSet rs = c.s.executeQuery(str2);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
            rs.close();
        }catch(Exception e){
               e.printStackTrace();
          }
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image ic5 = ic1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon ic4 = new ImageIcon(ic5);
        b3 = new JButton(ic4);
        b3.setBounds(360,100,20,20);
        b3.addActionListener(this);
        add(b3);
        
        JLabel l3 = new JLabel("Room Number :");
        l3.setBounds(30,150,120,20);
        l3.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,150,150,25);
        add(t1);
        
        b1 = new JButton("Check-Out");
        b1.setBounds(30,220,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("back");
        b2.setBounds(200, 220, 150, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image ic2 = ic.getImage().getScaledInstance(400,330,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel ll = new JLabel(ic3);
        ll.setBounds(400,0,400,330);
        add(ll);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,180,850,330);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == b1){
             String id = c1.getSelectedItem();
             String room = t1.getText();
             String str = "delete from customer where number = '"+id+"'";
             String str2 = "update room set available = 'Avaialable' where room ='"+room+"'";
             conn c = new conn();
             try{
                 c.s.executeUpdate(str);
                 c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Checked out Successfully");
                this.setVisible(false);
                new Reception().setVisible(true);
                this.setVisible(false);
             }catch(Exception e){
                e.printStackTrace();
             }
           
        }else if (ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
      }else if (ae.getSource() == b3){
            String s1 = c1.getSelectedItem();
            conn c = new conn();
           
            try{
                String str = "select * from customer where number = '"+s1+"'";
             
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("room")); 
                }
            }catch(Exception e){
                e.printStackTrace();
            }
      }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new CheckOut();
        
    }
}
