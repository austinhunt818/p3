package tm;

/**
 * @author Austin Hunt
 * The TMTransition class represents a transition in a Turing Machine.
 *
 * @param onSymb   the symbol on which the transition occurs
 * @param toState  the state to transition to
 * @param writeSymb the symbol to write on the tape
 * @param moveRight true if the head moves right, false if it moves left
 */
public record TMTransition(int onSymb, TMState toState, int writeSymb, boolean moveRight) {
    /**
     * Returns a string representation of the TMTransition.
     *
     * @return a string representation of the TMTransition
     */
    @Override
    public String toString() {
        return "TMTransition{" +
                "onSymb=" + onSymb +
                ", toState=" + toState +
                ", writeSymb=" + writeSymb +
                ", moveRight=" + moveRight +
                '}';
    }
}