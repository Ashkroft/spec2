
import java.util.*;

public class Main {

    static <E> boolean listsEqual(CycleList<E> list1, CycleList<E> list2) {
        Iterator list1Iterator = list1.iterator();
        Iterator list2Iterator = list2.iterator();
        int size1 = 0;
        int size2 = 0;
        while (list1Iterator.hasNext()) {
            size1++;
            list1Iterator.next();
        }
        while (list2Iterator.hasNext()) {
            size2++;
            list2Iterator.next();
        }
        if (size1 != size2) {
            return false;
        } else {
            for (int i = 0; i < size1; i++) {
                list1Iterator = list1.iterator();
                list2Iterator = list2.iterator();
                boolean equality = true;
                while (equality == true && list1Iterator.hasNext()) {
                    if (!list2Iterator.next().equals(list1Iterator.next())) {
                        equality = false;
                    }
                }
                if (equality) {
                    return true;
                }
                list2.shift(1);
            }
            return false;
        }
    }

    public static void print(CycleListImp myList) {
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CycleListImp<Integer> myList1 = new CycleListImp<>();
        CycleListImp<Integer> myList2 = new CycleListImp<>();
        System.out.print("Not empty? ");
        System.out.println(myList1.iterator().hasNext()); //false
        myList1.add(3);
        myList1.add(4);
        myList1.add(5);
        System.out.println(myList1.iterator().next()); //5
        myList1.add(1);
        myList1.add(2);
        System.out.print("myList1: ");
        print(myList1); // 2 3 4 5 1
        System.out.print("Not empty? ");
        System.out.println(myList1.iterator().hasNext()); //true
        myList2.add(1);
        myList2.add(2);
        myList2.add(3);
        myList2.add(4);
        myList2.add(5);
        System.out.print("myList2: ");
        print(myList2); // 5 1 2 3 4
        System.out.print("Equal? ");
        System.out.println(listsEqual(myList1, myList2)); //true
        myList1.shift(4);
        System.out.print("myList1: ");
        print(myList1); //1 2 3 4 5
        System.out.print("myList2: ");
        print(myList2); //2 3 4 5 1
        System.out.print("Equal? ");
        System.out.println(listsEqual(myList1, myList2)); //true
        CycleListImp<Integer> myList01 = new CycleListImp<>();
        CycleListImp<Integer> myList02 = new CycleListImp<>();
        myList01.add(4);
        myList01.add(3);
        myList01.add(2);
        myList01.add(1);
        myList01.add(5);
        System.out.print("myList1: ");
        print(myList01); //5 4 3 2 1
        myList02.add(2);
        myList02.add(3);
        myList02.add(4);
        myList02.add(5);
        myList02.add(1);
        System.out.print("myList2: ");
        print(myList02); //1 2 3 4 5
        System.out.print("Equal? ");
        System.out.println(listsEqual(myList01, myList02)); //false
    }
}