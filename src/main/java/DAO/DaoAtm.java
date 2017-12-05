package DAO;

import com.company.Atm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DaoAtm implements ObjectsForDAO<Atm>{

    @Override
    public List<Atm> loadList() {
        List<Atm> lst = new LinkedList<Atm>();
        try {
            String query = "SELECT * FROM atm";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Atm atm = new Atm();
                atm.setId_atm(rs.getInt("id_atm"));
                atm.setHumidity(rs.getInt("humidity"));
                atm.setPressure(rs.getFloat("pressure"));
                atm.setVisibility(rs.getDouble("visibility"));
                atm.setRising(rs.getInt("rising"));
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
    public Atm select(int id) {
        try {
            String query = "SELECT * FROM atm WHERE id_atm = "+id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            Atm atm = new Atm();
            atm.setId_atm(rs.getInt("id_atm"));
            atm.setHumidity(rs.getInt("humidity"));
            atm.setPressure(rs.getFloat("pressure"));
            atm.setVisibility(rs.getDouble("visibility"));
            atm.setRising(rs.getInt("rising"));

            st.close();
            rs.close();
            return atm;
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int insert(Atm atm) {
        try {
            int idAtm = 0;
            String query = "SELECT max(id_atm) as id FROM atm";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idAtm = rs.getInt("id");
            idAtm++;
            atm.setId_atm(idAtm);
            st.close();
            rs.close();

            query = "insert into atm(id_atm, humidity, pressure, visibility, rising) values("+atm.getId_atm()
                    +", "+atm.getHumidity()+", "+atm.getPressure()+", "+atm.getVisibility()+", "+atm.getRising()+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            return idAtm;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String update(Atm atmUpdated) {
        String s;
        try {
            String query = "UPDATE atm(id_atm, humidity, pressure, visibility, rising) values("+atmUpdated.getId_atm()
                    +", "+atmUpdated.getHumidity()+", "+atmUpdated.getPressure()+", "+atmUpdated.getVisibility()+", "+atmUpdated.getRising()+")";
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
    public String delete(Atm atm) {
        String s;
        try {
            String query = "DELETE * FROM atm WHERE id_atm = "+atm.getId_atm();
            Statement st = connection.createStatement();
            st.executeQuery(query);
            s = "Delete Exitoso";
        } catch (Exception e) {
        s = ("ERROR ELIMINANDO ATMOSFERA!!" + e.getMessage());

        }
        return s;
    }
}
