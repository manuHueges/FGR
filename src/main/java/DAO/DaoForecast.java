package DAO;

import com.company.Country;
import display.Mforecast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DaoForecast {

    private List<Mforecast> lst;
/*
    public List<Mforecast> getForecast() {
    lst = new LinkedList<Mforecast>();
        try {
            String query =
        }


    }
*/
}
/*
    public List<Mweather> listWeatherForAState(int id_state, String date){
        List<Mweather> lst = new LinkedList<Mweather>();
        try {
            String query = "SELECT w.id_weather, c.name, w.temperature, w.description"+
                    "FROM weather w, city c where w.id_city = c.id_city and c.id_state =" + id_state+
                    "and w.date = "+ date;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Mweather mweather= new Mweather();
                mweather.setId_weather(rs.getInt("id_weather"));
                mweather.setCity(rs.getString("name"));
                mweather.setTemperature(rs.getInt("temperature"));
                mweather.setDescription(rs.getString("description"));

                lst.add(mweather);
            }

            st.close();
            rs.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }*/