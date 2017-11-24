package com.company;

public class Forecast {
    private int id_forecast;
    private int id_forecast_day1;
    private int id_forecast_day2;
    private int id_forecast_day3;
    private int id_forecast_day4;
    private int id_forecast_day5;
    private int id_forecast_day6;
    private int id_forecast_day7;
    private int id_forecast_day8;
    private int id_forecast_day9;
    private int id_forecast_day10;

    private ForeUnit[] foreUs;

    public ForeUnit getForeUnits(int lugarEnArreglo){
        ForeUnit fu = new ForeUnit();
        fu = foreUs[lugarEnArreglo];
        return fu;
    };

    public ForeUnit[] getForeUs() {

        return foreUs;
    }

    public void setForeUs(ForeUnit[] foreUs) {
        this.foreUs = foreUs;
    }


    //contiene un arreglo con los 10 días y un metodo para cargar cada día;
    public void LoadForecast( ForeUnit foreunit){
        setForeUs(new ForeUnit[10]);
        for (int i=0; i< 9; i++) {
            if (getForeUs()[i] == null){
                getForeUs()[i] = foreunit;
                break;
            }
        }
    }

    public void forecastSetID(int idInicial){
        for (int i = 0; i < 10; i++){
            foreUs[i].setId_fore_day(idInicial+1);
        }
    }

    public void completeIds(int idForecastDayss){
        setId_forecast_day1(idForecastDayss+1);
        setId_forecast_day2(idForecastDayss+2);
        setId_forecast_day3(idForecastDayss+3);
        setId_forecast_day4(idForecastDayss+4);
        setId_forecast_day5(idForecastDayss+5);
        setId_forecast_day6(idForecastDayss+6);
        setId_forecast_day7(idForecastDayss+7);
        setId_forecast_day8(idForecastDayss+8);
        setId_forecast_day9(idForecastDayss+9);
        setId_forecast_day10(idForecastDayss+10);

    }

    public int getId_forecast() {
        return id_forecast;
    }

    public void setId_forecast(int id_forecast) {
        this.id_forecast = id_forecast;
    }

    public int getId_forecast_day1() {
        return id_forecast_day1;
    }

    public void setId_forecast_day1(int id_forecast_day1) {
        this.id_forecast_day1 = id_forecast_day1;
    }

    public int getId_forecast_day2() {
        return id_forecast_day2;
    }

    public void setId_forecast_day2(int id_forecast_day2) {
        this.id_forecast_day2 = id_forecast_day2;
    }

    public int getId_forecast_day3() {
        return id_forecast_day3;
    }

    public void setId_forecast_day3(int id_forecast_day3) {
        this.id_forecast_day3 = id_forecast_day3;
    }

    public int getId_forecast_day4() {
        return id_forecast_day4;
    }

    public void setId_forecast_day4(int id_forecast_day4) {
        this.id_forecast_day4 = id_forecast_day4;
    }

    public int getId_forecast_day5() {
        return id_forecast_day5;
    }

    public void setId_forecast_day5(int id_forecast_day5) {
        this.id_forecast_day5 = id_forecast_day5;
    }

    public int getId_forecast_day6() {
        return id_forecast_day6;
    }

    public void setId_forecast_day6(int id_forecast_day6) {
        this.id_forecast_day6 = id_forecast_day6;
    }

    public int getId_forecast_day7() {
        return id_forecast_day7;
    }

    public void setId_forecast_day7(int id_forecast_day7) {
        this.id_forecast_day7 = id_forecast_day7;
    }

    public int getId_forecast_day8() {
        return id_forecast_day8;
    }

    public void setId_forecast_day8(int id_forecast_day8) {
        this.id_forecast_day8 = id_forecast_day8;
    }

    public int getId_forecast_day9() {
        return id_forecast_day9;
    }

    public void setId_forecast_day9(int id_forecast_day9) {
        this.id_forecast_day9 = id_forecast_day9;
    }

    public int getId_forecast_day10() {
        return id_forecast_day10;
    }

    public void setId_forecast_day10(int id_forecast_day10) {
        this.id_forecast_day10 = id_forecast_day10;
    }



}
