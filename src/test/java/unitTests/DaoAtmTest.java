package unitTests;

import DAO.SqlAdapter.ConnectionSingletonJBDC;
import DAO.SqlAdapter.DaoAtm;
import builders.AtmBuilder;
import com.company.Atm;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DaoAtmTest {

    private Atm atm = new AtmBuilder().withId(103).withHumidity(100).withPressure(1).withRising(0).withVisibility(1).builder();
    int id_atm ;
    private static DaoAtm daoAtm;


    @BeforeClass
    public static void initialize(){
        daoAtm = new DaoAtm();
        ConnectionSingletonJBDC.ConfigureDriversForConnection("org.h2.Driver","jdbc:h2:mem:test;MODE=MYSQL;INIT=runscript from '´C:\\Script.sql'","sa","");

    }

    @Test
    public void selectTest(){
        Atm atm = daoAtm.select(103);
        assertTrue("humidity equals to 100", atm.getHumidity() == 100);
    }

    @Test
    public void insertAtmTest(){
        id_atm = daoAtm.insert(atm);
        assertTrue("inserted id is greater than 0", id_atm > 0);
    }



}
