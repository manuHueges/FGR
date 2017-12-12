package com.company;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "forecastList")
public class ForecastList {

    private List<Weather> forecastList = new LinkedList<>();

    public List<Weather> getForecastList() {
        return forecastList;
    }

    public void setForecastList(List<Weather> forecastList) {
        this.forecastList = forecastList;
    }
}
