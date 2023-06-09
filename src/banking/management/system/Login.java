
package banking.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardfield;
    JPasswordField Pinfield;
    Login(){
        setTitle("Automate Teller Machine");
         setSize(800,480);
        setVisible(true);
        setLocation(300,150);
        setLayout(null);
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image I2=I1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);  
        JLabel label=new JLabel(I3);
        label.setBounds(50,10,100,100);
        add(label);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardNo=new JLabel("Card NO:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,40);
        add(cardNo);
        cardfield=new JTextField();
        cardfield.setBounds(300,150,250,40);
        add(cardfield);
        
        JLabel Pin=new JLabel("PIN:");
        Pin.setFont(new Font("Raleway",Font.BOLD,28));
        Pin.setBounds(120,220,150,40);
        add(Pin);
        Pinfield=new JPasswordField();
        Pinfield.setBounds(300,220,250,40);
        add(Pinfield);
        
         login =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear =new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
          
        signup =new JButton("Sign Up");
        signup.setBounds(300,370,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
          
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==login){
              Conn conn1=new Conn();
              String cardno=cardfield.getText();
              String pin=Pinfield.getText();
              String query="select * from login where cardNo='"+cardno+"'and pin='"+pin+"'";
              try{
                  ResultSet rs=conn1.s.executeQuery(query);
                  if(rs.next())
                  {
                      setVisible(false);
                      new Transactions(pin).setVisible(true);
                  }
                  else{
                      JOptionPane.showMessageDialog(null,"Incorrect pin or card number");
                  }
              }
              catch(Exception e){
                  System.out.print(e);
              }
         }
         else if(ae.getSource()==signup){
              setVisible(false);
              new SignUpone().setVisible(true);
         }
         else if(ae.getSource()==clear){
             cardfield.setText("");
             Pinfield.setText("");
         }
     }
    public static void main(String args[]){
        new Login();
    }
}
