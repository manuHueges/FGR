import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSingletonH2 {

    private static ConnectionSingletonH2 connectionSingleton = null;
    private java.sql.Connection con;

    private ConnectionSingletonH2(){};

    public static ConnectionSingletonH2 getInstance(){
        if (connectionSingleton == null ){
            connectionSingleton = new ConnectionSingletonH2();
        }
        return connectionSingleton;
    }

    public Connection getConnection(){
        try {
            Class.forName("org.h2.Driver");
            if (con == null){
                con = DriverManager.getConnection("jdbc:h2:~/test");
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
