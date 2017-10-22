import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    Object[] elements;
    int head = -1;
    int tail = -1;
    int mSize, curSize = 0;

    public ArrayDeque(Integer maxDecSize) {
        elements = new Object[maxDecSize];
        mSize = maxDecSize;
    }

    @Override
    public void addFirst(E elem) {
        if (curSize == mSize) {
            System.out.println("Overflow");
            return;
        }

        if (curSize == 0) {
            head = 0;
            tail = 0;
        } else {
            if (head == 0)
                head = mSize - 1;
            else
                head--;
        }
        elements[head] = elem;
        curSize++;
    }

    @Override
    public E first() {
        return (E) elements[head];
    }


    @Override
    public E removeFirst() {
        if (curSize == 0) {
            System.out.println("Dequeue is empty");
            return null;
        }

        E ans = first();

        if (head == mSize - 1)
            head = 0;
        else
            head++;
        curSize--;
        return ans;
    }

    @Override
    public void addLast(E elem) {
        if (curSize == mSize) {
            System.out.println(" Overflow ");
            return;
        }
        if (curSize == 0) {
            head = 0;
            tail = 0;
        } else if (tail == mSize - 1)
            tail = 0;
        else
            tail++;
        elements[tail] = elem;
        curSize++;

    }

    @Override
    public E last() {
        return (E) elements[tail];
    }

    @Override
    public E removeLast() {
        if (curSize == 0) {
            System.out.println("Dequeue is empty\n");
            return null;
        }
        E ans = last();
        if (tail == 0)
            tail = mSize - 1;
        else tail--;
        curSize--;
        return ans;
    }

    public int size(){
        return curSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int currElem = head - 1;

            @Override
            public boolean hasNext() {
                return (currElem != tail);
            }

            @Override
            public E next() {
                if (currElem == mSize - 1)
                    currElem = 0;
                else currElem++;
                return (E)elements[currElem];
            }
        };
    }
}