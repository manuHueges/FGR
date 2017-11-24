package com.company;

import java.util.Date;

public class ForeUnit {
    private int id_fore_day;
    private Date date;
    private String dayName;
    private int max;
    private int min;
    private String description;


    public int getId_fore_day() { return id_fore_day; }

    public void setId_fore_day(int id_fore_day) {
        this.id_fore_day = id_fore_day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* @Override
    public String toString(){
        String s ="";
        s = getId_fore_day() + getDayName() + getMax() + getMin() + getDate() + getDescription();
        return s;
    }*/

}
