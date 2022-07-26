package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login implements ActionListener {
    ImageIcon imageatm=new ImageIcon("atm.png");
    JFrame f;
    JLabel l1,l2,l3;
    JTextField tf;
    JPasswordField pf;
    JButton b1,b2,b3;

    static String cardNumber;
    static String pin;
    Login(){
        //Creating a new Frame
        f=new JFrame("AUTOMATED TELLER MACHINE");

        //Creating Main label
        l1=new JLabel("WELCOME TO ATM");
        l1.setBounds(110,50,600,50);
        l1.setFont(new Font("osward",Font.BOLD,35));
        f.add(l1);

        //Creating Card no Label
        l2=new JLabel("Card No : ");
        l2.setBounds(70,170,120,30);
//        l2.setIcon(imageatm);
        l2.setFont(new Font("osward",Font.BOLD,22));
        f.add(l2);

        //Creating a pin Number Label
        l3=new JLabel("Pin No : ");
        l3.setBounds(70,270,120,30);
        l3.setFont(new Font("Osward",Font.BOLD,22));
        f.add(l3);

        //Creating a Text Field
        tf=new JTextField(20);
        tf.setBounds(210,175,200,30);
        tf.setFont(new Font("Osward",Font.PLAIN,16));
        f.add(tf);

        //Creating a PassWord Field
        pf=new JPasswordField(20);
        pf.setBounds(210,270,200,30);
        pf.setFont(new Font("Osward",Font.PLAIN,16));
        f.add(pf);

        //Creating a Login Button
        b1=new JButton("Login");
        b1.setBounds(210,330,70,30);
        b1.setFont(new Font("Osward",Font.BOLD,12));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        f.add(b1);

        //Creating a Clear Button
        b2=new JButton("Clear");
        b2.setBounds(310,330,70,30);
        b2.setFont(new Font("Osward",Font.BOLD,12));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        f.add(b2);

        //Creating a Sign Up Button
        b3=new JButton("Sign Up");
        b3.setBounds(210,390,170,30);
        b3.setFont(new Font("Osward",Font.BOLD,12));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        f.add(b3);

        //Adding Action Listeners to three Buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        //Boiler Plate Code
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);
        f.setSize(600,600);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
       try{
           Conn c1=new Conn();
           cardNumber=tf.getText();
           pin=pf.getText();
           String query="SELECT pin FROM LOGIN WHERE CARDNumber="+cardNumber+" and  pin="+pin;


           if(e.getSource()==b1){
               ResultSet rs=c1.s.executeQuery(query);
                if(rs.next()){
                    new Transactions().setVisible(true);
                    f.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(f,"Card Number and Pin Number Doesn't Match");
                }
           }
           if(e.getSource()==b2){
               tf.setText("");
               pf.setText("");
           }
           if(e.getSource()==b3){
                new SignUp().setVisible(true);
                f.setVisible(false);
           }
       }
       catch(Exception ex){
           System.out.println(ex);
       }
    }


    public static void main(String[] args) {
        new Login();
    }
}
