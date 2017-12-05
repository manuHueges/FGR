package builders;


import com.company.State;

public class StateBuilder {

    private State state;

    public State builder() {
        state = new State();
        state.setId_state(1);
        state.setId_country(1);
        state.setName("Cordoba");
        state.setAbr("cba");
        state.setCapital("cordoba");
        state.setSize(1);

        return state;
    }

}
