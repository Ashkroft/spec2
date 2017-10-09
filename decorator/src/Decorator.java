import java.io.PrintStream;

abstract public class Decorator<E> implements Sequence<E> {
    protected Sequence array;

    public Decorator(Sequence array) {
        this.array = array;
    }

    public int size() {
        return array.size();
    }

    public void print(String delimiter, PrintStream ps) {
        array.print(delimiter, ps);
    }
}
