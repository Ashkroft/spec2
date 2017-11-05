import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
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

        switch (args[0]) {
            case "insertionSort":
                Sort.bubbleSort(arr);
                break;
            case "mergeSort":
                Sort.insertSort(arr);
                break;
            case "quickSort":
                Sort.countingSort(arr);
                break;

            default:
                System.out.println("Error in method's name");
        }

        // After
        System.out.println(Arrays.toString(arr));

    }

}

