package tm;

import java.util.*;

public class TM {
    private HashMap<Integer, TMState> states = new HashMap<>();

    private LinkedList<Integer> tape = new LinkedList<>();
    private TMState currState;

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

        currState = states.get(0);

        for(char c : input.toCharArray()){
            tape.add(Integer.parseInt(c + ""));
        }
        if(tape.isEmpty()) tape.add(0);
    }

    public boolean fullSimulate(){
        ListIterator<Integer> iterator = tape.listIterator();
        int currCell = iterator.next();;
        boolean moveRight = true;
        boolean newCellLeftFlag = false;
        TMTransition transition;

        int c = 0;

        while(!currState.getName().equals(states.size()-1 + "")){

            transition = currState.getTransition(currCell); //read
            tape.set(iterator.nextIndex()-1, transition.writeSymb()); //write
            currState = transition.toState(); //move

            moveRight = transition.moveRight(); //tape move
            if(moveRight){
                if(!iterator.hasNext()){
                    tape.add(0);
                    iterator = tape.listIterator();
                }
                currCell = iterator.next();
            }
            else { //move left
                ListIterator<Integer> tmp = tape.listIterator(iterator.nextIndex());
                tmp.previous();
                if(!tmp.hasPrevious()){
                    LinkedList<Integer> tempList = new LinkedList<>();
                    tempList.add(0);
                    tempList.addAll(tape);
                    tape = tempList;
                    iterator = tempList.listIterator();
                    currCell = iterator.next();
                    newCellLeftFlag = true;
                }
                else {
                    currCell = iterator.previous();
                }

            }

            c++;
            System.out.println(c);
        }
        System.out.println("Final tape: " + tape + "\n" + "Number of transitions: " + c);
        return currState.getName().equals(states.size()-1 + "");
    }



}
