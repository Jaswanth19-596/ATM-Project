package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class PinChange extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JPasswordField pf1,pf2,pf3;
    JButton b1,b2;

    PinChange(){
        //Creating a Main Label
        l1=new JLabel("Change Your Pin");
        l1.setBounds(150,120,300,30);
        l1.setFont(new Font("System",Font.BOLD,26));
        add(l1);

        //Creating  Current Pin Label
        l2=new JLabel("Current Pin : ");
        l2.setBounds(50,200,150,30);
        l2.setFont(new Font("System",Font.BOLD,18));
        add(l2);

        //Creating  Current Pin Label
        l3=new JLabel("New Pin : ");
        l3.setBounds(50,300,150,30);
        l3.setFont(new Font("System",Font.BOLD,18));
        add(l3);

        //Creating  Current Pin Label
        l4=new JLabel("Re-Enter New Pin : ");
        l4.setBounds(50,400,200,30);
        l4.setFont(new Font("System",Font.BOLD,18));
        add(l4);

        //Creating TextField for Old pin
        pf1=new JPasswordField(30);
        pf1.setBounds(300,200,200,30);
        pf1.setFont(new Font("System",Font.BOLD,18));
        add(pf1);

        //Creating TextField for Old pin
        pf2=new JPasswordField(30);
        pf2.setBounds(300,300,200,30);
        pf2.setFont(new Font("System",Font.BOLD,18));
        add(pf2);

        //Creating TextField for Old pin
        pf3=new JPasswordField(30);
        pf3.setBounds(300,400,200,30);
        pf3.setFont(new Font("System",Font.BOLD,18));
        add(pf3);


        //Creating Save Button
        b1=new JButton("Save");
        b1.setBounds(100,500,150,40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.addActionListener(this);
        add(b1);

        //Creating back Button
        b2=new JButton("Back");
        b2.setBounds(300,500,150,40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.addActionListener(this);
        add(b2);
        //Boiler Plate Code
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(600,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){

            if(pf1.getText().equals("") || pf2.getText().equals("") || pf3.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Enter All Fields");
            }
            else{

                String pin=pf1.getText();
                if(pin.equals(Login.pin)){
                    String newPin=pf2.getText();
                    String newPin2=pf3.getText();

                    if(newPin.equals(newPin2)){
                        try{
                            Conn c=new Conn();


                            String query1="Update Login set pin ="+   newPin+"  where pin="+Integer.parseInt(pin);

                            String query2="Update SIGNUP3 set pin ="+   newPin+"  where pin="+Integer.parseInt(pin);

                            String query3="Update BANK set pin ="+   newPin+"  where pin="+Integer.parseInt(pin);

                            Statement s1=c.c.createStatement();
                            Statement s2=c.c.createStatement();
                            Statement s3=c.c.createStatement();

                            //Updating Login Table
                            s1.executeUpdate(query1);

                            //Updating SIgnup3 Table
                            s2.executeUpdate(query2);

                            //Updating Bank Table
                            s3.executeUpdate(query3);


                            JOptionPane.showMessageDialog(this,"Successfully Changed Pin");
                            setVisible(false);
                            new Transactions().setVisible(true);
                            s1.close();
                            s2.close();
                            s3.close();
                            c.c.close();
                        }
                        catch(Exception ae){
                            System.out.println(ae);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Both Pins You Entered Doesn't match");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"Enter Valid Pin");
                }
            }
        }

        if(e.getSource()==b2){
            setVisible(false);
            new Transactions().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange();
    }
}
