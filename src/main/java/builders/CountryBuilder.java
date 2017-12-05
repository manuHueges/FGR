package builders;

import com.company.Country;

public class CountryBuilder {

    private Country country;

    public Country builder() {
        country = new Country();

        country.setId_country(1);
        country.setName("Argentina");
        country.setCod_c_2("Ar");
        country.setCod_c_3("Arg");

        return country;
    }
}
