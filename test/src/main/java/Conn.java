import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Класс для подключения к базе данных
  */
public class Conn {
    public static Connection dbconnect(){
        Connection conn = null;
        try{
           Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
           conn = DriverManager.getConnection(Const.URL, Const.DBUSER, Const.DBPASS);
           System.out.println("Connection to DB succesfull!");
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }

    return conn;
    }
}
