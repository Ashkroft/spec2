import java.io.PrintStream;

public class BracketsDecorator<E> extends Decorator<E> {
    private String left, right;

    public BracketsDecorator(Sequence array, String left, String right) {
        super(array);
        this.left = left;
        this.right = right;

    }

    public void print(String delimiter, PrintStream ps) {
        ps.print(left);
        array.print(delimiter, ps);
        ps.println(right);
    }
}
