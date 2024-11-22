package tm;

import java.util.HashMap;

public class TMState extends State{
    private HashMap<Integer, TMTransition> transitions = new HashMap<>();

    public TMState(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public TMTransition getTransition(int symb){
        return transitions.get(symb);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void addTransition(int onSymb, int writeSymb, boolean right, TMState toState){
        transitions.put(onSymb, new TMTransition(onSymb, toState, writeSymb, right));
    }

}
