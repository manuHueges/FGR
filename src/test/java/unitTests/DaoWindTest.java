package unitTests;

import DAO.SqlAdapter.ConnectionSingletonJBDC;
import DAO.SqlAdapter.DaoWeather;
import DAO.SqlAdapter.DaoWind;
import builders.WindBuilder;
import com.company.Wind;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DaoWindTest {

    private Wind wind = new WindBuilder().withSpeed(200).builder();
    int id_atm ;
    private static DaoWind daoWind;


    @BeforeClass
    public static void initialize(){
        daoWind = new DaoWind();
        ConnectionSingletonJBDC.ConfigureDriversForConnection("org.h2.Driver","jdbc:h2:mem:test;MODE=MYSQL;INIT=runscript from '´C:\\Script.sql'","sa","");

    }


    @Test
    public void insertAtmTest(){
        id_atm = daoWind.insert(wind);
        assertTrue("inserted id is greater than 0", id_atm > 0);
    }

}
