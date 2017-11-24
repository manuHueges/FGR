package com.company;

import java.util.Date;

public class Weather {

    private int id_state;
    private Date date;
    private int id_day;
    private int id_atm;
    private int id_wind;
    private int id_forecast;

    private Day day;
    private Wind wind;
    private Atm atm;
    private Forecast forecast;

    public int getId_state() {
        return id_state;
    }

    public void setId_state(int id_state) {
        this.id_state = id_state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_day() {
        return id_day;
    }

    public void setId_day(int id_day) {
        this.id_day = id_day;
    }

    public int getId_wind() {
        return id_wind;
    }

    public void setId_wind(int id_wind) {
        this.id_wind = id_wind;
    }

    public int getId_atm() {
        return id_atm;
    }

    public void setId_atm(int id_atm) {
        this.id_atm = id_atm;
    }

    public int getId_forecast() {
        return id_forecast;
    }

    public void setId_forecast(int id_forecast) {
        this.id_forecast = id_forecast;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atm getAtm() {
        return atm;
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
