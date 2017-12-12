package controller;

import java.io.StringReader;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import DAO.SqlAdapter.DaoWeather;
import com.company.City;
import com.company.CityList;
import com.company.Weather;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proxy.Proxy;

@Controller
public class WeatherController {

    private DaoWeather daoWeather = new DaoWeather();
    private Jaxb2Marshaller jaxb2Mashaller;


    public void setJaxb2Mashaller(Jaxb2Marshaller jaxb2Mashaller) {
        this.jaxb2Mashaller = jaxb2Mashaller;
    }

    private static final String XML_VIEW_NAME = "weather";

    //1 . Guardar un clima de hoy
    @RequestMapping(method=RequestMethod.POST, value="/new")
    public ModelAndView addWeather(@RequestBody String body) {
        Source source = new StreamSource(new StringReader(body));
        Weather w = (Weather) jaxb2Mashaller.unmarshal(source);
        daoWeather.insert(w);
        return new ModelAndView(XML_VIEW_NAME, "object", w);
    }

    //2 . metodo que devuelve el clima que acabamos de guardar
    @RequestMapping(method=RequestMethod.GET, value="/lastinsert")
    public ModelAndView getLastInsertedWeather() {
        Weather w = daoWeather.selectLastInsert();
        return new ModelAndView(XML_VIEW_NAME, "weather", w);
    }

    //3 . devolver todos los climas de cada localidad de un estado para el día
    @RequestMapping(method=RequestMethod.GET, value="/weatherstate/{name}")
    public ModelAndView getWeatherOfCitiesForState(@PathVariable String name) {
        List<City> cities = null;
        try {
            cities = Proxy.getWeatherForState(name);
        } catch(Exception e) {
            e.printStackTrace();
        }
        CityList cityList = new CityList();
        cityList.setCities(cities);
        return new ModelAndView(XML_VIEW_NAME, "cities", cityList);
    }


    //4 . pronostico extendido de provincia localidad fecha con el dia y 10 dias adelante --GET
    @RequestMapping(method=RequestMethod.GET, value="/forecast/{name}/{stateAbr}")
    public ModelAndView getForecastForCity(@PathVariable String name, @PathVariable String stateAbr) {
        Weather weather = Proxy.getForecastForCity(name, stateAbr);
        return new ModelAndView(XML_VIEW_NAME, "forecasts", weather.getForecastList());
    }


    //5 . modificar un clima completo de una localidad de un día de una hora -- PUT


}
