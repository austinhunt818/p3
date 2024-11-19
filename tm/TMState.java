package tm;

import java.util.HashMap;

/**
 * The TMState class represents a state in a Turing Machine.
 */
public class TMState extends State {
    private HashMap<Integer, TMTransition> transitions = new HashMap<>();

    /**
     * Constructs a TMState with the specified name.
     *
     * @param name the name of the state
     */
    public TMState(String name) {
        super(name);
    }

    /**
     * Returns the name of the state.
     *
     * @return the name of the state
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * Returns a string representation of the state.
     *
     * @return a string representation of the state
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Adds a transition to the state.
     *
     * @param onSymb   the symbol on which the transition occurs
     * @param writeSymb the symbol to write on the tape
     * @param right    true if the head moves right, false if it moves left
     * @param toState  the state to transition to
     */
    public void addTransition(int onSymb, int writeSymb, boolean right, TMState toState) {
        transitions.put(onSymb, new TMTransition(onSymb, toState, writeSymb, right));
    }

    /**
     * Returns the transition for the given symbol.
     *
     * @param onSymb the symbol on which the transition occurs
     * @return the transition for the given symbol
     */
    public TMTransition getTransition(int onSymb) {
        return transitions.get(onSymb);
    }
}