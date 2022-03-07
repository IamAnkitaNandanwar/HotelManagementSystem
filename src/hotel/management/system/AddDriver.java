
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    JComboBox cb;
    JButton b1,b2;
    
    AddDriver(){
         JLabel lb = new JLabel("ADD DRIVERS");
        lb.setForeground(Color.BLACK);
        lb.setBounds(150,10,150,20);
        lb.setFont(new Font("serif",Font.BOLD,16));
        add(lb);
        
        JLabel name = new JLabel("NAME :");
        name.setBounds(60,60,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,60,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE :");
        age.setBounds(60,100,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200,100,150,30);
        add(t2);
        
        JLabel gender = new JLabel("GENDER :");
        gender.setBounds(60,140,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,15));
        r1.setBackground(Color.WHITE);
        r1.setBounds(200,140,60,30);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,15));
        r2.setBackground(Color.WHITE);
        r2.setBounds(270,140,90,30);
        add(r2);
        
        JLabel company = new JLabel("Car Company :");
        company.setBounds(60,180,120,30);
        company.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(company);
        
        t3 = new JTextField();
        t3.setBounds(200,180,150,30);
        add(t3);
        
        JLabel model = new JLabel("Car Model :");
        model.setBounds(60,220,120,30);
        model.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(model);
        
        t4 = new JTextField();
        t4.setBounds(200,220,150,30);
        add(t4);
        
        JLabel available = new JLabel("Available :");
        available.setBounds(60,260,150,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(available);
        
        String str1[] = {"Available","Busy"};
        cb = new JComboBox(str1);
        cb.setBounds(200,260,150,30);
        cb.setBackground(Color.WHITE);
        add(cb);
        
        JLabel location = new JLabel("Location :");
        location.setBounds(60,300,120,30);
        location.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(location);
        
        t5 = new JTextField();
        t5.setBounds(200,300,150,30);
        add(t5);
        
         b1 = new JButton("Add Driver");
        b1.setBounds(60,360,100,30);
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
         b2 = new JButton("Cancel");
        b2.setBounds(220,360,100,30);
        b2.setBackground(Color.ORANGE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image ic2 = ic.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel l1 = new JLabel(ic3);
        l1.setBounds(400,40,500,350);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,180,950,470);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String name= t1.getText();
            String age = t2.getText();
            String gender = null;
        
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        String company = t3.getText();
        String model = t4.getText();
            String available = (String)cb.getSelectedItem();
            String location = t5.getText();
        
        conn c = new conn();
        
        String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
        
        try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Driver Added");
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
        new AddDriver();
        
    }
}
