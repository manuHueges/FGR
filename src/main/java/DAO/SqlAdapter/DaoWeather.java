package DAO.SqlAdapter;

import DAO.IDaoAdapter.ObjectsForDAO;
import com.company.City;
import com.company.ForecastList;
import com.company.Weather;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class DaoWeather implements ObjectsForDAO<Weather> {


    private Connection connection = ConnectionSingletonJBDC.getInstance().getConnection();


    public Weather selectLastInsert(){
        try {
            String query = "SELECT * FROM weather WHERE id_weather = (select max(id_weather) from weather where for_forecast =0)";
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
                ww.setDescription(rs.getString("description"));
                ww.setFor_forecast(rs.getInt("for_forecast"));
                d = rs.getDate("last_up_forecast");
                ww.setLast_up_forecast(sdf.format(d));

                forecastList.getForecastList().add(ww);
            }

            weather.setForecastList(forecastList);

            st.close();
            rs.close();
            return weather;
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<City> listWeatherForAState(String stateName){
        List<City> lst = new LinkedList<City>();
        try {
            String query = "SELECT w.*, c.* " +
                    " FROM weather w, city c " +
                    "where w.id_city = c.id_city " +
                    "and c.name like('%"+ stateName +"%') " +
                    "and w.date = ( select max(date) from weather where id_city = w.id_city ) ";
            PreparedStatement st = connection.prepareStatement(query);
            //st.setInt(1, id_state);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                City city = new City();
                city.setId_city(rs.getInt("id_city"));
                city.setId_state(rs.getInt("id_state"));
                city.setName(rs.getString("name"));
                city.setAbr(rs.getString("abr"));
                city.setSize(rs.getInt("size"));

                Weather weather = new Weather();
                weather.setId_weather(rs.getInt("id_weather"));
                weather.setId_city(rs.getInt("id_city"));
                Date d = rs.getDate("date");
                weather.setDate(sdf.format(d));;
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


                city.setWeather(weather);

                lst.add(city);
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

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

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
    public Weather select(int id_city) {
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
                DaoAtm daoAtm = new DaoAtm();
                DaoWind daoWind = new DaoWind();

                int idWweather = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH) ;
                String query = "SELECT max(id_weather) as id FROM weather";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
                idWweather = rs.getInt("id");
                idWweather++;
                newWeather.setId_weather(idWweather);
                st.close();
                PreparedStatement preparedStatement;
                newWeather.getAtm().setId_atm(daoAtm.insert(newWeather.getAtm()));
                newWeather.getWind().setId_wind(daoWind.insert(newWeather.getWind()));

                query = "insert into weather(id_weather, id_city, date, max, min, temperature, description, id_wind, id_atm, id_day, for_forecast, last_up_forecast) " +
                        "values("+newWeather.getId_weather() +", "+newWeather.getId_city() +", ?, "
                        + newWeather.getMax()+ ", "+ newWeather.getMin()+", "+newWeather.getTemperature()+", '"+newWeather.getDescription()+"', "
                        + newWeather.getWind().getId_wind()+", "+ newWeather.getAtm().getId_atm()+", "+newWeather.getId_day()+", " +
                        newWeather.getFor_forecast()+ ", ?)";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDate(1, new Date(new java.util.Date().getTime()));
                preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
                preparedStatement.executeUpdate();

                if (newWeather.getForecastList() != null){
                    for (Weather w: newWeather.getForecastList().getForecastList()) {
                        idWweather++;
                        query = "insert into weather(id_weather, date, max, min, temperature, description, for_forecast, last_up_forecast) " +
                                "values("+idWweather +", ?, "
                                + w.getMax()+ ", "+ w.getMin()+", "+w.getTemperature()+", '"+w.getDescription()+"', "
                                + newWeather.getId_weather()+ ", ?)";

                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setDate(1, new Date(sdf.parse(w.getDate()).getTime()));
                        preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
                        preparedStatement.executeUpdate();
                    }
                }
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
            String query = "UPDATE weather(id_city, date, max, min, temperature, description, id_wind, id_atm, id_day, for_forecast, last_up_forecast) " +
                    "values("+weatherUpdated.getId_city() +", ?, "
                    + weatherUpdated.getMax()+ ", "+ weatherUpdated.getMin()+", "+weatherUpdated.getTemperature()+", '"+weatherUpdated.getDescription()+"', "
                    + weatherUpdated.getWind().getId_wind()+", "+ weatherUpdated.getAtm().getId_atm()+", "+weatherUpdated.getId_day()+
                    weatherUpdated.getFor_forecast() + ", ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new Date(new java.util.Date().getTime()));
            preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
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



