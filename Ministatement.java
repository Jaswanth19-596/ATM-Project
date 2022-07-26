package ATM;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ministatement extends JFrame {
    JLabel l1,l2,l3,l4;
    Ministatement(){
        String query="Select * from Transactions where pin="+Login.pin;
        try{
            JLabel label;
            label=new JLabel();
            label.setText("Your Previous Transactions ");
            label.setFont(new Font("System",Font.BOLD,26));
            label.setBounds(120,50,400,40);
            add(label);


            Conn c=new Conn();
            Statement s=c.c.createStatement();
            ResultSet rs=s.executeQuery(query);
            System.out.println("Deposit    "+"WithDraw");
            System.out.println(rs.next());
            int i=0;
            while(rs.next()){
                JLabel l1,l2;
                String deposit=rs.getString("deposit");
                String withdraw=rs.getString("withdraw");

                l1=new JLabel();
                l1.setText("Deposit      WithDraw");
                l1.setFont(new Font("System",Font.BOLD,22));
                l1.setBounds(150,100,400,40);
                add(l1);




                l2=new JLabel();
                l2.setText(deposit+"                        "+withdraw);
                l2.setFont(new Font("System",Font.BOLD,18));
                l2.setBounds(150,140+i,400,40);
                add(l2);

                i=i+40;

            }

            setLayout(null);
            setSize(600,650);
            setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Ministatement();
    }
}
