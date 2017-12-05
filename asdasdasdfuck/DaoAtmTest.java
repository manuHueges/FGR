

import DAO.DaoAtm;
import builders.AtmBuilder;
import com.company.Atm;
import com.mysql.jdbc.Connection;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



public class DaoAtmTest {

    private DaoAtm dao;
    private Atm atm;



    @Test
    public void selectAtm(){

        atm = AtmBuilder.build();

        dao.insert(atm);

        dao.select(1);


    }


}