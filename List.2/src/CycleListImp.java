import java.util.*;

public class CycleListImp<E> implements CycleList<E> {

    private static class Node<E> {
        E info;
        Node<E> next;

        public Node(E info) {
            this.info = info;
        }
    }

    Node<E> head = null;
    int size = 0;

    public void add(E node) {
        Node<E> newNode = new Node<>(node);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            newNode.next = head.next;
            head.next = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void shift(int delta) {
        for (int i = 0; i < delta; i++) {
            head = head.next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CycleListIterator(head, size);
    }

    private class CycleListIterator<E> implements Iterator<E> {
        private int size, index;
        private Node<E> current;

        public CycleListIterator(Node<E> head, int size) {
            index = 0;
            this.size = size;
            current = head;
        }

        @Override
        public boolean hasNext() {
            return (head != null);
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            else {
                Node<E> temp = current;
                current = current.next;
              //  if (current == head) current = null;
                return temp.info;
            }
        }
    }
}
