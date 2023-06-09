package banking.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener{
//    JDateChooser dobfield;
    JRadioButton syes,sno,eayes,eano;
    JTextField Aadharfield,panfield;
    JComboBox eqfield,incomefield, religionfield,occupationfield;
    JButton b;
    ButtonGroup sgroup,eagroup;
   static String formno;
    SignUpTwo(String formno){
        this.formno=formno;
        getContentPane().setBackground(Color.WHITE);
        setSize(950,800);
        setVisible(true);
        setLocation(300,20);
        setLayout(null);
        JLabel Personal=new JLabel("Page2 : Additional Details ");
        Personal.setBounds(290,90,400,30);
        Personal.setFont(new Font("Raleway",Font.BOLD,22));
        add(Personal);
        
        JLabel Religion=new JLabel("Religion:");
       Religion.setBounds(110,140,100,30);
        Religion.setFont(new Font("Raleway",Font.BOLD,22));
        add(Religion);
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionfield = new JComboBox(religion);
         religionfield.setBackground(Color.WHITE);
         religionfield.setFont(new Font("Raleway", Font.BOLD, 14));
         religionfield.setBounds(420,140,420,30);
        add( religionfield);
        
        JLabel Income=new JLabel("Income");
        Income.setBounds(110,220,400,30);
        Income.setFont(new Font("Raleway",Font.BOLD,22));
        add(Income);
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomefield = new JComboBox(income);
        incomefield.setBackground(Color.WHITE);
        incomefield.setFont(new Font("Raleway", Font.BOLD, 14));
        incomefield.setBounds(420,220,420,30);
        add( incomefield);
        
        JLabel eq=new JLabel("Educational Qualification:");
        eq.setBounds(110,290,400,30);
        eq.setFont(new Font("Raleway",Font.BOLD,22));
        add(eq);
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        eqfield = new JComboBox(education);
        eqfield.setBackground(Color.WHITE);
        eqfield.setFont(new Font("Raleway", Font.BOLD, 14));
        eqfield.setBounds(420,290,420,30);
        add(eqfield);
        
        JLabel email=new JLabel("Occupation:");
        email.setBounds(110,340,400,30);
        email.setFont(new Font("Raleway",Font.BOLD,22));
        add(email);
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationfield = new JComboBox(occupation);
        occupationfield.setBackground(Color.WHITE);
        occupationfield.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationfield.setBounds(420,340,420,30);
        add(occupationfield);
        
        JLabel pan=new JLabel(" PAN Number:");
        pan.setBounds(110,390,400,30);
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        add(pan);
        panfield=new JTextField();
        panfield.setBounds(420,390,420,30);
        panfield.setFont(new Font("Raleway",Font.BOLD,22));
        add(panfield);
        
        JLabel Aadhar=new JLabel(" Aadhar Number:");
        Aadhar.setBounds(110,440,400,30);
        Aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        add(Aadhar);
        Aadharfield=new JTextField();
        Aadharfield.setBounds(420,440,420,30);
        Aadharfield.setFont(new Font("Raleway",Font.BOLD,22));
        add(Aadharfield);
        
        JLabel  Senior=new JLabel(" Senior Citizen:");
        Senior.setBounds(110,490,400,30);
        Senior.setFont(new Font("Raleway",Font.BOLD,22));
        add( Senior);
        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Raleway", Font.BOLD, 14));
        syes.setBackground(Color.WHITE);
        sno = new JRadioButton("No");
        sno.setFont(new Font("Raleway", Font.BOLD, 14));
        sno.setBackground(Color.WHITE);
        syes.setBounds(420,490,100,30);
        add(syes); 
        sno.setBounds(520,490,100,30);
        add(sno);
        sgroup =new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);
        
        JLabel exist=new JLabel(" Existing Account:");
        exist.setBounds(110,540,400,30);
        exist.setFont(new Font("Raleway",Font.BOLD,22));
        add(exist);
        eayes = new JRadioButton("Yes");
        eayes.setFont(new Font("Raleway", Font.BOLD, 14));
        eayes.setBackground(Color.WHITE);
        eano = new JRadioButton("No");
        eano.setFont(new Font("Raleway", Font.BOLD, 14));
        eano.setBackground(Color.WHITE);
        eayes.setBounds(420,540,100,30);
        add(eayes); 
        eano.setBounds(520,540,100,30);
        add(eano);
        eagroup =new ButtonGroup();
        eagroup.add(eayes);
        eagroup.add(eano);
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(400,600,80,30);
        add(b);
        b.addActionListener(this);
    }
        public void actionPerformed(ActionEvent ae){
             String religion=(String)religionfield.getSelectedItem();
               String income=(String)incomefield.getSelectedItem();
               String qualification=(String)eqfield.getSelectedItem();
               String occupation=(String)occupationfield.getSelectedItem();
                String senior=null;
                 if(syes.isSelected()){ 
                senior="Yes";
                }else if(sno.isSelected()){ 
                senior = "No";
                }
              String existing=null;
                if(eayes.isSelected()){ 
                existing = "Male";
                }else if(eano.isSelected()){ 
                    existing = "Female";
                }
                String aadhar=Aadharfield.getText();
                String pan=panfield.getText();
            try{
                  if(((String)religionfield.getSelectedItem()).equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into signup2 values('"+formno+"','"+religion+"','"+income+"','"+qualification+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+existing+"')";
                c1.s.executeUpdate(q1);
                
                new SignUpThree(formno).setVisible(true);
                setVisible(false);
            }
                }
            catch(Exception e){
                 e.printStackTrace();
            }

            }
    
        public static void main(String args[]){
        new SignUpTwo(formno);
    }
}
