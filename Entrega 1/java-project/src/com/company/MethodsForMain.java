package com.company;
import DAO.JDBCdao;
import DAO.ObjectsForDAO;

import java.text.SimpleDateFormat;
import java.util.Scanner;


public class MethodsForMain {
    ObjectsForDAO interfaz = new JDBCdao();
    //Opción 1




    public void showCountry() {
        for(Country s : interfaz.loadCountryList()) {
            System.out.println(s.getId_country() + " - " + s.getName());
        }
    }

    public void showState(int id_country) {
        for(State s : interfaz.loadStateList(id_country)) {
            System.out.println(s.getId_state() + " - " + s.getName());
        }
    }

    public void showWeather(int id_state) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Weather w = interfaz.loadWeather(id_state);
        System.out.println("Fecha: "+sdf.format(w.getDate()) +
        "  temperatura: "+ w.getDay().getTemperature() + " descripcion: " + w.getDay().getDescription());
    }


    public State createState(Scanner sc, ObjectsForDAO interfaz) {
        showCountry();
        System.out.println("seleccione un pais:");
        int idCountry = sc.nextInt();

        System.out.println("Ingrese el nombre:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese la abreviatura:");
        String abbr = sc.nextLine();

        System.out.println("Ingrese el tamaño:");
        int tamano = sc.nextInt();

        System.out.println("Ingrese la capital:");
        String capital = sc.nextLine();

        State state = new State();
        state.setName(nombre);
        state.setAbr(abbr);
        state.setSize(tamano);
        state.setCapital(capital);
        Country country2 = new Country();
        country2.setId_country(idCountry);
        state.setCountry(country2);
        return state;
    }


}
