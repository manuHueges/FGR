package unitTests;

import DAO.SqlAdapter.ConnectionSingletonJBDC;
import DAO.SqlAdapter.DaoState;
import builders.StateBuilder;
import com.company.State;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class DaoStateTest {

    private State state;
    int id_state;
    private static DaoState daoState;


    @BeforeClass
    public static void initialize(){
        daoState = new DaoState();
        ConnectionSingletonJBDC.ConfigureDriversForConnection("org.h2.Driver","jdbc:h2:mem:test;MODE=MYSQL;INIT=runscript from '´C:\\Script.sql'","sa","");

    }

    @Test
    public void insertAtmTest(){
        state = new StateBuilder().withIdState(1).withAbr("test").withName("testing").withSize(10).builder();

        id_state = daoState.insert(state);

        assertTrue("inserted id is greater than 0", id_state > 0);
    }


}
