package builders;

import com.company.Atm;
import com.company.Weather;
import com.company.Wind;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class WeatherBuilder {

    private Weather weather;
    private Wind wind;
    private Atm atm;
    private AtmBuilder atmB;
    private WindBuilder wB;


    public Weather builder(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        weather = new Weather();
        atmB = new AtmBuilder();
        wB = new WindBuilder();

        try {
        weather.setId_weather(1);
        weather.setId_city(1);
        weather.setId_day(1);
        weather.setTemperature(1);
        weather.setDescription("Testing");
        weather.setMin(-1);
        weather.setMax(1);
        weather.setDate(new Date(sdf.parse("01/01/0001 00:01").getTime()));
        weather.setAtm(atmB.build());
        weather.setWind(wB.builder());
        } catch (Exception e){
            System.out.println("AHHHHHHH");
        }

        return weather;
    }
}
