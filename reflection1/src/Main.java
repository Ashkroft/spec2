
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        Class<ArrayDeque> clasArrDeq = ArrayDeque.class;
        Class<ListDeque> clasLinqDeq = ListDeque.class;

        if (args.length == 0) {
            System.out.println("No arguments!");
            return;
        }

        Deque<Integer> deque = null;
        int maxDeq = 0;
        System.out.println(args[0]);
        if (args.length == 2) {
            maxDeq = Integer.parseInt(args[1]);
            Constructor<ArrayDeque> constructor = clasArrDeq.getConstructor(Integer.class);
            deque = constructor.newInstance(new Object[] { maxDeq });
        } else {
            deque = new ListDeque<>();
        }


        int n = 5;
        for (int i = 0; i < n; i++) {
            int random = (int) (Math.random() * 101);
            deque.addLast(random);
            System.out.print(random + " ");
        }
        System.out.println();
        int sum = 0;
        for (Integer integer : deque) {
            System.out.print(integer + " ");
            sum += integer;
        }

        System.out.println("\nSum is: " + sum);
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        deque.addFirst(10); deque.addFirst(100); deque.addFirst(1000);
        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }

        System.out.println();
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());


        try {
            Method method = deque.getClass().getMethod("size");
            Object size = method.invoke(deque);
            System.out.println("Size is: " + size);
        } catch (Exception e) {
            System.out.println("no size() method");
        }

    }

}