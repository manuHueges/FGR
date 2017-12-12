package com.company;

import DAO.SqlAdapter.DaoWeather;
import DAO.YahooAdapter.YahooWeather;
import Transformer.TransformerManuWeather;
import YahooObjects.Channel;
import builders.WeatherBuilder;
import com.sun.corba.se.impl.oa.toa.TransientObjectManager;
import proxy.Proxy;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);// Scanner para el ingreso de datos


        System.out.println("--------------------------------------------");
        System.out.println("¡¡¡¡¡¡¡¡¡ WELLCOME TO manuWeather !!!!!!!!!!");
        System.out.println("--------------------------------------------");
        System.out.println("                      -                     ");



        List<City> cities = null;
        try {
            cities = Proxy.getWeatherForState("cordoba");
        } catch(Exception e) {
            e.printStackTrace();
        }
        CityList cityList = new CityList();
        cityList.setCities(cities);
        System.out.println(cities);

        /* RESAVIO DE MUESTRA POR CONSOLA

        //Cargo un clima

        Weather we = new Weather();
        Wind wi = new Wind();
        Atm atm = new Atm();
        DaoWeather dw = new DaoWeather();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            //Seteo un nuevo clima
            we.setId_weather(1);
            we.setId_city(1);
            we.setDate(new Date(sdf.parse("01/10/2017 15:00").getTime()));
            we.setMax(20);
            we.setMin(12);
            we.setTemperature(30);
            we.setDescription("soleado");
            we.setId_day(1);
            atm.setId_atm(1);
            atm.setRising(0);// no cambia nada
            atm.setPressure(0);// idem
            atm.setHumidity(0);// idem
            atm.setVisibility(0);// idem
            wi.setId_wind(1);
            wi.setSpeed(1);// idem
            wi.setDirection(1);// idem
            we.setWind(wi);
            we.setAtm(atm);
            //inserto nuevo clima
            dw.insert(we);
        } catch(Exception e) {

            System.out.println("Error al insertar clima");
        }


        System.out.println("ESTADOS");


        DaoState ds= new DaoState();
        List<State> lstState = new LinkedList<>();
        lstState = ds.loadList();
        for (State s : lstState) {
            System.out.println("id: " + s.getId_state());
            System.out.println("Estado: " + s.getName());
            System.out.println("abreviatura: " + s.getAbr());
            System.out.println("tamanio: " + s.getSize());
            System.out.println("id de paìs: " + s.getId_country());
            System.out.println("capital: " + s.getCapital());
            System.out.println();

        }


        System.out.println("CLIMAS");
        List<Weather> lstWeather = new LinkedList<>();
        lstWeather = dw.loadList();
        for (Weather w : lstWeather) {
            System.out.println("id: " + w.getId_weather());
            System.out.println("id de Estado " + w.getId_city());
            System.out.println("Fecha " + w.getDate());
            System.out.println("temperatura " + w.getTemperature());
            System.out.println("Descripcion " + w.getDescription());
            System.out.println("DATOS DEL VIENTO");
            System.out.println("Velocidad "+ w.getWind().getSpeed() );
            System.out.println("Direccion: " + w.getWind().getDirection());
            System.out.println("DATOS DE LA ATMOSFERA");
            System.out.println("Humedad: " + w.getAtm().getHumidity());
            System.out.println("presion: "+ w.getAtm().getPressure());
            System.out.println("visibilidad: " + w.getAtm().getVisibility());
            System.out.println();

        }*/







    }

}
