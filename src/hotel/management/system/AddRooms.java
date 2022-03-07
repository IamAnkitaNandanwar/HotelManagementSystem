
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    JComboBox cb ,cb1, cb2;
    JButton b1,b2;
    
    AddRooms(){
        
        JLabel lb = new JLabel("ADD ROOMS");
        lb.setForeground(Color.BLACK);
        lb.setBounds(150,20,150,20);
        lb.setFont(new Font("serif",Font.BOLD,18));
        add(lb);
        
        JLabel room = new JLabel("Room Number :");
        room.setBounds(60,80,120,30);
        room.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(room);
        
        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        JLabel available= new JLabel("Available :");
        available.setBounds(60,130,120,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(available);
        
        String str[] = {"Available","Occupied"};
        cb = new JComboBox(str);
        cb.setBounds(200,130,150,30);
        cb.setBackground(Color.WHITE);
        add(cb);
        
        JLabel status = new JLabel("Cleaning Status :");
        status.setBounds(60,180,150,30);
        status.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(status);
        
        String str1[] = {"Cleaned","Dirty"};
        cb1 = new JComboBox(str1);
        cb1.setBounds(200,180,150,30);
        cb1.setBackground(Color.WHITE);
        add(cb1);
        
        JLabel bed= new JLabel("Bed Type :");
        bed.setBounds(60,280,120,30);
        bed.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(bed);
        
        String str2[] = {"Single Bed","Double Bed"};
        cb2 = new JComboBox(str2);
        cb2.setBounds(200,280,150,30);
        cb2.setBackground(Color.WHITE);
        add(cb2);
        
        JLabel price = new JLabel("Price :");
        price.setBounds(60,230,120,30);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);
        
        t2 = new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);
        
        b1 = new JButton("Add Room");
        b1.setBounds(60,350,100,30);
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220,350,100,30);
        b2.setBackground(Color.orange);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image ic2 = ic.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel l1 = new JLabel(ic);
        l1.setBounds(400,30,500,350);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,180,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String room_number = t1.getText();
            String available = (String)cb.getSelectedItem();
            String status = (String)cb1.getSelectedItem();
            String price = t2.getText();
            String bed_type = (String)cb2.getSelectedItem();
        
        conn c = new conn();
        
        String str = "insert into room values('"+room_number+"','"+available+"','"+status+"','"+bed_type+"','"+price+"')";
        
        try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added");
                this.setVisible(false);
            }catch(Exception e){
                 e.printStackTrace();
            }
        }else if (ae.getSource() == b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new AddRooms();
        
    }
}
