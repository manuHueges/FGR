package DAO.SqlAdapter;

import com.company.ForecastList;
import com.company.Weather;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class DaoForecast {

    private Connection connection = ConnectionSingletonJBDC.getInstance().getConnection();

    public ForecastList select(int id_city) {
        try {
            String query = "SELECT * FROM weather WHERE id_city = " + id_city;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();


            int id_wind = rs.getInt("id_wind");
            int id_atm = rs.getInt("id_atm");
            DaoWind dw = new DaoWind();
            DaoAtm da = new DaoAtm();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");

            Weather weather = new Weather();
            weather.setId_weather(rs.getInt("id_weather"));
            weather.setId_city(rs.getInt("id_city"));
            Date d = rs.getDate("date");
            weather.setDate(sdf.format(d));
            weather.setMax(rs.getInt("max"));
            weather.setMin(rs.getInt("min"));
            weather.setTemperature(rs.getInt("temperature"));
            weather.setDescription(rs.getString("description"));
            weather.setId_day(rs.getInt("id_day"));
            weather.setFor_forecast(rs.getInt("for_forecast"));
            d = rs.getDate("last_up_forecast");
            weather.setLast_up_forecast(sdf.format(d));
            weather.setWind(dw.select(id_wind));
            weather.setAtm(da.select(id_atm));
            st.close();
            rs.close();

            query = "SELECT * FROM weather WHERE for_forecast = " + weather.getId_weather();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            ForecastList forecastList = new ForecastList();
            forecastList.setForecastList(new LinkedList<Weather>());
            while (rs.next()){

                Weather ww = new Weather();
                ww.setId_weather(rs.getInt("id_weather"));
                d = rs.getDate("date");
                ww.setDate(sdf.format(d));
                ww.setMax(rs.getInt("max"));
                ww.setMin(rs.getInt("min"));
                ww.setTemperature(rs.getInt("temperature"));
                ww.setDescription(rs.getString("description"));
                ww.setFor_forecast(rs.getInt("for_forecast"));
                d = rs.getDate("last_up_forecast");
                ww.setLast_up_forecast(sdf.format(d));

                forecastList.getForecastList().add(ww);
            }

            weather.setForecastList(forecastList);

            st.close();
            rs.close();
            return weather.getForecastList();
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }
/*
    private List<Mforecast> lst;

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