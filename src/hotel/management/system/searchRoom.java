
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class searchRoom extends JFrame implements ActionListener{
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    searchRoom(){
        
        JLabel lb = new JLabel("Search for Room");
        lb.setForeground(Color.BLUE);
        lb.setBounds(400,20,200,30);
        lb.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lb);
        
        
        JLabel l1 = new JLabel("Room Bed Type");
        l1.setBounds(30,80,200,20);
        l1.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(l1);
        
        String str[] = {"Single Bed","Double Bed"};
        c1= new JComboBox(str);
        c1.setBounds(220,80,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Only display Available");
        c2.setBounds(800,80,150,25);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(20,150,100,20);
        l2.setFont(new Font("serif",Font.PLAIN,16));
        add(l2);
        
        JLabel l3 = new JLabel("Available");
        l3.setBounds(250,150,100,20);
        l3.setFont(new Font("serif",Font.PLAIN,16));
        add(l3);
        
        JLabel l4 = new JLabel("Cleaning Status");
        l4.setBounds(450,150,120,20);
        l4.setFont(new Font("serif",Font.PLAIN,16));
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(650,150,100,20);
        l5.setFont(new Font("serif",Font.PLAIN,16));
        add(l5);
        
        JLabel l6 = new JLabel("Price");
        l6.setBounds(850,150,150,20);
        l6.setFont(new Font("serif",Font.PLAIN,16));
        add(l6);
        
        
        
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
                 String str = "select * from room where type = '"+c1.getSelectedItem()+"'";
                 String str2 = "select * from room where available ='Available' and type = '"+c1.getSelectedItem()+"'";
                 conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
                if(c2.isSelected()){
                    rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }else{
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
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
        new searchRoom();
        
    }
}
