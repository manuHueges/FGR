package builders;

import com.company.City;

public class CityBuilder {

    private City city;
    private int id_city = 1;
    private int id_state = 1;
    private String name = "Test";
    private String abr = "tst";
    private int size = 1;

    public CityBuilder withIdCity (int id_city){
        this.id_city = id_city;
        return this;
    }

    public CityBuilder withIdState (int id_state){
        this.id_state = id_state;
        return this;
    }

    public CityBuilder withName(String name){
        this.name = name;
        return this;
    }

    public CityBuilder withAbr(String abr){
        this.abr = abr;
        return this;
    }

    public CityBuilder withSize(int size){
        this.size = size;
        return this;
    }

    public City builder(){

        City c= new City();
        c.setId_city(id_city);
        c.setId_state(id_state);
        c.setName(name);
        c.setAbr(abr);
        c.setSize(size);

        return c;
    }
}
