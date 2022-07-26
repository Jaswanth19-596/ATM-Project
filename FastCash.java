package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FastCash extends JFrame implements ActionListener {
    JLabel l1,l2;
    JPasswordField pf;
    JButton b1,b2,b3,b4,b5,b6,b7;

    FastCash(){
        //Creating main label
        l1=new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setBounds(80,100,400,30);
        l1.setFont(new Font("System",Font.BOLD,26));
        add(l1);

        //Creating Enter Pin Label
        l2=new JLabel("Pin : ");
        l2.setBounds(470,20,40,20);
        l2.setFont(new Font("System",Font.BOLD,16));
        add(l2);

        //Creating TextField
        pf=new JPasswordField(30);
        pf.setBounds(510,20,40,20);
        pf.setFont(new Font("System",Font.BOLD,16));
        add(pf);


        //Creating Buttons
        b1=new JButton("100");
        b1.setBounds(80,200,160,45);
        b1.setFont(new Font("System",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        add(b1);


        b2=new JButton("500");
        b2.setBounds(80,300,160,45);
        b2.setFont(new Font("System",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        add(b2);


        b3=new JButton("1000");
        b3.setBounds(80,400,160,45);
        b3.setFont(new Font("System",Font.BOLD,16));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        add(b3);


        b4=new JButton("2000");
        b4.setBounds(330,200,160,45);
        b4.setFont(new Font("System",Font.BOLD,16));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);
        add(b4);


        b5=new JButton("5000");
        b5.setBounds(330,300,160,45);
        b5.setFont(new Font("System",Font.BOLD,16));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.white);
        add(b5);


        b6=new JButton("10000");
        b6.setBounds(330,400,160,45);
        b6.setFont(new Font("System",Font.BOLD,16));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.white);
        add(b6);


        b7=new JButton("Exit");
        b7.setBounds(200,500,160,45);
        b7.setFont(new Font("System",Font.BOLD,16));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.white);
        add(b7);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);


        //Boiler Plate Code
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(600,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){


        double balance=0;

        if(e.getSource()==b7){
            System.exit(0);
        }

        if(pf.getText().equals("") || !(pf.getText().equals(Login.pin))){
                JOptionPane.showMessageDialog(this,"Enter Proper Pin");
        }
        else{
            int pin=Integer.parseInt(pf.getText());
            double userAmount=0;
            try{
                Conn c=new Conn();
                Statement s=c.c.createStatement();

                String queryForBalance="Select balance from Bank where pin="+pin;

                ResultSet rs=s.executeQuery(queryForBalance);
                if(rs.next()){
                    balance=rs.getDouble("balance");
                }


                if(e.getSource()==b1){
                    if(balance<Integer.parseInt(b1.getText())){
                        JOptionPane.showMessageDialog(this,"Balance Amount is "+balance+" only");
                    }
                    else{
                        userAmount=Integer.parseInt(b1.getText());
                        balance=balance-userAmount;
                        String query="Update BANK SET BALANCE="+balance+" where pin="+pin+" ;";
                        System.out.println(balance);
                        s.executeUpdate(query);
                        JOptionPane.showMessageDialog(this,b1.getText()+"Rs has Been Debited");
                    }
                }
                if(e.getSource()==b2){
                    if(balance<Integer.parseInt(b2.getText())){
                        JOptionPane.showMessageDialog(this,"Balance Amount is "+balance+" only");
                    }
                    else{
                        userAmount=Integer.parseInt(b2.getText());
                        balance=balance-userAmount;
                        String query="Update BANK SET BALANCE="+balance+" where pin="+pin+" ;";
                        s.executeUpdate(query);
                        JOptionPane.showMessageDialog(this,b2.getText()+"Rs has Been Debited");
                    }
                }
                if(e.getSource()==b3){
                    if(balance<Integer.parseInt(b3.getText())){
                        JOptionPane.showMessageDialog(this,"Balance Amount is "+balance+" only");
                    }
                    else{
                        userAmount=Integer.parseInt(b3.getText());
                        balance=balance-userAmount;
                        String query="Update BANK SET BALANCE="+balance+" where pin="+pin+" ;";
                        s.executeUpdate(query);
                        JOptionPane.showMessageDialog(this,b3.getText()+"Rs has Been Debited");
                    }
                }
                if(e.getSource()==b4){
                    if(balance<Integer.parseInt(b4.getText())){
                        JOptionPane.showMessageDialog(this,"Balance Amount is "+balance+" only");
                    }
                    else{
                        userAmount=Integer.parseInt(b4.getText());
                        balance=balance-userAmount;
                        String query="Update BANK SET BALANCE="+balance+" where pin="+pin+" ;";
                        s.executeUpdate(query);
                        JOptionPane.showMessageDialog(this,b4.getText()+"Rs has Been Debited");
                    }
                }
                if(e.getSource()==b5){
                    if(balance<Integer.parseInt(b5.getText())){
                        JOptionPane.showMessageDialog(this,"Balance Amount is "+balance+" only");
                    }
                    else{
                        userAmount=Integer.parseInt(b5.getText());
                        balance=balance-userAmount;
                        String query="Update BANK SET BALANCE="+balance+" where pin="+pin+" ;";
                        s.executeUpdate(query);
                        JOptionPane.showMessageDialog(this,b5.getText()+"Rs has Been Debited");
                    }
                }
                if(e.getSource()==b6){
                    if(balance<Integer.parseInt(b5.getText())){
                        JOptionPane.showMessageDialog(this,"Balance Amount is "+balance+" only");
                    }
                    else{
                        userAmount=Integer.parseInt(b6.getText());
                        balance=balance-userAmount;
                        String query="Update BANK SET BALANCE="+balance+" where pin="+pin+" ;";
                        s.executeUpdate(query);
                        JOptionPane.showMessageDialog(this,b6.getText()+"Rs has Been Debited");
                    }

                }

                //Inserting Into Transactions
                String q2="Insert into Transactions (pin,deposit,Withdraw) values(?,?,?)";
                PreparedStatement ps2=c.c.prepareStatement(q2);
                ps2.setInt(1,pin);
                ps2.setString(2,null);
                ps2.setString(3,Double.toString(userAmount));
                ps2.executeUpdate();

                new Transactions().setVisible(true);
                setVisible(false);
            }
            catch(Exception ae){
                System.out.println(ae);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash();
    }
}
