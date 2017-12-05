package controller;

import java.io.StringReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import DAO.DaoWeather;
import com.company.Weather;
import display.Mweather;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeatherController {

    private DaoWeather daoWeather = new DaoWeather();
    private Jaxb2Marshaller jaxb2Mashaller;
    private int lastInsertedWeather = 1;

    public void setJaxb2Mashaller(Jaxb2Marshaller jaxb2Mashaller) {
        this.jaxb2Mashaller = jaxb2Mashaller;
    }

    private static final String XML_VIEW_NAME = "weather";

    //1 . Guardar un clima de hoy
    @RequestMapping(method=RequestMethod.POST, value="/weather/new")

    public ModelAndView addWeather(@RequestBody String body) {
        Source source = new StreamSource(new StringReader(body));
        Weather w = (Weather) jaxb2Mashaller.unmarshal(source);
        lastInsertedWeather = w.getId_weather();
        daoWeather.insert(w);//employeeDS.add(e);
        return new ModelAndView(XML_VIEW_NAME, "object", w);
    }

    //2 . metodo que devuelve el clima que acabamos de guardar
    @RequestMapping(method=RequestMethod.GET, value="/weather/lastInsert")

    public ModelAndView getLastInsertedWeather() {
        Weather w = daoWeather.select(lastInsertedWeather);
        return new ModelAndView(XML_VIEW_NAME, "object", w);
    }

    //3 . devolver todos los climas de cada localidad de un estado para el día
    @RequestMapping(method=RequestMethod.GET, value="/weatherstate/{id}/{date}")
    public ModelAndView getWeatherOfCitiesForState(@PathVariable String id, @PathVariable String date) {
        List<Mweather> mw = null;
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");
        mw = daoWeather.listWeatherForAState(Integer.parseInt(id), new Date(sdf.parse(date).getTime()));
        }  catch (Exception e){
            e.printStackTrace();
        }
        return new ModelAndView(XML_VIEW_NAME, "mweather", mw);
    }


    //4 . pronostico extendido de provincia localidad fecha con el da y 10 dias adelante --GET


    //5 . modificar un clima completo de una localidad de un día de una hora -- PUT


}
