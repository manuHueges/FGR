package com.company;

import java.util.Date;

public class Day {
    private int id_day;
    private int temperature;
    private String description;
    private Date date;



    public int getId_day() {
        return id_day;
    }

    public void setId_day(int id_day) { this.id_day = id_day; }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}
