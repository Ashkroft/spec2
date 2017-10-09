public class List<E extends Comparable<E>> {
    private static class Node<E> {
        E info;
        Node<E> next;

        public Node(Node<E> next, E info) {
            this.next = next;
            this.info = info;
        }
    }

    Node<E> head = null;
    int size = 0;

    public void add(E item) {
        head = new Node<>(head, item);
        size++;
    }

    public void swap(int i, int j) {
        if (i == j) {
            return;
        } else if (i < 0 || j < 0 || i > size || j > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        Node<E> current = head;
        Node<E> iPrevious = null;
        Node<E> iElem = null;
        Node<E> iNext = null;
        Node<E> jPrevious = null;
        Node<E> jElem = null;
        Node<E> jNext = null;
        int counter = 0;

        while (counter < j) {
            if (i == counter + 1) {
                iPrevious = current;
                iElem = current.next;
                iNext = current.next.next;
            }
            if (j == counter + 1) {
                jPrevious = current;
                jElem = current.next;
                jNext = current.next.next;
            }
            counter++;
            current = current.next;
        }

        if (i == 0 && j - i == 1) {
            iElem = head;
            head = jElem;
            jElem.next = iElem;
            iElem.next = jNext;
        }

        else if (i == 0) {
            iElem = head;
            iNext = iElem.next;
            head = jElem;
            iElem.next = jNext;
            jPrevious.next = iElem;
            jElem.next = iNext;
        }

        else if (j - i == 1) {
            iPrevious.next = jElem;
            iElem.next = jNext;
            jElem.next = iElem;
        }

        else {
            iPrevious.next = jElem;
            iElem.next = jNext;
            jPrevious.next = iElem;
            jElem.next = iNext;
        }
    }

    public void sort() {
        if (size < 2) {
            return;
        }
        Node<E> current = head;
        Node<E> previous = null;
        while (current != null) {
            if (previous == null || current.info.compareTo(previous.info) >= 0) {
                previous = current;
                current = current.next;
            } else {
                Node<E> q = head;
                if (current.info.compareTo(q.info) < 0) {
                    previous.next = current.next;
                    current.next = head;
                    head = current;
                    current = previous.next;
                } else {
                    while (q.next.info.compareTo(current.info) < 0) {
                        q = q.next;
                    }
                    previous.next = current.next;
                    current.next = q.next;
                    q.next = current;
                    current = previous.next;
                }
            }
        }
    }

    public void print() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> myList = new List<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);//6 5 4 3 2 1
        myList.print();
        myList.swap(1, 4);//6 2 4 3 5 1
        myList.print();
        myList.sort();//1 2 3 4 5 6
        myList.print();
    }
}
