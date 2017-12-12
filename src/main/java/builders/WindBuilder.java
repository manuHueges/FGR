package builders;

import com.company.Wind;

public class WindBuilder {

    private int id_wind = 1;
    private double speed = 1;
    private int direction = 1;

    public WindBuilder withId(int id_wind){
        this.id_wind = id_wind;
        return this;
    }

    public WindBuilder withDirection (int direction){
        this.direction = direction;
        return this;
    }

    public WindBuilder withSpeed(double speed){
        this.speed = speed;
        return this;
    }



    public Wind builder(){

        Wind w = new Wind();
        w.setId_wind(id_wind);
        w.setSpeed(speed);
        w.setDirection(direction);
        return w;

    }
}
