import java.io.PrintStream;

public class Printer<E> implements Sequence<Integer> {
    private Integer[] array;

    public Printer(Integer... array) {
        this.array = array;
    }

    public int size() {
        return array.length;
    }

    public void print(String delimiter, PrintStream ps) {
        for (int i = 0; i < size(); i++) {
            if (i < size() - 1) ps.print(array[i] + delimiter);
            else ps.print(array[i]);
        }
    }
}
