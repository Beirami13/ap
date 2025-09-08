package ap.exercises.FinalExam;

public class Pair<T, U> {
    private final T key;
    private final U value;

    public Pair(T first, U second) {
        this.key = first;
        this.value = second;
    }

    public T getKey() {
        return key;
    }
    public U getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
