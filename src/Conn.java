
package bank.management.system;
import java.sql.*;

public class Conn {
    //create connection
    Connection c;//2
    //create statement//3
    Statement s;
    public Conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);//1
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");//2
            s =c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
