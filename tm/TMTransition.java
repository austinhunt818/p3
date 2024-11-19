package tm;

public record TMTransition(int onSymb, TMState toState, int writeSymb, boolean moveRight) {
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
