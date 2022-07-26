package ATM;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    PreparedStatement ps;
    Conn(){
        try{
            //Loading The Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establishing the connection
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM","root","jaswanth38");

            //Creating The Statement
            s=c.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
