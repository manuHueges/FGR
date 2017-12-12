package builders;

import com.company.Atm;
import com.company.Weather;
import com.company.Wind;

import java.sql.Date;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeatherBuilder {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY HH:mm");


    private int id_weather = 1;
    private int id_city = 1;
    private String date = "01/01/0001 00:01";
    private int max = 1;
    private int min = 1;
    private int temperature = 1;
    private String description = "TESTING";
    private Wind wind = new WindBuilder().builder();
    private Atm atm = new AtmBuilder().builder();
    private int id_day = 1;
    private int for_forecast = 1;
    private String last_up_forecast = "01/01/0001 00:01";

    public WeatherBuilder() throws ParseException {
        System.out.println("Error en el formato de fecha");
    }

    public WeatherBuilder withIdWeather (int id_weather) {
        this.id_weather = id_weather;
        return this;
    }

    public WeatherBuilder withIdCity(int id_city){
        this.id_city = id_city;
        return this;
    }

    public WeatherBuilder withDate(String date){
        this.date = date;
        return this;
    }

    public WeatherBuilder withMax(int max){
        this.max= max;
        return this;
    }

    public WeatherBuilder withMin(int min){
        this.min = min;
        return this;
    }

    public WeatherBuilder withTemperature (int temperature){
        this.temperature = temperature;
        return this;
    }

    public WeatherBuilder withWind (Wind wind){
        this.wind = wind;
        return this;
    }

    public WeatherBuilder withAtm (Atm atm){
        this.atm = atm;
        return this;
    }

    public WeatherBuilder withIdDay (int id_day){
        this.id_day = id_day;
        return this;
    }


    public Weather builder(){
        Weather w = new Weather();
        w.setId_weather(id_weather);
        w.setId_city(id_city);
        w.setId_day(id_day);
        w.setDate((date));
        w.setTemperature(temperature);
        w.setMax(max);
        w.setMin(min);
        w.setDescription(description);
        w.setWind(wind);
        w.setAtm(atm);
        return w;
    }


}
