
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField t1,t2,t5,t6,t7,t8;
    JRadioButton r1,r2;
    JComboBox cb;
    JButton b1;
    
    AddEmployee(){
        
        JLabel lb = new JLabel("ADD  EMPLOYEE  DETAILS");
        lb.setForeground(Color.BLUE);
        lb.setBounds(450,30,400,30);
        lb.setFont(new Font("serif",Font.BOLD,20));
        add(lb);
        
        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);
        
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,15));
        r1.setBackground(Color.WHITE);
        r1.setBounds(200,130,60,30);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,15));
        r2.setBackground(Color.WHITE);
        r2.setBounds(270,130,90,30);
        add(r2);
        
        JLabel job = new JLabel("JOB");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job);
        
        String str[] = {"Front Desk Cleak","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef","Porters"};
        cb = new JComboBox(str);
        cb.setBounds(200,180,150,30);
        cb.setBackground(Color.WHITE);
        add(cb);
        
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,230,120,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salary);
        
        t5 = new JTextField();
        t5.setBounds(200,230,150,30);
        add(t5);
        
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone);
        
        t6 = new JTextField();
        t6.setBounds(200,280,150,30);
        add(t6);
        
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60,330,120,30);
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(aadhar);
        
        t7 = new JTextField();
        t7.setBounds(200,330,150,30);
        add(t7);
        
        JLabel email = new JLabel("EMAIL");
        email.setBounds(60,380,120,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(email);
        
        t8 = new JTextField();
        t8.setBounds(200,380,150,30);
        add(t8);
        
        b1 = new JButton("Submit");
        b1.setBounds(200,430,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image ic2 = ic.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel l1 = new JLabel(ic3);
        l1.setBounds(380,60,450,450);
        add(l1);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(360,150,810,510);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String name = t1.getText();
        String age = t2.getText();
        String salary = t5.getText();
        String phone = t6.getText();
        String aadhar = t7.getText();
        String email = t8.getText();
        
        String gender = null;
        
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        
        String job = (String)cb.getSelectedItem();
        
        conn c = new conn();
        
        String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
        
        try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Employee Added");
                this.setVisible(false);
            }catch(Exception e){
                 e.printStackTrace();
            }
    }
     public static void main(String[] args) {
        // TODO code application logic here
        new AddEmployee();
        
    }
}
