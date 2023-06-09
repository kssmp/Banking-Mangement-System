
package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class Withdrawl extends JFrame implements ActionListener {
    static String pin;
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
     public Withdrawl (String pin){
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
        
        l1 = new JLabel("MAXIMUM WITHDRAWL IS RS 10000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setBounds(200,270,400,35);
        I.add(l1);
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(200,320,400,20);
        I.add(l2);
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(200,345,250,25);
        I.add(t1);
        
        b1 = new JButton("Withdraw");
        b2 = new JButton("BACK");
         b1.setBounds(330,408,150,25);
        I.add(b1); 
        b2.setBounds(330,438,150,25);
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
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(Integer.parseInt(amount)>10000){
                        JOptionPane.showMessageDialog(null, "Can not withdraw more than 10000");
                        return;
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
      }
     public static void main(String args[]){
         new Withdrawl(pin);
     }
    
}
