package tm;

/**
 * @author Carson Magee
 * The TMConfiguration class represents the configuration of a Turing Machine at a given point in time.
 */
public class TMConfiguration {
    private TMState currentState;
    private TMTape tape;

    /**
     * Constructs a TMConfiguration with the specified current state and tape.
     *
     * @param currentState the current state of the Turing Machine
     * @param tape         the tape of the Turing Machine
     */
    public TMConfiguration(TMState currentState, TMTape tape) {
        this.currentState = currentState;
        this.tape = tape;
    }

    /**
     * Returns the current state of the Turing Machine.
     *
     * @return the current state
     */
    public TMState getCurrentState() {
        return currentState;
    }

    /**
     * Returns the tape of the Turing Machine.
     *
     * @return the tape
     */
    public TMTape getTape() {
        return tape;
    }

    /**
     * Returns a string representation of the TMConfiguration.
     *
     * @return a string representation of the TMConfiguration
     */
    @Override
    public String toString() {
        return "State: " + currentState + ", Tape: " + tape;
    }
}