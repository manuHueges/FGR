package DAO.SqlAdapter;

import DAO.IDaoAdapter.ObjectsForDAO;
import com.company.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DaoCountry implements ObjectsForDAO<Country> {


    private Connection connection = ConnectionSingletonJBDC.getInstance().getConnection();

    @Override
    public List loadList() {
        List<Country> lst = new LinkedList<Country>();
        try {
            String query = "SELECT * FROM country";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Country country = new Country();
                country.setId_country(rs.getInt("id_country"));
                country.setName(rs.getString("name"));
                lst.add(country);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public Country select(int id) {
        try {
            String query = "SELECT * FROM country WHERE id_country = " + id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            Country country = new Country();
            country.setId_country(rs.getInt("id_country "));
            country.setName(rs.getString("name"));
            country.setCod_c_2(rs.getString("cod_c_2"));
            country.setCod_c_3(rs.getString("cod_c_3"));

            st.close();
            rs.close();
            return country;
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int insert(Country newCountry) {
        try {
            int idCountry = 0;
            String query = "SELECT max(id_country) as id FROM country";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idCountry = rs.getInt("id");
            idCountry++;
            newCountry.setId_country(idCountry);
            st.close();

            query = "insert into country(id_country, name, cod_c_2, cod_c_3) values(" + newCountry.getId_country()
                    + ", '" + newCountry.getName() + "', '" + newCountry.getCod_c_2() + "', '" + newCountry.getCod_c_3() + "')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idCountry;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String update(Country countryUpdated) {
        String s;
        try {
            String query = "UPDATE country(id_country, name, cod_c_2, cod_c_3) values(" + countryUpdated.getId_country()
                    + ", '" + countryUpdated.getName() + "', '" + countryUpdated.getCod_c_2() + "', '" + countryUpdated.getCod_c_3() + "')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            s = "Update Exitoso!";
            return s;
        } catch (Exception e) {
            s = "ERROR! " + e.getMessage();
        }
        return s;
    }

    @Override
    public String delete(Country country){
        String s;
        try {
            String query = "DELETE * FROM country WHERE id_country = " + country.getId_country();
            Statement st = connection.createStatement();
            st.executeQuery(query);
            s = "Delete Exitoso";
        } catch(Exception e) {
            s = ("ERROR ELIMINANDO COUNTRY!!" + e.getMessage());
        }
        return s;
    }
}
