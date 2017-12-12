package DAO.IDaoAdapter;



import com.company.City;

import java.util.List;

public interface ObjectsForDAO<T> {

    public List<T> loadList();

    public T select (int id);
    public int insert(T object);
    public String update(T object);
    public String delete(T object);


}
