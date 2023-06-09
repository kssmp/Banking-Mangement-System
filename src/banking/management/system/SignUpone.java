package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class SignUpone extends JFrame implements ActionListener{
    long random;
    JDateChooser dobfield;
    JRadioButton Male,Female;
    JTextField Pincodefield,Cityfield,addressfield,Statefield,namefield,fnamefield,emailfield;
    ButtonGroup gendergroup;
    JButton b;
    SignUpone(){
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(300,20);
        setLayout(null);
        
        Random ran=new Random();
         random=Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel formNo=new JLabel("APPLICATION FORM NO. "+random);
        formNo.setBounds(170,30,600,40);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        add(formNo);
        
        JLabel Personal=new JLabel("Page1 : Personal Details ");
        Personal.setBounds(290,90,400,30);
        Personal.setFont(new Font("Raleway",Font.BOLD,22));
        add(Personal);
        
        JLabel name=new JLabel("Name:");
        name.setBounds(110,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,22));
        add(name);
        namefield=new JTextField();
        namefield.setBounds(300,140,400,30);
        namefield.setFont(new Font("Raleway",Font.BOLD,22));
        add(namefield);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setBounds(110,190,400,30);
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        add(fname);
        fnamefield=new JTextField();
        fnamefield.setBounds(300,190,400,30);
        fnamefield.setFont(new Font("Raleway",Font.BOLD,22));
        add(fnamefield);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setBounds(110,240,400,30);
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        add(dob);
        dobfield=new JDateChooser();
        dobfield.setBounds(300,240,400,30);
        dobfield.setFont(new Font("Raleway",Font.BOLD,22));
        add(dobfield);
        
        JLabel gender=new JLabel("Gender:");
        gender.setBounds(110,290,400,30);
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        add(gender);
         Male=new JRadioButton("Male");
        Male.setBounds(300,290,120,30);
        Male.setBackground(Color.WHITE);
        add(Male);     
         Female=new JRadioButton("Female");
        Female.setBounds(450,290,120,30);
        Female.setBackground(Color.WHITE);
        add(Female);
        gendergroup =new ButtonGroup();
        gendergroup.add(Male);
        gendergroup.add(Female);
        
        JLabel email=new JLabel("Email Address:");
        email.setBounds(110,340,400,30);
        email.setFont(new Font("Raleway",Font.BOLD,22));
        add(email);
        emailfield=new JTextField();
        emailfield.setBounds(300,340,400,30);
        emailfield.setFont(new Font("Raleway",Font.BOLD,22));
        add(emailfield);
        
        JLabel address=new JLabel(" Address:");
        address.setBounds(110,390,400,30);
        address.setFont(new Font("Raleway",Font.BOLD,22));
        add(address);
        addressfield=new JTextField();
        addressfield.setBounds(300,390,400,30);
        addressfield.setFont(new Font("Raleway",Font.BOLD,22));
        add(addressfield);
        
        JLabel City=new JLabel(" City:");
        City.setBounds(110,440,400,30);
        City.setFont(new Font("Raleway",Font.BOLD,22));
        add(City);
        Cityfield=new JTextField();
        Cityfield.setBounds(300,440,400,30);
        Cityfield.setFont(new Font("Raleway",Font.BOLD,22));
        add(Cityfield);
        
        JLabel State=new JLabel(" State:");
        State.setBounds(110,490,400,30);
        State.setFont(new Font("Raleway",Font.BOLD,22));
        add(State);
        Statefield=new JTextField();
        Statefield.setBounds(300,490,400,30);
        Statefield.setFont(new Font("Raleway",Font.BOLD,22));
        add(Statefield);
        
        JLabel Pincode=new JLabel(" Pincode:");
        Pincode.setBounds(110,540,400,30);
        Pincode.setFont(new Font("Raleway",Font.BOLD,22));
        add(Pincode);
        Pincodefield=new JTextField();
        Pincodefield.setBounds(300,540,400,30);
        Pincodefield.setFont(new Font("Raleway",Font.BOLD,22));
        add(Pincodefield);
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(400,600,80,30);
        add(b);
        b.addActionListener(this);
    }
        public void actionPerformed(ActionEvent ae){
            String formno=""+random;
            String name=namefield.getText();
            String fname=fnamefield.getText();
            String dob=((JTextField) dobfield.getDateEditor().getUiComponent()).getText();
            String gender=null;
             if(Male.isSelected()){ 
            gender = "Male";
            }else if(Female.isSelected()){ 
                gender = "Female";
            }
            String email=emailfield.getText();
            String address=addressfield.getText();
            String pin=Pincodefield.getText();
            String city=Cityfield.getText();
            String state=Statefield.getText();
            
             try{
           
            if(namefield.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c1.s.executeUpdate(q1);
                setVisible(false);
                 new SignUpTwo(formno).setVisible(true);
            }
            }catch(Exception e){
                 e.printStackTrace();
            }

            }
    
        public static void main(String args[]){
        new SignUpone();
    }
}
