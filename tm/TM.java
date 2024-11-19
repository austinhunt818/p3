package tm;

import java.util.*;

/**
 * The TM class represents a Turing Machine.
 */
public class TM {
    public HashMap<Integer, TMState> states = new HashMap<>();

    /**
     * Constructs a Turing Machine with the specified number of states and symbols, and initializes it with the given transitions.
     *
     * @param numStates   the number of states in the Turing Machine
     * @param numSymbols  the number of symbols in the Turing Machine's alphabet
     * @param transitions a LinkedList of strings representing the transitions
     */
    public TM(int numStates, int numSymbols, LinkedList<String> transitions) {
        for (int i = 0; i < numStates; i++) {
            states.put(i, new TMState("" + i));
        }

        ListIterator<String> iterator = transitions.listIterator();

        for (int i = 0; i < numStates - 1; i++) {
            for (int j = 0; j <= numSymbols; j++) {
                String currTransition = iterator.next();

                states.get(i).addTransition(
                        j,
                        Integer.parseInt(currTransition.substring(2, 3)),
                        currTransition.substring(4).equals("R"),
                        states.get(Integer.parseInt(currTransition.substring(0, 1)))
                );
            }
        }
    }
}