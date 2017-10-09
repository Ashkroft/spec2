import java.io.PrintStream;

public class TitleBracketsDecorator<E> extends Decorator<E> {
    String title;

    public TitleBracketsDecorator(String title, Sequence array) {
        super(array);
        this.title=title;
    }

    public void print(String delimiter, PrintStream ps) {
        ps.print(title);
        array.print(delimiter, ps);
    }
}
