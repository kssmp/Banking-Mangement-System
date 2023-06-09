
package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class PinChange extends JFrame implements ActionListener {
    static String pin;
    JLabel l1,l2,l3;
    JPasswordField t1,t2;
    JButton b1,b2;
     public PinChange (String pin){
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
        
        l1 = new JLabel("Change Your Pin");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 17));
        l1.setBounds(250,270,400,35);
        I.add(l1);
        
        l2 = new JLabel("NEW PIN");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(200,320,220,20);
        I.add(l2);
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(320,320,150,25);
        I.add(t1);
        
        l3 = new JLabel("Re-Enter NEW PIN");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setBounds(170,360,220,20);
        I.add(l3);
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 22));
        t2.setBounds(320,360,150,25);
        I.add(t2);
       
        b1 = new JButton("Change");
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
              String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }
            else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
                
            }
         
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
      }
     public static void main(String args[]){
         new PinChange(pin);
     }
    
}
