package tm;

import java.util.*;

public class TM {
    public HashMap<Integer, TMState> states = new HashMap<>();

    public TM(int numStates, int numSymbols, LinkedList<String> transitions){
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
    }



}
