package com.company;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class City {

    private int id_city;
    private String name;
    private String abr;
    private int size;
    private int id_state;

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId_state() {
        return id_state;
    }

    public void setId_state(int id_state) {
        this.id_state = id_state;
    }
}
