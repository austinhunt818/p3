package tm;

import java.util.ArrayList;

/**
 * The TMTape class represents the tape of a Turing Machine.
 */
public class TMTape {
    private ArrayList<Integer> tape;
    private int headPosition;

    /**
     * Constructs a TMTape with the specified input string.
     *
     * @param input the input string for the Turing Machine
     */
    public TMTape(String input) {
        tape = new ArrayList<>();
        for (char c : input.toCharArray()) {
            tape.add(Character.getNumericValue(c));
        }
        headPosition = 0;
    }

    /**
     * Reads the symbol at the current head position.
     *
     * @return the symbol at the current head position
     */
    public int read() {
        return tape.get(headPosition);
    }

    /**
     * Writes the specified symbol at the current head position.
     *
     * @param symbol the symbol to write
     */
    public void write(int symbol) {
        tape.set(headPosition, symbol);
    }

    /**
     * Moves the head to the right or left.
     *
     * @param right true if the head moves right, false if it moves left
     */
    public void moveHead(boolean right) {
        if (right) {
            headPosition++;
            if (headPosition == tape.size()) {
                tape.add(0); // Assuming blank symbol is 0
            }
        } else {
            if (headPosition > 0) {
                headPosition--;
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(0);
                newList.addAll(tape);
                tape = newList;
            }
        }
    }

    /**
     * Returns a string representation of the tape.
     *
     * @return a string representation of the tape
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tape.size(); i++) {
            if (i == headPosition) {
                sb.append("[").append(tape.get(i)).append("]");
            } else {
                sb.append(tape.get(i));
            }
        }
        return sb.toString();
    }
}