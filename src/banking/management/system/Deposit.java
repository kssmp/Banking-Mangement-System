package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener  {
    JLabel l1;
    JTextField t1;
    JButton b1,b2;
    static String PinNo;
    public Deposit (String pin){
        PinNo=pin;
        setSize(860,880);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2= i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(I2);
        JLabel I=new JLabel(i3);
        I.setBounds(0, 0, 860, 780);
        add(I);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setBounds(175,270,400,35);
        I.add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(175,315,300,25);
        I.add(t1);
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
         b1.setBounds(330,388,150,35);
        I.add(b1); 
        b2.setBounds(330,428,150,35);
        I.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
     public void actionPerformed(ActionEvent ae){
         try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+PinNo+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(PinNo).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(PinNo).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
     }
    public static void main(String args[]){
    new Deposit(PinNo);    
    }
    
}
