package tm;

/**
 * The TMInput class represents the input for a Turing Machine.
 */
public class TMInput {
    private String input;

    /**
     * Constructs a TMInput with the specified input string.
     *
     * @param input the input string for the Turing Machine
     */
    public TMInput(String input) {
        this.input = input;
    }

    /**
     * Returns the input string of the Turing Machine.
     *
     * @return the input string
     */
    public String getInput() {
        return input;
    }
}