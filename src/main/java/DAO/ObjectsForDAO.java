package DAO;
import com.company.*;

import java.sql.Connection;
import java.util.List;

public interface ObjectsForDAO<T> {


    public Connection connection = ConnnectionSingletonJBDC.getInstance().getConnection();

    public List<T> loadList();

    public T select (int id);
    public int insert(T object);
    public String update(T object);
    public String delete(T object);


}
