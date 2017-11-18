import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        int n = 5 + (int) (Math.random() * 20);
        System.out.println("Elements: " + n);

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 20);
        }

        //before
        System.out.println(Arrays.toString(arr));


        if (args.length != 1) {
            System.out.println("Error with arguments");
            return;
        }
        Method method = null;
        Sort HelpMe = new Sort();
        try{
            method = HelpMe.getClass().getMethod(args[0], Integer[].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        method.invoke(new Sort(),(Object) arr);
        // After
        System.out.println(Arrays.toString(arr));

    }

}