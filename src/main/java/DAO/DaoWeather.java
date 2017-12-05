package DAO;

import com.company.Weather;
import display.Mweather;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class DaoWeather implements ObjectsForDAO<Weather> {
/*
    public List<Weather> listWeatherForAState(int id_state, String date){
        List<Weather> lst = new LinkedList<Weather>();
        try {
            String query = "SELECT w.id_weather, c.name, w.temperature, w.description"+
                "FROM weather w, city c where w.id_city = c.id_city and c.id_state =" + id_state+
                "and w.date = "+ date;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Weather weather = new Weather();
                weather.setId_weather(rs.getInt("id_weather"));
                weather.setId_city(rs.getInt("id_city"));
                weather.setDate(rs.getString("date"));
                weather.setMax(rs.getInt("max"));
                weather.setMin(rs.getInt("min"));
                weather.setTemperature(rs.getInt("temperature"));
                weather.setDescription(rs.getString("description"));
                weather.setId_day(rs.getInt("id_day"));

                query = "SELECT id_wind, id_atm FROM weather WHERE id_weather = " + weather.getId_weather();
                ResultSet rs2 = st.executeQuery(query);
                int id_wind = rs2.getInt("id_wind");
                int id_atm = rs2.getInt("id_atm");
                DaoWind dw = new DaoWind();
                DaoAtm da = new DaoAtm();
                rs2.close();

                weather.setWind(dw.select(id_wind));
                weather.setAtm(da.select(id_atm));

                lst.add(weather);
            }

            st.close();
            rs.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }
*/

    public List<Mweather> listWeatherForAState(int id_state, Date date){
        List<Mweather> lst = new LinkedList<Mweather>();
        try {
            String query = "SELECT w.id_weather, c.name, w.temperature, w.description"+
                    "FROM weather w, city c where w.id_city = c.id_city and c.id_state = ? " +
                    "and w.date = ? ";
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id_state);
            st.setDate(2,  date);
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
    }

    @Override
    public List<Weather> loadList() {
        List<Weather> lst = new LinkedList<Weather>();

        try {
            String query = "SELECT * FROM weather";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Weather weather = new Weather();
                weather.setId_weather(rs.getInt("id_weather"));
                weather.setId_city(rs.getInt("id_city"));
                weather.setDate(rs.getDate("date"));
                weather.setMax(rs.getInt("max"));
                weather.setMin(rs.getInt("min"));
                weather.setTemperature(rs.getInt("temperature"));
                weather.setDescription(rs.getString("description"));
                weather.setId_day(rs.getInt("id_day"));

                int id_wind = rs.getInt("id_wind");
                int id_atm = rs.getInt("id_atm");
                DaoWind dw = new DaoWind();
                DaoAtm da = new DaoAtm();
                weather.setWind(dw.select(id_wind));
                weather.setAtm(da.select(id_atm));

                lst.add(weather);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public Weather select(int id) {
        try {
            String query = "SELECT id_wind, id_atm FROM weather WHERE id_weather = " + id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();


            int id_wind = rs.getInt("id_wind");
            int id_atm = rs.getInt("id_atm");
            DaoWind dw = new DaoWind();
            DaoAtm da = new DaoAtm();

            rs.next();///////////////??????????????????????
            query = "SELECT * FROM weather WHERE id_weather = " + id +" and date =" ;
            st = connection.createStatement();
            rs = st.executeQuery(query);

            Weather weather = new Weather();
            weather.setId_weather(rs.getInt("id_weather"));
            weather.setId_city(rs.getInt("id_city"));
            weather.setDate(rs.getDate("date"));
            weather.setMax(rs.getInt("max"));
            weather.setMin(rs.getInt("min"));
            weather.setTemperature(rs.getInt("temperature"));
            weather.setDescription(rs.getString("description"));
            weather.setId_day(rs.getInt("id_day"));
            weather.setWind(dw.select(id_wind));
            weather.setAtm(da.select(id_atm));

            st.close();
            rs.close();
            return weather;
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int insert(Weather newWeather) {

            try {
                int idWweather = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY HH:mm");
                String query = "SELECT max(id_weather) as id FROM weather";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
                idWweather = rs.getInt("id");
                idWweather++;
                newWeather.setId_weather(idWweather);
                st.close();
                PreparedStatement preparedStatement;

                query = "insert into weather(id_weather, id_city, date, max, min, temperature, description, id_wind, id_atm, id_day) " +
                        "values("+newWeather.getId_weather() +", "+newWeather.getId_city() +", ?, "
                        + newWeather.getMax()+ ", "+ newWeather.getMin()+", "+newWeather.getTemperature()+", '"+newWeather.getDescription()+"', "
                        + newWeather.getWind().getId_wind()+", "+ newWeather.getAtm().getId_atm()+", "+newWeather.getId_day()+")";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDate(1, newWeather.getDate());
                preparedStatement.executeUpdate();
                rs.close();
                preparedStatement.close();
                return idWweather;
            } catch(Exception e) {
                e.printStackTrace();
            }
            return -1;
        }

    @Override
    public String update(Weather weatherUpdated) {
        String s;
        try {
            String query = "UPDATE weather(id_city, date, max, min, temperature, description, id_wind, id_atm, id_day) " +
                    "values("+weatherUpdated.getId_city() +", "+weatherUpdated.getDate()+", "
                    + weatherUpdated.getMax()+ ", "+ weatherUpdated.getMin()+", "+weatherUpdated.getTemperature()+", '"+weatherUpdated.getDescription()+"', "
                    + weatherUpdated.getWind().getId_wind()+", "+ weatherUpdated.getAtm().getId_atm()+", "+weatherUpdated.getId_day()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            s = "Update Exitoso!";
            return s;
        } catch (Exception e) {
            s = "ERROR! " + e.getMessage() ;
        }
        return s;
    }

    @Override
    public String delete(Weather weather) {
        String s;
        try {
            String query = "DELETE * FROM weather WHERE id_atm = "+weather.getId_weather();
            Statement st = connection.createStatement();
            st.executeQuery(query);
            s = "Delete Exitoso";
        } catch (Exception e) {
            s = ("ERROR ELIMINANDO WEATHER!!" + e.getMessage());

        }
        return s;
    }
}



