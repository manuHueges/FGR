package DAO;


import com.company.Wind;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DaoWind implements ObjectsForDAO<Wind> {

    @Override
    public List<Wind> loadList() {
        List<Wind> lst = new LinkedList<Wind>();
        try {
            String query = "SELECT * FROM wind";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Wind wind = new Wind();
                wind.setId_wind(rs.getInt("id_wind"));
                wind.setSpeed(rs.getInt("speed"));
                wind.setDirection(rs.getInt("direction"));
                lst.add(wind);
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
    public Wind select(int id) {
        try {
            String query = "SELECT * FROM wind WHERE id_wind = "+id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            Wind wind = new Wind();
            wind.setId_wind(rs.getInt("id_wind"));
            wind.setSpeed(rs.getInt("speed"));
            wind.setDirection(rs.getInt("direction"));

            st.close();
            rs.close();
            return wind;
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int insert(Wind newWind) {
        try {
            int idWind = 0;
            String query = "SELECT max(id_wind) as id FROM wind";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idWind = rs.getInt("id");
            idWind++;
            newWind.setId_wind(idWind);
            st.close();

            query = "insert into wind(id_wind, speed, direction) values("+newWind.getId_wind()
                    +", "+newWind.getSpeed()+", "+newWind.getDirection()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idWind;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String update(Wind windUpdated) {
        String s;
        try {
            String query = "UPDATE wind(id_wind, speed, direction) values("+windUpdated.getId_wind()
                    +", "+windUpdated.getSpeed()+", "+windUpdated.getDirection()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            s = "Update Exitoso!";
            return s;
        } catch (Exception e) {
            s = "ERROR! " + e.getMessage() ;
        }
        return s;
    }

    @Override
    public String delete(Wind wind) {
        String s;
        try {
            String query = "DELETE * FROM wind WHERE id_atm = "+wind.getId_wind();
            Statement st = connection.createStatement();
            st.executeQuery(query);
            s = "Delete Exitoso";
        } catch (Exception e) {
            s = ("ERROR ELIMINANDO WIND!!" + e.getMessage());

        }
        return s;
    }
}
