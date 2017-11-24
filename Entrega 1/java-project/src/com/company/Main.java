package com.company;

import DAO.JDBCdao;
import DAO.ObjectsForDAO;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);// Scanner para el ingreso de datos
        MethodsForMain metodos = new MethodsForMain();
        int option = 0; // para las selecciones del menú

        System.out.println("--------------------------------------------");
        System.out.println("¡¡¡¡¡¡¡¡¡ WELLCOME TO manuWeather !!!!!!!!!!");
        System.out.println("--------------------------------------------");
        System.out.println("                      -                     ");


        // ruleta del menu, continua hasta que option sea configurado en SALIR
        while (option != 3) {
            System.out.println("MENU");
            System.out.println("seleccione una opcion:");
            System.out.println("1- Ver el clima de una zona determinada");
            System.out.println("2- Ingresar datos del clima o pasises en la base de datos");
            System.out.println("3- Salir");
            option = sc.nextInt();
            switch (option) {
                case 1: {
                    int selectionCase1;
                    metodos.showCountry();
                    System.out.println("seleccione un país");
                    selectionCase1 = sc.nextInt();
                    metodos.showState(selectionCase1);
                    System.out.println("Seleccione el estado para mostrar el clima");
                    selectionCase1 = sc.nextInt();
                    metodos.showWeather(selectionCase1);
                    break;
                }//CASE 1
                case 2: {
                    int option2 = 0;
                    while (option2 != 3) {
                        System.out.println("MENU");
                        System.out.println("seleccione una opcion:");
                        System.out.println("1- Paises");
                        System.out.println("2- Estados");
                        System.out.println("3- Salir");
                        option2 = sc.nextInt();
                        switch (option) {
                            case 1: {
                                break;
                            }//CASE 1
                            case 2: {
//                                State state = metodos.createState(sc, interfaz);
//
//                                int idState = interfaz.insertState(state);
//                                if (idState == -1) {
//
//                                } else {
//                                    option2 = 3;
//                                }
                                break;
                            }//CASE 2
                            default:
                                System.out.println("Ingrese un VALOR de opción válido");
                                break;
                        }
                    }
                    break;
                }//CASE 2
                case 3: {
                    break;
                }//CASE 3
                default:
                    System.out.println("Ingrese un VALOR de opción válido");
                    break;
            }//SWHITCH
        }//WHILE


    }

}
