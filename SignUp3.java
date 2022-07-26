package ATM;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JRadioButton r1,r2,r3,r4;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    JTextField tf;
    JButton b1,b2;

    static int applicationNumber;
    static int pinNumber;
    SignUp3(){
        //Creating a new Main Label
        l1=new JLabel("Page-3 : Account Details");
        l1.setBounds(185,40,250,30);
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        add(l1);

        //Creating a Account type label
        l2=new JLabel("Account Type : ");
        l2.setBounds(65,110,130,20);
        l2.setFont(new Font("Raleway",Font.BOLD,14));
        add(l2);

        //Creating Card Number Label
        l3=new JLabel("Card Number : ");
        l3.setBounds(65,230,130,20);
        l3.setFont(new Font("Raleway",Font.BOLD,14));
        add(l3);

        //Creating subLabel below the CardNumber Label
        l4=new JLabel("(Your 16 Digit Card Number)");
        l4.setBounds(63,250,130,20);
        l4.setFont(new Font("Raleway",Font.BOLD,9));
        add(l4);

        //Creating Card Number
        l5=new JLabel("XXXX-XXXX-XXXX-XXXX");
        l5.setBounds(230,230,180,20);
        l5.setFont(new Font("Raleway",Font.BOLD,14));
        add(l5);

        //Creating statement below the cardNumber
        l6=new JLabel("It Would appear on Atm Card / CheckBook and Statements ");
        l6.setBounds(230,250,270,20);
        l6.setFont(new Font("Raleway",Font.BOLD,9));
        add(l6);

        //Creating PIN label
        l7=new JLabel("PIN : ");
        l7.setBounds(63,280,100,20);
        l7.setFont(new Font("Raleway",Font.BOLD,14));
        add(l7);

        //Creating subLabel of PIN
        l8=new JLabel("(4 Digit Pin Number)");
        l8.setBounds(63,300,100,20);
        l8.setFont(new Font("Raleway",Font.BOLD,9));
        add(l8);


        //Creating Example Pin
        l9=new JLabel("XXXX");
        l9.setBounds(230,280,300,20);
        l9.setFont(new Font("Raleway",Font.BOLD,14));
        add(l9);

        //Creating Services required Label
        l10=new JLabel("Services Required : ");
        l10.setBounds(63,350,150,20);
        l10.setFont(new Font("Raleway",Font.BOLD,14));
        add(l10);


        //Creating Form No Label
        l11=new JLabel("Form No : "+SignUp.applicationNumber);
        l11.setBounds(460,20,180,20);
        l11.setFont(new Font("Raleway",Font.BOLD,14));
        add(l11);



        //Creating savingAccount radioButton
        r1=new JRadioButton("Savings Account");
        r1.setBounds(80,150,150,20);
        r1.setFont(new Font("Raleway",Font.BOLD,12));
        add(r1);

        //Creating FixedDepositAccount radioButton
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBounds(280,150,180,20);
        r2.setFont(new Font("Raleway",Font.BOLD,12));
        add(r2);

        //creating CurrentAccount radioButton
        r3=new JRadioButton("Current Account");
        r3.setBounds(80,180,180,20);
        r3.setFont(new Font("Raleway",Font.BOLD,12));
        add(r3);

        //Creating recurring Deposit Account radioButton
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(280,180,180,20);
        r4.setFont(new Font("Raleway",Font.BOLD,12));
        add(r4);


        //Adding all the radio buttons to a Button Group
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);  bg.add(r2);  bg.add(r3);  bg.add(r4);


        //Creating checkBoxes for Services
        cb1=new JCheckBox("ATM CARD");
        cb1.setBounds(70,390,150,20);
        cb1.setFont(new Font("Raleway",Font.BOLD,12));
        add(cb1);

        cb2=new JCheckBox("Mobile banking");
        cb2.setBounds(70,430,150,20);
        cb2.setFont(new Font("Raleway",Font.BOLD,12));
        add(cb2);

        cb3=new JCheckBox("Cheque Book");
        cb3.setBounds(70,470,150,20);
        cb3.setFont(new Font("Raleway",Font.BOLD,12));
        add(cb3);

        cb4=new JCheckBox("Internet Banking");
        cb4.setBounds(230,390,180,20);
        cb4.setFont(new Font("Raleway",Font.BOLD,12));
        add(cb4);

        cb5=new JCheckBox("Email Alerts");
        cb5.setBounds(230,430,180,20);
        cb5.setFont(new Font("Raleway",Font.BOLD,12));
        add(cb5);

        cb6=new JCheckBox("E-Statement");
        cb6.setBounds(230,470,180,20);
        cb6.setFont(new Font("Raleway",Font.BOLD,12));
        add(cb6);

        //Creating last checkBox like i agreed to the terms and conditions
        cb7=new JCheckBox("I Hereby declare that the above entered details are correct to the best of my knowledge");
        cb7.setBounds(40,520,500,20);
        cb7.setFont(new Font("Raleway",Font.BOLD,9));
        add(cb7);

        //Creating Submit Button
        b1=new JButton("Submit");
        b1.setBounds(140,560,80,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        //Creating Canacel Button
        b2=new JButton("Cancel");
        b2.setBounds(270,560,80,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);


        //Boiler Plate Code
        setLayout(null);
        setSize(600,650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            String accountType = "";

            if (r1.isSelected()) {
                accountType = "Savings Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring deposit Account";
            }


            //Creating Random CardNumber by keeping First 8 digits as same
            long firstEight = Math.abs((long) (Math.random() * 10000L));
            long cardNumber = firstEight + 701340550000L;
            System.out.println(cardNumber);

            Random ran = new Random();
            //Creating a random pinNumber
            pinNumber = Math.abs(ran.nextInt(9999 - 1000) + 1000);
            System.out.println(pinNumber);
            String servicesRequired = "";
            if (cb1.isSelected()) {
                servicesRequired += cb1.getText() + " ";
            }
            if (cb2.isSelected()) {
                servicesRequired += cb2.getText() + " ";
            }
            if (cb3.isSelected()) {
                servicesRequired += cb3.getText() + " ";
            }
            if (cb4.isSelected()) {
                servicesRequired += cb4.getText() + " ";
            }
            if (cb5.isSelected()) {
                servicesRequired += cb5.getText() + " ";
            }
            if (cb6.isSelected()) {
                servicesRequired += cb6.getText();
            }

            System.out.println(servicesRequired);
            //If any of the fields are empty
            if (accountType.equals("") || !cb7.isSelected()) {
                JOptionPane.showMessageDialog(this, "Fill in the Required Fields");
            } else {
                try {
                    System.out.println("hello");
                    //Establishes the connection
                    Conn c = new Conn();
                    //Inserting into Signup3 Table
                    String query = "INSERT INTO SIGNUP3 VALUES(?,?,?,?,?)";
                    PreparedStatement ps = c.c.prepareStatement(query);
                    ps.setInt(1, applicationNumber);
                    ps.setLong(2, cardNumber);
                    ps.setInt(3, pinNumber);
                    ps.setString(4, accountType);
                    ps.setString(5, servicesRequired);

                    //Inserts values into Table
                    ps.executeUpdate();


                    //Inserting into login table
                    String query2 = "Insert Into Login Values(?,?)";
                    PreparedStatement ps2 = c.c.prepareStatement(query2);

                    ps2.setLong(1, cardNumber);
                    ps2.setInt(2, pinNumber);

                    //Inserts values into table
                    ps2.executeUpdate();

                    ps.close();
                    ps2.close();
                    c.c.close();

                    JOptionPane.showMessageDialog(this, "Card number :  " + cardNumber + " pin : " + pinNumber);


                    //Setting These Because we are using them in Deposit which automatically opens after this
                    Login.cardNumber=Long.toString(cardNumber);
                    Login.pin=Integer.toString(pinNumber);
                    new Deposit().setVisible(true);
                    setVisible(false);

                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }
        }
    if (e.getSource() == b2) {
        JOptionPane.showMessageDialog(this, "You Cancelled the SignUp Operation");
        System.exit(0);
    }

}


    public static void main(String[] args) {
        new SignUp3();
    }
}
