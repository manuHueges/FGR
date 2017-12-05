package builders;

import com.company.City;

public class CityBuilder {

    private City city;

    public City builder(){
        city = new City();
        city.setId_state(1);
        city.setName("cordoba");
        city.setAbr("cba");
        city.setSize(1);
        city.setId_city(1);

        return city;
    }
}
