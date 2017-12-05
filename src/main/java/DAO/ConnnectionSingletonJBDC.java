package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnnectionSingletonJBDC {

    private static ConnnectionSingletonJBDC connectionSingleton = null;
    private java.sql.Connection con;

    private ConnnectionSingletonJBDC(){};

   public static ConnnectionSingletonJBDC getInstance(){
       if (connectionSingleton == null ){
           connectionSingleton = new ConnnectionSingletonJBDC();
       }
       return connectionSingleton;
   }

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (con == null){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manuweather","root","1234");
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
