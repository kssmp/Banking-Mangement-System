
package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.Date;
import java.sql.*;
//String pin
public class BalanceEnquiry extends JFrame implements ActionListener {
    static String pin;
    JLabel l1,l2,l3;
    JPasswordField t1,t2;
    JButton b1,b2;
     public  BalanceEnquiry(String pin){
         this.pin=pin;
          setSize(860,880);
        setLocation(300,0);
        setUndecorated(true);
       
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2= i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(I2);
        JLabel I=new JLabel(i3);
        I.setBounds(0, 0, 860, 780);
        add(I);
        
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setBounds(190, 350, 400, 35);
        I.add(l1);
        
        b1 = new JButton("BACK");
        setLayout(null);
        b1.setBounds(330,438,150,25);
        I.add(b1);
        int balance = 0;
         try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);
         setVisible(true);
        
     }
      public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
     public static void main(String args[]){
         new BalanceEnquiry(pin);
     }
    
}
