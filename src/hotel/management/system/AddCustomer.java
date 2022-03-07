
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JRadioButton r1,r2;
    JComboBox cb,cb1;
    JButton b1,b2;
    Choice c1;
    
    AddCustomer(){
        
        JLabel lb = new JLabel("ADD CUSTOMER DETAILS");
        lb.setForeground(Color.BLUE);
        lb.setBounds(100,20,300,30);
        lb.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lb);
        
        JLabel id = new JLabel("ID :");
        id.setBounds(35,70,100,25);
        id.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(id);
        
        String str[] = {"Passport","Voter-id Card","Driving Licence","Aadhar Card"};
        cb = new JComboBox(str);
        cb.setBounds(220,70,150,25);
        cb.setBackground(Color.WHITE);
        add(cb);
        
        JLabel number = new JLabel("Number :");
        number.setBounds(35,110,100,25);
        number.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(number);
        
        t2 = new JTextField();
        t2.setBounds(220,110,150,25);
        add(t2);
        
        JLabel name = new JLabel("Name :");
        name.setBounds(35,150,100,25);
        name.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(name);
        
        t3 = new JTextField();
        t3.setBounds(220,150,150,25);
        add(t3);
        
        JLabel gender = new JLabel("Gender :");
        gender.setBounds(35,190,120,25);
        gender.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,15));
        r1.setBackground(Color.WHITE);
        r1.setBounds(220,190,60,25);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,15));
        r2.setBackground(Color.WHITE);
        r2.setBounds(290,190,90,25);
        add(r2);
        
        JLabel country = new JLabel("Country :");
        country.setBounds(35,230,100,25);
        country.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(country);
        
        t4 = new JTextField();
        t4.setBounds(220,230,150,25);
        add(t4);
        
        JLabel allocate = new JLabel("Allocate Room Number :");
        allocate.setBounds(35,270,180,25);
        allocate.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(allocate);
        
        c1 = new Choice();
        c1.setBounds(220,270,150,25);
        add(c1);
        try{
            conn c = new conn();
            String str2 = "select * from room";
            ResultSet rs = c.s.executeQuery(str2);
            while(rs.next()){
                c1.add(rs.getString("room"));
            }
            
        }catch(Exception e){
               e.printStackTrace();
          }
        
        JLabel check = new JLabel("Check In :");
        check.setBounds(35,310,120,25);
        check.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(check);
        
        t5 = new JTextField();
        t5.setBounds(220,310,150,25);
        add(t5);
        
        JLabel deposit = new JLabel("Deposit :");
        deposit.setBounds(35,350,120,25);
        deposit.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(deposit);
        
        t6 = new JTextField();
        t6.setBounds(220,350,150,25);
        add(t6);
        
        
        b1 = new JButton("Add Customer");
        b1.setBounds(35,400,150,30);
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("back");
        b2.setBounds(220, 400, 150, 30);
        b2.setBackground(Color.ORANGE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
      
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
        Image ic2 = ic.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel l1 = new JLabel(ic3);
        l1.setBounds(400,50,300,400);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(370,150,750,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
        String id = (String)cb.getSelectedItem();
        String number = t2.getText();
        String name = t3.getText();
       
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
       String country = t4.getText();
        String status = t5.getText();
        String deposit = t6.getText();
        String room = c1.getSelectedItem();
        
        conn c = new conn();
        
        String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
        String str2 = "update room set available = 'Occupied' where room = '"+room+"'";
        try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);
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
        new AddCustomer();
        
    }
}
