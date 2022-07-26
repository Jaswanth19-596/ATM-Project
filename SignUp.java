package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JRadioButton r1,r2,r3,r4;
    JComboBox<String> date,month,year;
    JButton b;

    //Using this for a primary key
    static int applicationNumber;
    SignUp(){
        //Creating a random number
        Random ran=new Random();
        applicationNumber=ran.nextInt(9999-1000)+1000;
        System.out.println("APplica "+applicationNumber);
        //Creating The main Label
        l1=new JLabel("APPLICATION FORM NO : "+applicationNumber);
        l1.setBounds(70,20,600,30);
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        add(l1);

        //Creating sub Main label
        l2=new JLabel("Page 1 : Personal Details");
        l2.setBounds(190,60,200,30);
        l2.setFont(new Font("Osward",Font.BOLD,15));
        add(l2);

        //Creating a Name Label
        l3=new JLabel("Name : ");
        l3.setBounds(50,110,130,20);
        l3.setFont(new Font("Osward",Font.BOLD,15));
        add(l3);

        //Adding Text Field for Name
        tf1=new JTextField(30);
        tf1.setBounds(210,110,300,21);
        add(tf1);

        //Creating Father's Name Label
        l4=new JLabel("Father Name : ");
        l4.setBounds(50,150,130,20);
        l4.setFont(new Font("Osward",Font.BOLD,15));
        add(l4);

        //Adding text field to father's name
        tf2=new JTextField(30);
        tf2.setBounds(210,150,300,21);
        add(tf2);

        //Creating Date Of Birth label
        l5=new JLabel("Date Of Birth : ");
        l5.setBounds(50,190,130,20);
        l5.setFont(new Font("Osward",Font.BOLD,15));
        add(l5);

        //Created Date of Birth ComboBoxes
        createDOB();

        //Creating Gender Label
        l6=new JLabel("Gender : ");
        l6.setBounds(50,230,100,20);
        l6.setFont(new Font("Osward",Font.BOLD,15));
        add(l6);

        //Creates Gender RadioButtons
        createGenderRadioButtons();

        //Creating Email Address Label
        l7=new JLabel("Email Address : ");
        l7.setBounds(50,270,120,20);
        l7.setFont(new Font("Osward",Font.BOLD,15));
        add(l7);

        //Adding TextField to Email Address
        tf3=new JTextField(30);
        tf3.setBounds(210,270,300,21);
        add(tf3);

        //Creating Martial Status
        l8=new JLabel("Martial Status : ");
        l8.setBounds(50,310,120,20);
        l8.setFont(new Font("Osward",Font.BOLD,15));
        add(l8);

        //Creates martial Status RadioButtons
        createMartialStatusRadioButtons();

        //Creating Address label
        l9=new JLabel("Address : ");
        l9.setBounds(50,350,100,20);
        l9.setFont(new Font("Osward",Font.BOLD,15));
        add(l9);

        //Adding TextField for Address
        tf4=new JTextField(30);
        tf4.setBounds(210,350,300,21);
        add(tf4);

        //Creating city label
        l10=new JLabel("City : ");
        l10.setBounds(50,390,100,20);
        l10.setFont(new Font("Osward",Font.BOLD,15));
        add(l10);

        //Adding TextFiled to City
        tf5=new JTextField(30);
        tf5.setBounds(210,390,300,21);
        add(tf5);


        //Creating pin code
        l11=new JLabel("Pin Code : ");
        l11.setBounds(50,430,100,20);
        l11.setFont(new Font("Osward",Font.BOLD,15));
        add(l11);

        //Creating textField for pinCode
        tf6=new JTextField(30);
        tf6.setBounds(210,430,300,21);
        add(tf6);

        //Creating State label
        l12=new JLabel("State : ");
        l12.setBounds(50,470,100,20);
        l12.setFont(new Font("Osward",Font.BOLD,15));
        add(l12);

        //Creating textField for State
        tf7=new JTextField(30);
        tf7.setBounds(210,470,300,21);
        add(tf7);

        //Creating a button
        b=new JButton("Next");
        b.setBounds(415,510,70,30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        add(b);

        //Adding ActionListener to Button
        b.addActionListener(this);

        //Boiler Plate Code
        setLayout(null);
        setSize(600,650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
    }

    void createDOB(){
        //Creating Date ComboBox
        String []dates={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        date=new JComboBox<String>(dates);
        date.setBounds(210,190,50,20);
        date.setBackground(Color.white);
        add(date);

        //Creating Month ComboBox
        String []months={"January","February","March","April","May","June","July","August","September","October","November","December"};
        month=new JComboBox<>(months);
        month.setBounds(290,190,100,20);
        month.setBackground(Color.white);
        add(month);

        //Creating Year ComboBox
        String []years={"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003"};
        year=new JComboBox<>(years);
        year.setBounds(420,190,100,20);
        year.setBackground(Color.white);
        add(year);
    }


    void createGenderRadioButtons(){

        //Creating male radioButton
        r1=new JRadioButton("Male");
        r1.setBounds(210,230,80,20);
        r1.setBackground(Color.white);
        r1.setFont(new Font("Raleway",Font.BOLD,12));
        add(r1);

        //Creating female radioButton
        r2=new JRadioButton("Female");
        r2.setBounds(330,230,80,20);
        r2.setBackground(Color.white);
        r2.setFont(new Font("Raleway",Font.BOLD,12));
        add(r2);

        //Adding Both The radioButtons to one ButtonGroup so that only one of them can be selected
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);  bg.add(r2);
    }

    void createMartialStatusRadioButtons(){
        //Creating Married RadioButton
        r3=new JRadioButton("Married");
        r3.setBounds(210,310,100,20);
        r3.setBackground(Color.white);
        r3.setFont(new Font("Raleway",Font.BOLD,12));
        add(r3);

        //Creating Unmarried radioButton
        r4=new JRadioButton("UnMarried");
        r4.setBounds(340,310,100,20);
        r4.setBackground(Color.white);
        r4.setFont(new Font("Raleway",Font.BOLD,12));
        add(r4);

        ButtonGroup bg=new ButtonGroup();
        bg.add(r3);  bg.add(r4);
    }

    public void actionPerformed(ActionEvent e){
        String name=tf1.getText();
        String fatherName=tf2.getText();
        String date1=(String) date.getSelectedItem();
        String month1=(String) month.getSelectedItem();
        String year1=(String) year.getSelectedItem();
        String email=tf3.getText();
        String address=tf4.getText();
        String city=tf5.getText();
        String pinCode=tf6.getText();
        String state=tf7.getText();

        String gender="";

        if(r1.isSelected()){
            gender="Male";
        }
        else if(r2.isSelected()){
            gender="Female";
        }
        String martialStatus="";
        if(r3.isSelected()){
            martialStatus="Married";
        }
        if(r4.isSelected()){
            martialStatus="Unmarried";
        }

        if(name.equals("")==true || fatherName.equals("") || gender.equals("") || email.equals("") || martialStatus.equals("") ){
            //If Any of these fields are empty then this message is displayed
            JOptionPane.showMessageDialog(this,"field cannot be empty");
        }
        else{
            try{
                //Creating a connection object
                //Means this Adds the driver and connects to database
                Conn obj=new Conn();

                String query="Insert into SignUp values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps=obj.c.prepareStatement(query);
                System.out.println("Application : "+applicationNumber);
                ps.setInt(1,applicationNumber);
                ps.setString(2,name);
                ps.setString(3,fatherName);
                ps.setString(4,date1);
                ps.setString(5,month1);
                ps.setString(6,year1);
                ps.setString(7,gender);
                ps.setString(8,email);
                ps.setString(9,martialStatus);
                ps.setString(10,address);
                ps.setString(11,city);
                ps.setString(12,pinCode);
                ps.setString(13,state);

                //Executing the Query
                ps.executeUpdate();

                //Closing The Connections
                ps.close();
                obj.c.close();

                new SignUp2().setVisible(true);
                setVisible(false);
            }
            catch(Exception ae){
                System.out.println(ae);
            }
            finally {

            }
        }
    }


     int getFormnumber(){
        return applicationNumber;
    }
    public static void main(String[] args) {
        new SignUp();
    }
}
