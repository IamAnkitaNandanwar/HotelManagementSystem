
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class pickUp extends JFrame implements ActionListener {
    
    Choice c1;
    JButton b1,b2;
    JTable t1;
    
    pickUp(){
        
        JLabel lb = new JLabel("PickUp Service");
        lb.setForeground(Color.BLUE);
        lb.setBounds(400,30,200,30);
        lb.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lb);
        
        JLabel lb2 = new JLabel("Type of car :");
        lb2.setBounds(50,80,150,25);
        lb2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lb2);
        
        c1 = new Choice();
        c1.setBounds(200,80,150,30);
        c1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(c1);
        try{
            conn c = new conn();
            String str2 = "select * from driver";
            ResultSet rs = c.s.executeQuery(str2);
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
            rs.close();
        }catch(Exception e){
               e.printStackTrace();
        }
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(50,140,100,20);
        l1.setFont(new Font("serif",Font.PLAIN,16));
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(180,140,100,20);
        l2.setFont(new Font("serif",Font.PLAIN,16));
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330,140,100,20);
        l3.setFont(new Font("serif",Font.PLAIN,16));
        add(l3);
        
        JLabel l4 = new JLabel("company");
        l4.setBounds(460,140,120,20);
        l4.setFont(new Font("serif",Font.PLAIN,16));
        add(l4);
        
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(610,140,100,20);
        l5.setFont(new Font("serif",Font.PLAIN,16));
        add(l5);
        
        JLabel l6 = new JLabel("Available");
        l6.setBounds(750,140,150,20);
        l6.setFont(new Font("serif",Font.PLAIN,16));
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(870,140,150,20);
        l7.setFont(new Font("serif",Font.PLAIN,16));
        add(l7);
       
        
        t1 = new JTable();
        t1.setBackground(Color.WHITE);
        t1.setBounds(0,180,1000,280);
        add(t1);
        
        b1 = new JButton("Search");
        b1.setBounds(350,500,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("back");
        b2.setBounds(500, 500, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(280,120,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == b1){
             try{
                 String str = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
                 conn c = new conn();
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
        // TODO code application logic here
        new pickUp();
        
    }
}
