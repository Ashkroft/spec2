import java.io.PrintStream;

public class CounterBracketsDecorator<E> extends Decorator<E> {
String summary;
    public CounterBracketsDecorator(Sequence array, String summary) {
        super(array);
        this.summary=summary;
    }

    public void print(String delimiter, PrintStream ps) {
        array.print(delimiter, ps);
        ps.print(summary + size());
        ps.println();
    }
}
