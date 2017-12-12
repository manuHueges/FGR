package com.company;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "wind")
public class Wind {
    private int id_wind;
    private double speed;
    private int direction;


    public int getId_wind() {
        return id_wind;
    }

    public void setId_wind(int id_wind) {
        this.id_wind = id_wind;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
