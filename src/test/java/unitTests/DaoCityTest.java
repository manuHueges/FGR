package unitTests;

import DAO.SqlAdapter.ConnectionSingletonJBDC;
import DAO.SqlAdapter.DaoCity;
import builders.CityBuilder;
import com.company.City;
import javafx.scene.shape.Circle;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class DaoCityTest {

    private City city = new CityBuilder().withIdCity(103).withName("asd").withAbr("asd").withSize(1).withIdState(1).builder();
    int id_atm ;
    private static DaoCity daoCity;


    @BeforeClass
    public static void initialize(){
        daoCity = new DaoCity();
        ConnectionSingletonJBDC.ConfigureDriversForConnection("org.h2.Driver","jdbc:h2:mem:test;MODE=MYSQL;INIT=runscript from '´C:\\Script.sql'","sa","");

    }


    @Test
    public void insertAtmTest(){
        id_atm = daoCity.insert(city);
        assertTrue("inserted id is greater than 0", id_atm > 0);
    }

}
