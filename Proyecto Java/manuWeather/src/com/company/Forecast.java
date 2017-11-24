package com.company;

import java.util.List;

public class Forecast {

    private String location;
    private List<Weather> extendedWeathers;




    public String getLocation() {
        return location;
    }

    public void setIdLocation(String location) {
        this.location = location;
    }


    public List<Weather> getExtendedWeathers() {
        return extendedWeathers;
    }

    public void setExtendedWeathers(List<Weather> extendedWeathers) {
        this.extendedWeathers = extendedWeathers;
    }
}
