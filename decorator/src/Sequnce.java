import java.io.PrintStream;

interface Sequence<E> {
    void print(String delimiter, PrintStream ps);
    int size();
}