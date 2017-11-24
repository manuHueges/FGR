package DAO;

import com.company.State;
import com.company.Weather;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DaoWeather implements ObjectsForDAO<Weather> {

    public List<Weather> listWeatherForAState(int id_state){
        List<Weather> lst = new LinkedList<Weather>();
        try {
            String query = "SELECT * FROM weather where weather.id_state =" + id_state;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Weather weather = new Weather();
                weather.setId_weather(rs.getInt("id_weather"));
                weather.setId_state(rs.getInt("id_state"));
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
                Weather Weather= new Weather();

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
    public List<Weather> loadList() {
        List<Weather> lst = new LinkedList<Weather>();

        try {
            String query = "SELECT * FROM weather";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Weather weather = new Weather();
                weather.setId_weather(rs.getInt("id_weather"));
                weather.setId_state(rs.getInt("id_state"));
                weather.setDate(rs.getString("date"));
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

            rs.next();
            query = "SELECT * FROM weather WHERE id_weather = " + id +" and date =";
            st = connection.createStatement();
            rs = st.executeQuery(query);

            Weather weather = new Weather();
            weather.setId_weather(rs.getInt("id_weather"));
            weather.setId_state(rs.getInt("id_state"));
            weather.setDate(rs.getString("date"));
            weather.setMax(rs.getInt("max"));
            weather.setMin(rs.getInt("min"));
            weather.setTemperature(rs.getInt("temperature"));
            weather.setDescription(rs.getString("description"));
            weather.setId_day(rs.getInt("id_day"));
            weather.setWind(dw.select(id_wind));
            weather.setAtm(da.select(id_atm));

            st.close();
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
                String query = "SELECT max(id_weather) as id FROM weather";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
                idWweather = rs.getInt("id");
                idWweather++;
                newWeather.setId_weather(idWweather);
                st.close();

                query = "insert into weather(id_weather, id_state, date, max, min, temperature, description, id_wind, id_atm, id_day) " +
                        "values("+newWeather.getId_weather() +", "+newWeather.getId_state() +", '"+newWeather.getDate()+"', "
                        + newWeather.getMax()+ ", "+ newWeather.getMin()+", "+newWeather.getTemperature()+", '"+newWeather.getDescription()+"', "
                        + newWeather.getWind().getId_wind()+", "+ newWeather.getAtm().getId_atm()+", "+newWeather.getId_day()+")";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                rs.close(); // agregado para prueba
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
            String query = "UPDATE weather(id_state, date, max, min, temperature, description, id_wind, id_atm, id_day) " +
                    "values("+weatherUpdated.getId_state() +", '"+weatherUpdated.getDate()+"', "
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



