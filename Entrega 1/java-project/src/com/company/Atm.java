package com.company;

public class Atm {
    private int id_atm;
    private int humidity;
    private float pressure;
    private double visibility;
    private int rising;
/*
    public Atm (int id_atm, int humidity, float pressure, double visibility, int rising) {
        this.id_atm = id_atm;
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.rising = rising;
    }*/

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

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
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
 /*   @Override
    public String toString(){
        String s="";
        s = String.valueOf(getHumidity() + getId_atm() + getRising() + getPressure() + getVisibility());
        return s;
    }*/
}
