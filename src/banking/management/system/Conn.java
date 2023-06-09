
package banking.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystemm","root","Pranshu@1807");
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
