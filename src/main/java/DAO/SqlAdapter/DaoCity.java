package DAO.SqlAdapter;

import DAO.IDaoAdapter.ObjectsForDAO;
import com.company.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DaoCity implements ObjectsForDAO<City> {


    private Connection connection = ConnectionSingletonJBDC.getInstance().getConnection();



    public List<City> getCitiesOfState(String state) {
        List<City> lst = new LinkedList<City>();
        try {
            String query = "SELECT c.*, (select abr from state s where s.id_state = c.id_state) as state_abr " +
                    " FROM city c " +
                    " WHERE exists(select 1 from state s where s.id_state = c.id_state and s.name = '" + state + "' )";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                City city = new City();
                city.setId_city(rs.getInt("id_city"));
                city.setName(rs.getString("name"));
                city.setAbr(rs.getString("abr"));
                city.setSize(rs.getInt("size"));
                city.setId_state(rs.getInt("id_state"));
                city.setStateAbr(rs.getString("state_abr"));
                lst.add(city);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public List<City> loadList() {
        List<City> lst = new LinkedList<City>();
        try {
            String query = "SELECT * FROM city";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                City city = new City();
                city.setId_city(rs.getInt("id_city"));
                city.setName(rs.getString("name"));
                city.setAbr(rs.getString("abr"));
                city.setSize(rs.getInt("size"));
                city.setId_state(rs.getInt("id_state"));
                lst.add(city);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public City select(int id) {
        try {
            String query = "SELECT * FROM city WHERE id_city = " + id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            City city = new City();
            city.setId_city(rs.getInt("id_city"));
            city.setName(rs.getString("name"));
            city.setAbr(rs.getString("abr"));
            city.setSize(rs.getInt("size"));
            city.setId_state(rs.getInt("id_state"));

            st.close();
            rs.close();
            return city;
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int insert(City newCity) {
        try {
            int idCity = 0;
            String query = "SELECT max(id_city) as id FROM city";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idCity= rs.getInt("id");
            idCity++;
            newCity.setId_city(idCity);
            st.close();

            query = "insert into city(id_city, name, abr, size, id_state) values(" + newCity.getId_city()
                    + ", '" + newCity.getName() + "', '" + newCity.getAbr() + "', " + newCity.getSize() + ", "
                    + newCity.getId_state() +")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            return idCity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String update(City cityUpdated) {
        String s;
        try {
            String query = "UPDATE city(id_city, name, abr, size, id_state) values(" + cityUpdated.getId_state()
                    + ", '" + cityUpdated.getName() + "', '" + cityUpdated.getAbr() + "', " + cityUpdated.getSize() +
                    ", "+ cityUpdated.getId_state()+ ")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            s = "Update Exitoso!";
            return s;
        } catch (Exception e) {
            s = "ERROR! " + e.getMessage();
        }
        return s;
    }

    @Override
    public String delete(City cityToDelete) {
        String s;
        try {
            String query = "DELETE * FROM city WHERE id_city = " + cityToDelete.getId_state();
            Statement st = connection.createStatement();
            st.executeQuery(query);
            st.close();
            s = "Delete Exitoso";
        } catch(Exception e) {
            s = ("ERROR ELIMINANDO STATE!!" + e.getMessage());
        }
        return s;
    }

    public City select(String name, String stateAbr) {
        try {
            String query = "SELECT * FROM city c WHERE name = " + name + " and exists(select 1 from state s where s.id_state = c.id_state and s.abr = "+stateAbr+" ) ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            City city = new City();
            city.setId_city(rs.getInt("id_city"));
            city.setName(rs.getString("name"));
            city.setAbr(rs.getString("abr"));
            city.setSize(rs.getInt("size"));
            city.setId_state(rs.getInt("id_state"));

            st.close();
            rs.close();
            return city;
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }
}
