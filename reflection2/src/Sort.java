public class Sort {


    public static void bubbleSort(Integer[] elements) {
        boolean flag = false;
        do {
            flag = false;
            for (int i = 0; i < elements.length - 1; i++) {
                if (elements[i] > elements[i + 1]) {
                    int tmp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = tmp;
                    flag = true;
                }
            }
        } while (flag);
    }

    public static void insertSort(Integer[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int value = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j] > value) {
                elements[j + 1] = elements[j];
                j = j - 1;
            }
            elements[j + 1] = value;
        }
    }

    public static void countingSort(Integer[] elements) {
        int min = 0;
        int max = 20;

        int[] count = new int[max - min + 1];
        for (int number : elements) {
            count[number - min]++;
        }

        for (int i = min, j = 0; i <= max; i++) {
            while (count[i - min] > 0) {
                elements[j] = i;
                j++;
                count[i - min]--;
            }
        }
    }
}
