package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Withdraw extends JFrame implements ActionListener{
        JLabel l1, l2, l3;
        JTextField tf1, tf2;
        JButton b1, b2, b3;

    Withdraw() {
            //creating main Label
            l1 = new JLabel("Enter Amount You Want To Withdraw");
            l1.setBounds(60, 80, 500, 40);
            l1.setFont(new Font("System", Font.BOLD, 26));
            add(l1);

            //creating main Label
            l3 = new JLabel("Maximum Amount You Can WithDraw is 10000 per Day");
            l3.setBounds(85, 135, 500, 40);
            l3.setFont(new Font("System", Font.BOLD, 16));
            add(l3);

            //Creating Pin Number label
            l2 = new JLabel("Pin ");
            l2.setBounds(480, 20, 50, 20);
            l2.setFont(new Font("System", Font.BOLD, 16));
            add(l2);

            //Creating Pin Number Text Field
            tf1 = new JTextField(4);
            tf1.setBounds(520, 20, 50, 20);
            tf1.setFont(new Font("System", Font.BOLD, 16));
            add(tf1);

            //Creating text field for entering amount
            tf2 = new JTextField(10);
            tf2.setBounds(180, 190, 200, 30);
            add(tf2);

            //creating Deposit Button
            b1 = new JButton("Withdraw");
            b1.setBounds(150, 280, 100, 40);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.white);
            b1.addActionListener(this);
            add(b1);


            //creating Back Button
            b2 = new JButton("Back");
            b2.setBounds(300, 280, 100, 40);
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.white);
            b2.addActionListener(this);
            add(b2);

            //Creating Exit Button
            b3 = new JButton("Exit");
            b3.setBounds(225, 370, 100, 40);
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.white);
            b3.addActionListener(this);
            add(b3);


            //Boiler Plate code
            setLayout(null);
            setSize(600, 650);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {

                //Gets the entered Amount
                String amount = "";
                amount = tf2.getText();


                //Gets the Entered Pin Number
                String pin = "";
                pin = tf1.getText();


                //If The Entered pin not Matches The Pin With CardNumber
                if ( pin.equals("") || Integer.parseInt(pin) != getPin()) {
                    JOptionPane.showMessageDialog(this, "Enter valid Pin");
                }
                else{

                    //If the amount or pin fields are empty or entered money is negative
                    if (amount.equals("") || Integer.parseInt(amount)<0) {
                        JOptionPane.showMessageDialog(this, "Enter valid Amount ");
                    }
                    else {

                        //Gets the Recently modified Row of Bank Table
                        String query = "Select balance from bank where pin=" + Integer.parseInt(pin);

                        try {

                            //Creates the connection
                            Conn c = new Conn();
                            ResultSet rs = c.s.executeQuery(query);

                            //If the user didn't Deposited Any Money
                            if (!rs.next()) {
                               JOptionPane.showMessageDialog(this,"First Deposit to With Draw");
                            }

                            else {
                                //gets the balance from Database
                                double balance = rs.getDouble("balance");

                                //Gets the balance from User
                                Double userAmount = Double.parseDouble(amount);

                                //If User Entered more Amount than the balance
                                if (userAmount > balance) {
                                    JOptionPane.showMessageDialog(this, "You Have only " + balance + " rs");
                                }
                                else if(userAmount>10000){
                                    JOptionPane.showMessageDialog(this,"You Can Withdraw only 10000 per day");
                                }
                                else {
                                    balance=balance-userAmount;
                                    String q1 = "UPDATE BANK SET BALANCE=" + balance + " where pin=" + pin;
                                    Statement s = c.c.createStatement();
                                    s.executeUpdate(q1);



                                    //Inserting Into Transactions
                                    String q2="Insert into Transactions (pin,deposit,Withdraw) values(?,?,?)";
                                    PreparedStatement ps2=c.c.prepareStatement(q2);
                                    ps2.setInt(1,Integer.parseInt(pin));
                                    ps2.setString(2,null);
                                    ps2.setString(3,Double.toString(userAmount));
                                    ps2.executeUpdate();

                                    JOptionPane.showMessageDialog(this, "Succesfully WithDrew Money");
                                }
                            }

                            //Opens Transactions Frame
                            new Transactions().setVisible(true);
                            setVisible(false);
                        }
                        catch (Exception ae) {
                            System.out.println(ae);
                        }
                    }
                }
            }

            //If Back Button Is Clicked Then open Transactions frame
            if(e.getSource()==b2){
                setVisible(false);
                new Transactions().setVisible(true);
            }

            //If Exit Button Is Clicked Then Stop The Application
            if(e.getSource()==b3){
                System.exit(0);
            }
        }


        //returns The Pin Used while Logging in
        int getPin() {
            Conn c = new Conn();
            String query = "Select pin from login where cardnumber=" + Login.cardNumber;
            int pin = 0;
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    pin = rs.getInt("Pin");
                } else {
                    pin = 0;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            finally {
                System.out.println(pin);
                return (pin);
            }
        }


        public static void main(String[] args) {
            new ATM.Withdraw();
        }
    }


