package builders;

import com.company.Atm;

public class AtmBuilder {

    private int id_atm = 1;
    private int humidity = 1;
    private float pressure = 1;
    private int rising = 1;
    private double visibility = 1;

    public AtmBuilder withId(int id_atm){
        this.id_atm = id_atm;
        return this;
    }

    public AtmBuilder withHumidity(int humidity){
        this.humidity = humidity;
        return this;
    }

    public AtmBuilder withPressure(float pressure){
        this.pressure = pressure;
        return this;
    }

    public AtmBuilder withRising(int rising){
        this.rising = rising;
        return this;
    }

    public AtmBuilder withVisibility(double visibility){
        this.visibility = visibility;
        return this;
    }


    public Atm builder(){
        Atm atm = new Atm();
        atm.setId_atm(id_atm);
        atm.setVisibility(visibility);
        atm.setHumidity(humidity);
        atm.setPressure(pressure);
        atm.setRising(rising);

        return atm;
    }

}
