package tm;

import java.util.*;

public class TM {
    private HashMap<Integer, TMState> states = new HashMap<>();

    private LinkedList<Character> tape = new LinkedList<>();

    public TM(int numStates, int numSymbols, LinkedList<String> transitions, String input){
        for(int i = 0; i < numStates; i++){
            states.put(i, new TMState(""+i));
        }

        ListIterator<String> iterator = transitions.listIterator();

        for(int i = 0; i < numStates-1; i++){
            for(int j = 0; j <= numSymbols; j++){
                String currTransition = iterator.next();

                states.get(i).addTransition(
                        j,
                        Integer.parseInt(currTransition.substring(2,3)),
                        currTransition.substring(4).equals("R"),
                        states.get(Integer.parseInt(currTransition.substring(0,1)))
                );
            }
        }

        for(char c : input.toCharArray()){
            tape.add(c);
        }

        System.out.println(tape);

    }



}
