package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUp2 extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JComboBox<String> cb1,cb2,cb3,cb4,cb5;
    JTextField tf1,tf2,tf3;
    JRadioButton r1,r2,r3,r4;
    JButton b;

    SignUp2(){

        //Creating Main Label
        l1=new JLabel("Page-2 : Additional Details");
        l1.setBounds(165,20,250,30);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        add(l1);

        //Creating religion label
        l2=new JLabel("Religion : ");
        l2.setBounds(60,100,100,20);
        l2.setFont(new Font("Raleway",Font.BOLD,13));
        add(l2);

        //Creating Category label
        l3=new JLabel("Category : ");
        l3.setBounds(60,150,100,20);
        l3.setFont(new Font("Raleway",Font.BOLD,13));
        add(l3);

        //Creating Income label
        l4=new JLabel("Income : ");
        l4.setBounds(60,200,100,20);
        l4.setFont(new Font("Raleway",Font.BOLD,13));
        add(l4);

        //Creating Educational Qualification label with two labels since it takes too much space
        l5=new JLabel("Educational");
        l5.setBounds(60,250,100,20);
        l5.setFont(new Font("Raleway",Font.BOLD,13));
        add(l5);

        l6=new JLabel("Qualification : ");
        l6.setBounds(60,270,100,20);
        l6.setFont(new Font("Raleway",Font.BOLD,13));
        add(l6);

        //Creating Occupation label
        l7=new JLabel("Occupation : ");
        l7.setBounds(60,320,120,20);
        l7.setFont(new Font("Raleway",Font.BOLD,13));
        add(l7);

        //Creating aadhar card label
        l8=new JLabel("Aadhar Number : ");
        l8.setBounds(60,370,120,20);
        l8.setFont(new Font("Raleway",Font.BOLD,13));
        add(l8);

        //Creating Pan card Label
        l9=new JLabel("PAN Number : ");
        l9.setBounds(60,420,120,20);
        l9.setFont(new Font("Raleway",Font.BOLD,13));
        add(l9);

        //Creating Senior Citizen label
        l10=new JLabel("Senior Citizen : ");
        l10.setBounds(60,470,120,20);
        l10.setFont(new Font("Raleway",Font.BOLD,13));
        add(l10);

        //Creating Existing Account label
        l11=new JLabel("Existing account : ");
        l11.setBounds(60,520,120,20);
        l11.setFont(new Font("Raleway",Font.BOLD,13));
        add(l11);


        //ComboBoxes
        //Creating Religion ComboBox
        String []religion={"Christian","Muslim","Hindu","Sikh","Other"};
        cb1=new JComboBox<>(religion);
        cb1.setBounds(210,100,300,20);
        cb1.setFont(new Font("Raleway",Font.BOLD,12));
        cb1.setBackground(Color.white);
        cb1.setForeground(Color.black);
        add(cb1);

        //Creating Category ComboBox
        String []category={"General","OBC","SC","ST","Other"};
        cb2=new JComboBox<>(category);
        cb2.setBounds(210,150,300,20);
        cb2.setFont(new Font("Raleway",Font.BOLD,12));
        cb2.setBackground(Color.white);
        add(cb2);

        //Creating Income comboBox
        String []income={"null","<10000","<20000","<30000","<50000",">50000"};
        cb3=new JComboBox<>(income);
        cb3.setBounds(210,200,300,20);
        cb3.setFont(new Font("Raleway",Font.BOLD,12));
        cb3.setBackground(Color.white);
        add(cb3);

        //Creating Educational Qualification ComboBox
        String []education={"Graduate","Non-Graduate","Phd"};
        cb4=new JComboBox<>(education);
        cb4.setBounds(210,260,300,20);
        cb4.setFont(new Font("Raleway",Font.BOLD,12));
        cb4.setBackground(Color.white);
        add(cb4);

        //Creating Occupation comboBox
        String []occupation={"Salaried","Self-Employeed","Business","Student","Retired","Other"};
        cb5=new JComboBox<>(occupation);
        cb5.setBounds(210,320,300,20);
        cb5.setFont(new Font("Raleway",Font.BOLD,12));
        cb5.setBackground(Color.white);
        add(cb5);

        //Creating Aadhar Number textField
        tf1=new JTextField(30);
        tf1.setBounds(210,370,300,20);
        tf1.setFont(new Font("Raleway",Font.BOLD,12));
        add(tf1);

        //creating pan number textField
        tf2=new JTextField(30);
        tf2.setBounds(210,420,300,20);
        tf2.setFont(new Font("Raleway",Font.BOLD,12));
        add(tf2);

        //Creating radioButtons for seniorCitizen
        r1=new JRadioButton("Yes");
        r1.setBounds(210,470,80,20);
        r1.setFont(new Font("Raleway",Font.BOLD,12));
        add(r1);


        r2=new JRadioButton("No");
        r2.setBounds(330,470,80,20);
        r2.setFont(new Font("Raleway",Font.BOLD,12));
        add(r2);

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(r1);  bg1.add(r2);


        r3=new JRadioButton("Yes");
        r3.setBounds(210,520,80,20);
        r3.setFont(new Font("Raleway",Font.BOLD,12));
        add(r3);


        r4=new JRadioButton("No");
        r4.setBounds(330,520,80,20);
        r4.setFont(new Font("Raleway",Font.BOLD,12));
        add(r4);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(r3);  bg2.add(r4);

        //Form No label
        l12=new JLabel("Form No : "+SignUp.applicationNumber);
        l12.setBounds(450,10,180,20);
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        add(l12);


        //Creating Button
        b=new JButton("Next");
        b.setBounds(450,570,80,30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.white);
        System.out.println(this);
        b.addActionListener(this);
        add(b);
        System.out.println("hello");
        //Boiler Plate Code
        setLayout(null);
        setSize(600,650);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        String religion=(String) cb1.getSelectedItem();
        String category=(String) cb2.getSelectedItem();
        String income=(String) cb3.getSelectedItem();
        String education=(String) cb4.getSelectedItem();
        String occupation=(String) cb5.getSelectedItem();
        String aadharNumber=(String) tf1.getText();
        String paNumber=(String) tf2.getText();
        String seniorCitizen="";
        String existingAccount="";
        if(r1.isSelected()){
            seniorCitizen="Yes";
        }
        if(r2.isSelected()){
            seniorCitizen="No";
        }

        if(r3.isSelected()){
            existingAccount="Yes";
        }
        if(r4.isSelected()){
            existingAccount="No";
        }

        //Checking if any of the entries are left empty
        if(aadharNumber.equals("") || paNumber.equals("") || seniorCitizen.equals("") || existingAccount.equals("")){
                JOptionPane.showMessageDialog(this,"Fields Cannot be Empty");
        }

        else{

            try{
                Conn obj=new Conn();
                String query="Insert into SignUp2 values(?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement ps=obj.c.prepareStatement(query);
                ps.setInt(1,SignUp.applicationNumber);
                ps.setString(2,religion);
                ps.setString(3,category);
                ps.setString(4,income);
                ps.setString(5,education);
                ps.setString(6,occupation);
                ps.setString(7,paNumber);
                ps.setString(8,aadharNumber);
                ps.setString(9,seniorCitizen);
                ps.setString(10,existingAccount);

                ps.executeUpdate();
                System.out.println("Success");

                //closing resources
                ps.close();
                obj.c.close();
                new SignUp3().setVisible(true);
                setVisible(false);
            }
            catch(Exception ae){
                System.out.println(ae);
            }
        }

    }

    public static void main(String[] args) {
        new SignUp2();
    }
}
