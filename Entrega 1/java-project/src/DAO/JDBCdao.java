package DAO;

import com.company.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class JDBCdao implements ObjectsForDAO {

    Connection connection = null;

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (connection == null){
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manuweather","root","1234");
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public int insertState(State state) {
        try {
            int idState = 0;
            String query = "SELECT max(id_state) as id FROM state";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idState = rs.getInt("id");
            System.out.println(idState);
            idState++;
            st.close();
            query = "insert into State(id_state, name, abr, size, capital, id_country) values("+idState + ",'" + state.getName()
                    +"', '"+state.getAbr()+"', '"+state.getSize()+"', '"+state.getCapital()+"', "+state.getCountry().getId_country()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idState;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<State> loadStateList(int idCountry) {
        List<State> lst = new LinkedList<State>();
        try {
            String query = "SELECT * FROM state where id_country = " + idCountry;
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                State state = new State();
                state.setId_state(rs.getInt("id_state"));
                state.setName(rs.getString("name"));
                lst.add(state);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public int insertCountry(Country country) {
        try {
            int idCountry = 0;
            String query = "SELECT max(id_country) as id FROM country";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idCountry = rs.getInt("id");
            System.out.println(idCountry);
            idCountry++;
            st.close();

            query = "insert into country(id_country, name, cod_c_2, cod_c_3) values("+country.getId_country()
                +", '"+country.getName()+"', '"+country.getCod_c_2()+"', '"+country.getCod_c_3()+"')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idCountry;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Country> loadCountryList() {
        List<Country> lst = new LinkedList<Country>();
        try {
            String query = "SELECT * FROM country";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Country country = new Country();
                country.setId_country(rs.getInt("id_country"));
                country.setName(rs.getString("name"));
                lst.add(country);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public int insertDay(Day day) {
        try {
            int idDay = 0;
            String query = "SELECT max(id_day) as id FROM day";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idDay = rs.getInt("id");
            System.out.println(idDay);
            idDay++;
            st.close();

            query = "insert into day(id_day, temperature, description, date) values("+day.getId_day()
                    +", "+day.getTemperature()+", '"+day.getDescription()+", "+day.getDate()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idDay;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Day loadDay(int idDayFromWeather) {
        try {
            String query = "SELECT * FROM day WEERE id_day = "+idDayFromWeather;
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            Day day= new Day();
            day.setId_day(rs.getInt("id_day"));
            day.setTemperature(rs.getInt("temperature"));
            day.setDescription(rs.getString("description"));
            day.setDate(rs.getDate("date"));

            st.close();
            return day;
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int insertWind(Wind wind) {
        try {
            int idWind = 0;
            String query = "SELECT max(id_wind) as id FROM wind";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idWind = rs.getInt("id");
            System.out.println(idWind);
            idWind++;
            st.close();

            query = "insert into wind(id_wind, speed, direction) values("+wind.getId_wind()
                    +", "+wind.getSpeed()+", "+wind.getDirection()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idWind;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Wind loadWind(int idWindFromWeather) {
        try {
            String query = "SELECT * FROM wind WHERE id_wind = "+ idWindFromWeather;
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            Wind wind = new Wind();
            wind.setId_wind(rs.getInt("id_wind"));
            wind.setSpeed(rs.getInt("speed"));
            wind.setDirection(rs.getInt("direction"));

            st.close();
            return wind;
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int insertAtm(Atm atm) {
        try {
            int idAtm = 0;
            String query = "SELECT max(id_atm) as id FROM atm";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idAtm = rs.getInt("id");
            System.out.println(idAtm);
            idAtm++;
            st.close();

            query = "insert into atm(id_atm, humidity, pressure, visibility, rising) values("+atm.getId_atm()
                    +", "+atm.getHumidity()+", "+atm.getPressure()+", "+atm.getVisibility()+", "+atm.getRising()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idAtm;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Atm loadAtm(int idAtmFromWeather) {
        try {
            String query = "SELECT * FROM atm, weather WHERE weather.id_atm = "+idAtmFromWeather;
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            Atm atm = new Atm();
            atm.setId_atm(rs.getInt("id_atm"));
            atm.setHumidity(rs.getInt("humidity"));
            atm.setPressure(rs.getFloat("pressure"));
            atm.setVisibility(rs.getDouble("visibility"));
            atm.setRising(rs.getInt("rising"));

            st.close();
            return atm;
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return null;
    }


    @Override
    public int insertForecast(Forecast forecast) {
        try {
            int idForecast = 0;//CONSIGO EL ID PARA EL NUEVO FORECAST
            String query = "SELECT max(id_forecast) as id FROM forecast";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idForecast = rs.getInt("id");
            System.out.println(idForecast);
            idForecast++;
            st.close();

            // CONSIGO EL ID PARA LOS FORECASTCONTENTS
            /*query = "SELECT id_forecastday as id FROM forecastcontent, forecast " +
                    "WHERE id_forecast = 1 and id_forecastday = id_forecast_day1 " +
                    "or id_forecast_day2 or id_forecast_day3 or id_forecast_day4 or id_forecast_day5  " +
                    "or id_forecast_day6 or id_forecast_day7 or id_forecast_day8 or id_forecast_day9 " +
                    "or id_forecast_day10";*/

            int idForecastContent = 0;
            query = "SELECT max(id_forecastday) as id FROM forecastcontent";
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            rs.next();
            idForecastContent = rs.getInt("id");

            st.close();

            forecast.forecastSetID(idForecastContent);//completo LOS ID DE CADA UNIDAD DE EXTENDIDO
            forecast.completeIds(idForecastContent);//Completo el indice de IDS en FORECAST

            for (int i = 0; i < 10; i++){
                ForeUnit fu = new ForeUnit();
                fu = forecast.getForeUnits(i);
                query = "INSERT into forecastcontent(id_forecastday, date, day_name, max, min, description)" +
                        "VALUES ("+fu.getId_fore_day()+", "+fu.getDate()+", '"+fu.getDayName()+"', "+fu.getMax()+
                        ", "+fu.getMin()+", '"+fu.getDescription()+"')";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
            }

            query = "INSERT into forecast(id_forecast, id_fore_day1, id_fore_day2, id_fore_day3, id_fore_day4" +
                    ", id_fore_day5, id_fore_day6, id_fore_day7, id_fore_day8, id_fore_day9, id_fore_day10)" +
                    " VALUES("+forecast.getId_forecast()+", "+forecast.getId_forecast_day1()+", "+forecast.getId_forecast_day2()+
                    ", "+forecast.getId_forecast_day3()+", "+forecast.getId_forecast_day4()+", "+forecast.getId_forecast_day5()
                    +", "+forecast.getId_forecast_day6()+", "+forecast.getId_forecast_day7()+", "+forecast.getId_forecast_day8()
                    +", "+forecast.getId_forecast_day9()+", "+forecast.getId_forecast_day10()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idForecast;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public Forecast loadForecast(int idForeFromWeather) {
        try {
            String query = "SELECT * FROM forecast WHERE id_forecast = "+idForeFromWeather;
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            Forecast forecast = new Forecast();
            forecast.setId_forecast(rs.getInt("id_forecast"));
            forecast.setId_forecast_day1(rs.getInt("id_forecast_day1"));
            forecast.setId_forecast_day2(rs.getInt("id_forecast_day2"));
            forecast.setId_forecast_day3(rs.getInt("id_forecast_day3"));
            forecast.setId_forecast_day4(rs.getInt("id_forecast_day4"));
            forecast.setId_forecast_day5(rs.getInt("id_forecast_day5"));
            forecast.setId_forecast_day6(rs.getInt("id_forecast_day6"));
            forecast.setId_forecast_day7(rs.getInt("id_forecast_day7"));
            forecast.setId_forecast_day8(rs.getInt("id_forecast_day8"));
            forecast.setId_forecast_day9(rs.getInt("id_forecast_day9"));
            forecast.setId_forecast_day10(rs.getInt("id_forecast_day10"));

            st.close();

            query = "SELECT id_forecastday as id FROM forecastcontent, forecast " +
                    "WHERE id_forecast = 1 and id_forecastday = id_forecast_day1 " +
                    "or id_forecast_day2 or id_forecast_day3 or id_forecast_day4 or id_forecast_day5  " +
                    "or id_forecast_day6 or id_forecast_day7 or id_forecast_day8 or id_forecast_day9 " +
                    "or id_forecast_day10";
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ForeUnit forecastcontent = new ForeUnit();
                forecastcontent.setId_fore_day(rs.getInt("id_forecastday"));
                forecastcontent.setDate(rs.getDate("date"));
                forecastcontent.setDayName(rs.getString("day_name"));
                forecastcontent.setMax(rs.getInt("max"));
                forecastcontent.setMax(rs.getInt("min"));
                forecastcontent.setDescription(rs.getString("description"));
                forecast.LoadForecast(forecastcontent);
            }
            st.close();
            return forecast;
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }

        return null;
    }

    @Override
    public String insertWeather(Weather weather) {
        try {
            String query = "INSERT into Weather(id_state, date, id_forecast, id_day, id_wind, id_atm) values("+weather.getId_state()
                    +", "+weather.getDate()+", "+weather.getId_forecast()+", "+weather.getId_day()+", "+weather.getId_wind()+
                    ", "+weather.getId_atm()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return "Clima Actualizado!!!";
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "Something went wrong";
    }

    @Override
    public Weather loadWeather(int id_state) {
        Weather w = new Weather();
        try {// ELIJO EL ESTADO PARA EL CUAL VOY A CARGAR EL CLIMA
            String query = "SELECT * FROM weather WHERE id_state = " + id_state + " and date = (select max(date)" +
                    " from weather where id_state = " + id_state + " and DATE(date) = DATE(sysdate())) ";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

            w.setId_state(rs.getInt("id_state"));
            w.setDate(rs.getDate("date"));
            w.setId_day(rs.getInt("id_day"));
            w.setId_forecast(rs.getInt("id_forecast"));
            w.setId_wind(rs.getInt("id_wind"));
            w.setId_atm(rs.getInt("id_atm"));

            // CARGO EL DÍA EN EL CLIMA
            w.setDay(loadDay(w.getId_day()));
            st.close();
            // CARGO EL VIENTO EN EL CLIMA
            w.setWind(loadWind(w.getId_wind()));

            //CARGO EL FORECAST EN EL CLIMA
            w.setForecast(loadForecast(w.getId_forecast()));

            //CARGO LA ATMOSFERA EN EL CLIMA
            w.setAtm(loadAtm(w.getId_atm()));



        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return w;
    }
}
