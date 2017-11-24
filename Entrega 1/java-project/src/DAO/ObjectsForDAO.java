package DAO;
import com.company.*;

import java.util.List;

public interface ObjectsForDAO {

    public int insertState(State state);
    public List<State> loadStateList(int idCountry);

    public int insertCountry(Country country);
    public List<Country> loadCountryList();

    public int insertDay(Day day);
    public Day loadDay(int idDayFromWeather);

    public int insertWind(Wind wind);
    public Wind loadWind(int idWindFromWeather);

    public int insertAtm(Atm atm);
    public Atm loadAtm(int idAtmFromWeather);

    public int insertForecast(Forecast forecast);
    public Forecast loadForecast(int idForeFomWeather);

    public String insertWeather (Weather weather);
    public Weather loadWeather(int id_state);


}
