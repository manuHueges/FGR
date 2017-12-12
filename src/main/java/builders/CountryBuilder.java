package builders;

import com.company.Country;

public class CountryBuilder {

    private int id_country = 1;
    private String name = "Country Test";
    private String cod_c_2 = "Ts";
    private String cod_c_3 = "Tst";

    public CountryBuilder withId(int id_country){
        this.id_country = id_country;
        return this;
    }

    public CountryBuilder withName(String name){
        this.name = name;
        return this;
    }

    public CountryBuilder withCod_c_2(String cod_c_2){
        this.cod_c_2 = cod_c_2;
        return this;
    }

    public CountryBuilder withcod_c_3(String cod_c_3){
        this.cod_c_3 = cod_c_3;
        return this;
    }


    public Country builder() {

        Country c = new Country();
        c.setId_country(id_country);
        c.setCod_c_2(cod_c_2);
        c.setCod_c_3(cod_c_3);
        c.setName(name);
        return c;
    }
}
