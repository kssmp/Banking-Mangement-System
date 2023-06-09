
package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    static String pin;
    Transactions(String pin){
        this.pin=pin;
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
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(210,260,700,35);
        I.add(l1);
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("MINI STATEMENT");
        b4 = new JButton("PIN CHANGE");
        b5 = new JButton("BALANCE ENQUIRY");
        b6 = new JButton("EXIT");
        b1.setBounds(170,310,150,35);
        I.add(b1);
        b2.setBounds(340,310,150,35);
        I.add(b2);      
        b3.setBounds(170,350,150,35);
        I.add(b3);
        b4.setBounds(340,350,150,35);
        I.add(b4);        
        b5.setBounds(170,390,150,35);
        I.add(b5);        
        b6.setBounds(340,390,150,35);
        I.add(b6);        
                
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
//        b7.addActionListener(this);
         setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b6)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource()==b1)
        {   setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ae.getSource()==b2)
        {   setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        else if(ae.getSource()==b4)
        {   setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        else if(ae.getSource()==b5)
        {   setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(ae.getSource()==b3)
        {   setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
        
        
    }
    public static void main(String args[]){
        new Transactions(pin);
    }
}
