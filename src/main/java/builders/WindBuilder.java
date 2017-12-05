package builders;

import com.company.Wind;

public class WindBuilder {

    private Wind wind;

    public Wind builder(){
        wind = new Wind();
        wind.setId_wind(1);
        wind.setDirection(1);
        wind.setSpeed(1);

        return wind;
    }
}
