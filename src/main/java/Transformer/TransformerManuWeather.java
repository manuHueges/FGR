package Transformer;

import DAO.SqlAdapter.DaoCity;
import DAO.SqlAdapter.DaoState;
import YahooObjects.*;
import YahooObjects.Forecast;
import YahooObjects.Wind;
import builders.WeatherBuilder;
import com.company.*;

import java.util.LinkedList;
import java.util.List;


public class TransformerManuWeather {

    public static Channel ManuWeatherToYahoo(Weather weatherToTransform){
        Channel channel = new Channel();
        Atmosphere atmosphere = new Atmosphere();
        Wind wind = new Wind();
        Item item = new Item();
        Condition condition = new Condition();
        Forecast forecast = new Forecast();
        List<Forecast> forecastList = new LinkedList<>();
        Location location = new Location();
        DaoCity daoCity = new DaoCity();
        DaoState daoState = new DaoState();

        atmosphere.setHumidity(weatherToTransform.getAtm().getHumidity());
        atmosphere.setPressure(weatherToTransform.getAtm().getHumidity());
        atmosphere.setRising(weatherToTransform.getAtm().getRising());
        atmosphere.setVisibility(weatherToTransform.getAtm().getVisibility());

        wind.setDirection(weatherToTransform.getWind().getDirection());
        wind.setSpeed(weatherToTransform.getWind().getSpeed());

        condition.setDate(weatherToTransform.getDate());
        condition.setTemp(weatherToTransform.getTemperature());
        condition.setText(weatherToTransform.getDescription());

        item.setCondition(condition);
        forecast.setDate(weatherToTransform.getDate());
        forecast.setHigh(weatherToTransform.getMax());
        forecast.setLow(weatherToTransform.getMin());
        forecastList.add(forecast);
        item.setForecasts(forecastList);

        City city = daoCity.select(weatherToTransform.getId_city());
        location.setCity(city.getName());
        State state = daoState.select(city.getId_state());
        location.setCountry(state.getName());

        channel.setAtmosphere(atmosphere);
        channel.setWind(wind);
        channel.setItem(item);
        channel.setLocation(location);
        channel.setTitle("weather transformed from manuweather");

        return channel;
    }

    public static Weather YahooToManuWeather(Channel channelToTransform){
        Weather weather = new Weather();
        Atm atm = new Atm();
        com.company.Wind wind = new com.company.Wind();
        String day = "";
        DaoCity dc = new DaoCity();
        List<City> lst = new LinkedList<>();
        ForecastList forecastList = new ForecastList();

        atm.setHumidity(channelToTransform.getAtmosphere().getHumidity());
        atm.setRising(channelToTransform.getAtmosphere().getRising());
        atm.setPressure(channelToTransform.getAtmosphere().getPressure());
        atm.setVisibility(channelToTransform.getAtmosphere().getVisibility());

        wind.setDirection(channelToTransform.getWind().getDirection());
        wind.setSpeed(channelToTransform.getWind().getSpeed());

        weather.setTemperature(channelToTransform.getItem().getCondition().getTemp());
        weather.setDescription(channelToTransform.getItem().getCondition().getText());
        weather.setDate(channelToTransform.getItem().getCondition().getDate());

        weather.setAtm(atm);
        weather.setWind(wind);

        forecastList.setForecastList(new LinkedList<Weather>());


        for (Forecast f : channelToTransform.getItem().getForecasts()) {
            if (f.getDate().equals(weather.getDate().substring(5,16))){
                weather.setMin(f.getLow());
                weather.setMax(f.getHigh());
                day = f.getDay();

            }
            Weather ww = new Weather();
            ww.setDate(f.getDate());
            ww.setMax(f.getHigh());
            ww.setMin(f.getLow());
            ww.setDescription(f.getText());

            forecastList.getForecastList().add(ww);
        }
        weather.setForecastList(forecastList);

        if (day != null){

            switch (day) {
                case "Mon":  weather.setId_day(1);
                break;
                case "Tue":  weather.setId_day(2);
                break;
                case "Wed":  weather.setId_day(3);
                break;
                case "Thu": weather.setId_day(4);
                break;
                case "Fri": weather.setId_day(5);
                break;
                case "Sat": weather.setId_day(6);
                break;
                case "Sun": weather.setId_day(7);
                break;

            }
        }
        lst = dc.loadList();

        for (City c: lst) {
            if (c.getName().equalsIgnoreCase(channelToTransform.getLocation().getCity())){
                weather.setId_city(c.getId_city());
            }
        }
        System.out.println(channelToTransform.getLocation().getCity());
        return weather;
    }



}
