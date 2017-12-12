package com.company;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "atm")
public class Atm {
    private int id_atm;
    private int humidity;
    private double pressure;
    private double visibility;
    private int rising;


    public int getId_atm() {
        return id_atm;
    }

    public void setId_atm(int id_atm) { this.id_atm = id_atm; }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

}
