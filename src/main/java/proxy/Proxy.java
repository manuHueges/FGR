package proxy;

import DAO.SqlAdapter.DaoCity;
import DAO.SqlAdapter.DaoWeather;
import DAO.YahooAdapter.YahooWeather;
import Transformer.TransformerManuWeather;
import YahooObjects.Channel;
import com.company.City;
import com.company.Weather;

import java.util.List;

public class Proxy {

    public static List<City> getWeatherForState(String state) {
        DaoCity daoCity = new DaoCity();
        DaoWeather daoWeather = new DaoWeather();
        List<City> ret = daoCity.getCitiesOfState(state);
        YahooWeather yahooWeather = new YahooWeather();
        int id_city_inserted;
        for(City c : ret) {
            try {
                Channel channel = yahooWeather.selectChannelForCityName(c.getName(), c.getStateAbr());
                Weather weather = TransformerManuWeather.YahooToManuWeather(channel);
                if (weather.getId_city() == 0){// Si la ciudad no existe, la crea
                    City city = new City();
                    city.setName(channel.getLocation().getCity());
                    id_city_inserted = daoCity.insert(city);
                    if (id_city_inserted > 0){
                        weather.setId_city(id_city_inserted);
                    }
                }
                c.setWeather(weather);
            } catch (Exception e) {
                System.out.println("Error al consultar Yahoo Weather.");
            }
            if(c.getWeather() != null) {
                daoWeather.insert(c.getWeather());
            } else {
                Weather weather = daoWeather.select(c.getId_city());
                c.setWeather(weather);
            }
        }
        return ret;
    }

    public static Weather getForecastForCity(String city, String state) {
        Weather weather = null;
        DaoCity daoCity = new DaoCity();
        DaoWeather daoWeather = new DaoWeather();

        YahooWeather yahooWeather = new YahooWeather();
        int id_city_inserted;

            try {
                Channel channel = yahooWeather.selectChannelForCityName(city, state);
                weather = TransformerManuWeather.YahooToManuWeather(channel);
            } catch (Exception e) {
                System.out.println("Error al consultar Yahoo Weather.");
            }
            if(weather != null) {
                daoWeather.insert(weather);
            } else {
                City c = daoCity.select(city, state);
                if(c != null) {
                    weather = daoWeather.select(c.getId_city());
                } else {
                    System.out.println("No se encontro la ciudad " + city + ", " + state);
                }

            }
        return weather;
    }

}
