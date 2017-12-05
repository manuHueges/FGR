package builders;

import com.company.Atm;

public class AtmBuilder {


    public static Atm build(){
        Atm atm = new Atm();
        atm.setId_atm(1);
        atm.setHumidity(1);
        atm.setPressure(1);
        atm.setRising(1);
        atm.setVisibility(1);
        return atm;
    }

}
