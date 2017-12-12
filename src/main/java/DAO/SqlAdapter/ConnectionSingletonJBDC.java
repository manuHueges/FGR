package DAO.SqlAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionSingletonJBDC {

    private static ConnectionSingletonJBDC connectionSingleton = null;
    private java.sql.Connection con;

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url =  "jdbc:mysql://localhost:3306/manuweather";
    private static String user = "root";
    private static String pwd = "1234";

    private ConnectionSingletonJBDC(){};

    public static void ConfigureDriversForConnection(String pDriver, String pUrl, String pUser, String pPwd ){

        driver = pDriver;
        url  = pUrl;
        user = pUser;
        pwd = pPwd;

        connectionSingleton = null;
    }

    public static ConnectionSingletonJBDC getInstance(){
       if (connectionSingleton == null ){
           connectionSingleton = new ConnectionSingletonJBDC();
       }
       return connectionSingleton;
   }

    public Connection getConnection(){
        try {
            Class.forName(driver);
            if (con == null){
                con = DriverManager.getConnection(url, user, pwd);
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
