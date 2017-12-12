package builders;


import com.company.State;

public class StateBuilder {

    private int id_state = 1;
    private int id_country = 1;
    private String name = "State TEST";
    private String abr = "tst";
    private String capital = "Test";
    private int size = 1;

    public StateBuilder withIdState(int id_state){
        this.id_state = id_state;
        return this;
    }

    public StateBuilder withIdCountry(int id_country){
        this.id_country = id_country;
        return this;
    }

    public StateBuilder withName(String name){
        this.name = name;
        return this;
    }

    public StateBuilder withAbr(String abr){
        this.abr = abr;
        return this;
    }

    public StateBuilder withCapital(String capital){
        this.capital = capital;
        return this;
    }

    public StateBuilder withSize(int size){
        this.size = size;
        return this;
    }

    public State builder() {

        State s = new State();
        s.setId_state(id_state);
        s.setId_country(id_country);
        s.setName(name);
        s.setAbr(abr);
        s.setCapital(capital);
        s.setSize(size);
        return s;
    }

}
