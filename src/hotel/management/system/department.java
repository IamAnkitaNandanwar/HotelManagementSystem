
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class department extends JFrame implements ActionListener {
   
    JButton b1,b2;
    JTable t1;
    
    department(){
        JLabel l1 = new JLabel("Department");
        l1.setBounds(50,10,100,20);
        l1.setFont(new Font("serif",Font.PLAIN,16));
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(300,10,100,20);
        l2.setFont(new Font("serif",Font.PLAIN,16));
        add(l2);
       
        t1 = new JTable();
        t1.setBackground(Color.WHITE);
        t1.setFont(new Font("serif",Font.PLAIN,15));
        t1.setBounds(0,50,500,350);
        add(t1);
        
        b1 = new JButton("Search");
        b1.setBounds(100,450,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("back");
        b2.setBounds(250, 450, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(280,120,500,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == b1){
             try{
                 String str = "select * from department";
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
        new department();
        
    }
}
