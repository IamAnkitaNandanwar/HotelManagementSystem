
package hotel.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1, m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard(){
        mb = new JMenuBar();
        m1 = new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.BLACK);
        mb.add(m1);
        
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.BLACK);
        mb.add(m2);
        
        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        
        
        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        mb.setBounds(0,0,1950,30);
        add(mb);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image ic2 = ic.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel l1 = new JLabel(ic3);
        l1.setBounds(0,0,1950,900);
        add(l1);
        
        JLabel l2 = new JLabel("THE TAJ GROUP WELCOME YOU");
        l2.setBounds(450,50,1950,40);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("serif",Font.PLAIN,40));
        l1.add(l2);
        
        setLayout(null);
        setBounds(0,0,1950,1000);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver().setVisible(true);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Dashboard().setVisible(true);
        
    }
}
