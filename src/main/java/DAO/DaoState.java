package DAO;

import com.company.Country;
import com.company.State;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DaoState implements ObjectsForDAO<State> {

    public List<State> loadListForACountry(int id_country) {
        List<State> lst = new LinkedList<State>();
        try {
            String query = "SELECT * FROM state WHERE id_country = " + id_country;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                State state = new State();
                state.setId_state(rs.getInt("id_state"));
                state.setName(rs.getString("name"));
                state.setAbr(rs.getString("abr"));
                state.setSize(rs.getInt("size"));
                state.setCapital(rs.getString("capital"));
                state.setId_country(rs.getInt("id_country"));
                lst.add(state);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("wuops! ");
            System.err.println(e.getMessage());
        }
        return lst;
    }

    @Override
    public List<State> loadList() {
        List<State> lst = new LinkedList<State>();
        try {
            String query = "SELECT * FROM state";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                State state = new State();
                state.setId_state(rs.getInt("id_state"));
                state.setName(rs.getString("name"));
                state.setAbr(rs.getString("abr"));
                state.setSize(rs.getInt("size"));
                state.setCapital(rs.getString("capital"));
                state.setId_country(rs.getInt("id_country"));
                lst.add(state);
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
    public State select(int id) {
        try {
            String query = "SELECT * FROM state WHERE id_state = " + id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            State state = new State();
            state.setId_state(rs.getInt("id_country "));
            state.setName(rs.getString("name"));
            state.setAbr(rs.getString("abr"));
            state.setSize(rs.getInt("size"));
            state.setCapital(rs.getString("capital"));
            state.setId_country(rs.getInt("id_country"));

            st.close();
            rs.close();
            return state;
        } catch (Exception e) {
            System.err.println("ERROR! ");
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int insert(State newState) {
        try {
            int idState = 0;
            String query = "SELECT max(id_state) as id FROM state";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            idState= rs.getInt("id");
            idState++;
            newState.setId_country(idState);
            st.close();

            query = "insert into state(id_state, name, abr, size, capital, id_country) values(" + newState.getId_state()
                    + ", '" + newState.getName() + "', '" + newState.getAbr() + "', " + newState.getSize() + ", '" +
                    newState.getCapital() +"', "+ newState.getId_country() +")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return idState;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public String update(State stateUpdated) {
        String s;
        try {
            String query = "UPDATE state(id_state, name, abr, size, capital, id_country) values(" + stateUpdated.getId_state()
                    + ", '" + stateUpdated.getName() + "', '" + stateUpdated.getAbr() + "', " + stateUpdated.getSize() +
                    ", '"+ stateUpdated.getCapital() + "', "+ stateUpdated.getId_country()+ ")";
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
    public String delete(State stateToDelete) {
        String s;
        try {
            String query = "DELETE * FROM state WHERE id_state = " + stateToDelete.getId_state();
            Statement st = connection.createStatement();
            st.executeQuery(query);
            s = "Delete Exitoso";
        } catch(Exception e) {
            s = ("ERROR ELIMINANDO STATE!!" + e.getMessage());
        }
        return s;
    }
}
