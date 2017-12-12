package unitTests;

import DAO.SqlAdapter.ConnectionSingletonJBDC;
import DAO.SqlAdapter.DaoCountry;
import builders.CountryBuilder;
import com.company.Country;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class DaoCountryTest {
    private Country country;
    int id_country;
    private static DaoCountry daoCountry;


    @BeforeClass
    public static void initialize(){
        daoCountry = new DaoCountry();
        ConnectionSingletonJBDC.ConfigureDriversForConnection("org.h2.Driver","jdbc:h2:mem:test;MODE=MYSQL;INIT=runscript from '´C:\\Script.sql'","sa","");

    }

    @Test
    public void insertAtmTest(){
        country = new CountryBuilder().withCod_c_2("TT").withcod_c_3("TTT").withName("test").builder();

        id_country = daoCountry.insert(country);

        assertTrue("inserted id is greater than 0", id_country > 0);
    }



}


