package tm;

import java.util.*;

/**
 * @author Austin Hunt
 * @author Carson Magee
 * The TM class represents a Turing Machine.
 */
public class TM {
    private HashMap<Integer, TMState> states = new HashMap<>();
    private String tmInput;

    /**
     * Constructs a Turing Machine with the specified number of states and symbols, and initializes it with the given transitions.
     *
     * @param numStates   the number of states in the Turing Machine
     * @param numSymbols  the number of symbols in the Turing Machine's alphabet
     * @param transitions a LinkedList of strings representing the transitions
     */
    public TM(int numStates, int numSymbols, LinkedList<String> transitions, String tmInput) {
        this.tmInput = tmInput;

        for (int i = 0; i < numStates; i++) {
            states.put(i, new TMState("" + i));
        }

        ListIterator<String> iterator = transitions.listIterator();

        for (int i = 0; i < numStates - 1; i++) {
            for (int j = 0; j <= numSymbols; j++) {
                if (!iterator.hasNext()) break;
                String currTransition = iterator.next();
                String[] parts = currTransition.split(",");
                int toState = Integer.parseInt(parts[0]);
                int writeSymb = Integer.parseInt(parts[1]);
                boolean moveRight = parts[2].equals("R");

                states.get(i).addTransition(j, writeSymb, moveRight, states.get(toState));
            }
        }
    }

    /**
     * Simulates the Turing Machine with the given input.
     */
    public TMTape simulateTM() {
        TMTape tape = new TMTape(tmInput);
        TMConfiguration config = new TMConfiguration(states.get(0), tape);

//        double start = System.currentTimeMillis();
        while (true) {
            TMState currentState = config.getCurrentState();
            int currentSymbol = tape.read();
            TMTransition transition = currentState.getTransition(currentSymbol);

            if (transition == null) {
                break;
            }

            tape.write(transition.writeSymb());
            tape.moveHead(transition.moveRight());
            config = new TMConfiguration(transition.toState(), tape);
        }

        return tape;
//        System.out.println("Final Configuration: " + config);
//        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start)/1000 + " seconds");
    }
}