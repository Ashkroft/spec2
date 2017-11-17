import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("No arguments!");
            return;
        }

        ClassLoader classLoader = Main.class.getClassLoader();
        Class<Deque> dequeClass = null;
        try {
            dequeClass = (Class<Deque>) classLoader.loadClass(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int maxDeq = 0;
        Deque<Integer> deque = null;
        if (dequeClass.getName().equals("ArrayDeque")) {
            Constructor constructor = null;
            maxDeq = Integer.parseInt(args[1]);
            try {
                constructor = dequeClass.getConstructor(Integer.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                deque = (Deque<Integer>) constructor.newInstance(new Object[] { maxDeq });
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        } else {

            try {
                deque = dequeClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
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