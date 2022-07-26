package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Transactions extends JFrame implements ActionListener {
    JLabel label;
    JButton b1,b2,b3,b4,b5,b6,b7;

    Transactions(){
        //Creating a new Frame
        label=new JLabel("Please Select Your Transaction");
        label.setBounds(60,60,500,30);
        label.setFont(new Font("System",Font.BOLD,30));
        add(label);


        //Creating a button for deposit
        b1=new JButton("Deposit");
        b1.setBounds(45,160,200,50);
        b1.setFont(new Font("System",Font.BOLD,16));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        //Creating a button for fastCash
        b2=new JButton("Fast Cash");
        b2.setBounds(45,260,200,50);
        b2.setFont(new Font("System",Font.BOLD,16));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        //Creating a button for pinChange
        b3=new JButton("Pin Change");
        b3.setBounds(45,360,200,50);
        b3.setFont(new Font("System",Font.BOLD,16));
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);


        //Creating a button for CashWithDrawl
        b4=new JButton("Cash WithDrawl");
        b4.setBounds(325,160,200,50);
        b4.setFont(new Font("System",Font.BOLD,16));
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        add(b4);

        //Creating a button for miniStatement
        b5=new JButton("Mini Statement");
        b5.setBounds(325,260,200,50);
        b5.setFont(new Font("System",Font.BOLD,16));
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        add(b5);


        //Creating a button for balanceEnquiry
        b6=new JButton("Balance Enquiry");
        b6.setBounds(325,360,200,50);
        b6.setFont(new Font("System",Font.BOLD,16));
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        add(b6);


        //Creating a button for Exit
        b7=new JButton("Exit");
        b7.setBounds(175,470,200,55);
        b7.setFont(new Font("System",Font.BOLD,16));
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        add(b7);



        //Boiler Plate Code
        setLayout(null);
        setSize(600,650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            new Deposit().setVisible(true);
            setVisible(false);
        }
        if(e.getSource()==b2){
            new FastCash().setVisible(true);
            setVisible(false);
        }
        if(e.getSource()==b3){
            new PinChange().setVisible(true);
            setVisible(false);
        }
        if(e.getSource()==b4){
            new Withdraw().setVisible(true);
            setVisible(false);
        }
        if(e.getSource()==b5){
            new Ministatement().setVisible(true);
            setVisible(false);
        }
        if(e.getSource()==b6){
            String pin=JOptionPane.showInputDialog(this,"Enter pin number");

            try{
                Conn c=new Conn();

                ResultSet rs=c.s.executeQuery("Select Balance from Bank where pin="+pin+"");

                if(rs.next()){
                    String balance=rs.getString("Balance");
                    System.out.println(balance);
                    JOptionPane.showMessageDialog(this,"Your Balance is "+balance);
                }

                rs.close();
                c.c.close();
            }
            catch (Exception ae){
                System.out.println(ae);
            }
        }
        if(e.getSource()==b7){
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new Transactions();
    }
}
