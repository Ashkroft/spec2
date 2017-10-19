

public class Main {
    public static void main(String[] args) {
        Sequence<Integer> array = new Printer(1, 2, 3, 4, 5);
        Sequence first = new BracketsDecorator(array, "[", "]");
        first.print(", ", System.out);
        Sequence second = new CounterBracketsDecorator(array, " total number is ");
        second.print(", ", System.out);
        Sequence third = new TitleBracketsDecorator("Elements ", new BracketsDecorator(array, "{", "}"));
        third.print(", ", System.out);
    }
}

