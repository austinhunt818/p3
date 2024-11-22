package tm;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Carson Magee
 * @author Austin Hunt
 * The TMTape class represents the tape of a Turing Machine.
 */
public class TMTape {
    private HashMap<Integer, Integer> tape;
    private int headPosition;

    /**
     * Constructs a TMTape with the specified input string.
     *
     * @param input the input string for the Turing Machine
     */
    public TMTape(String input) {
        tape = new HashMap<>();
        headPosition = 0;
        for (char c : input.toCharArray()) {
            if(c != '0') tape.put(headPosition, Character.getNumericValue(c));
            headPosition++;
        }
        headPosition = 0;
    }

    /**
     * Reads the symbol at the current head position.
     *
     * @return the symbol at the current head position
     */
    public int read() {
        return tape.getOrDefault(headPosition, 0);
    }

    /**
     * Writes the specified symbol at the current head position.
     *
     * @param symbol the symbol to write
     */
    public void write(int symbol) {
        if(symbol == 0) tape.remove(headPosition);
        else tape.put(headPosition, symbol);
    }

    /**
     * Moves the head to the right or left.
     *
     * @param right true if the head moves right, false if it moves left
     */
    public void moveHead(boolean right) {
        if (right) {
            headPosition++;
        } else {
            headPosition--;
        }
    }

    /**
     * Returns a string representation of the tape.
     *
     * @return a string representation of the tape
     */
    @Override
    public String toString() {
        int min = tape.keySet().stream().min(Integer::compare).orElse(0);
        int max = tape.keySet().stream().max(Integer::compare).orElse(0);
        StringBuilder builder = new StringBuilder();
        for (int i = min; i <= max; i++) {
            builder.append(tape.getOrDefault(i, 0));
        }
        return builder.toString();
    }
}