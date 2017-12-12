package com.company;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "state")
public class State {

    private int id_state;
    private String name;
    private String abr;
    private int size;
    private String capital;
    private int id_country;


    public int getId_state() {
        return id_state;
    }

    public void setId_state(int id_state) {
        this.id_state = id_state;
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

    public int getSize() { return size; }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }
}
