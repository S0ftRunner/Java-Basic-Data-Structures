import java.util.Iterator;

public class CarLinkedList<T> implements CarList<T>, CarQueue<T> {


    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    @Override
    public boolean add(T element) {
        if (size == 0) {
            first = new Node(null, element, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, element, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(element);
        }


        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, element, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T element) {
       int index = findElement(element);
       if (index != - 1) {
           return removeAt(index);
       }
       return false;
    }

    @Override
    public boolean contains(T element) {
        return findElement(element) != - 1;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private class Node {
        private Node previous;
        private T value;
        private Node next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private int findElement(T element) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T element = node.value;
                node = node.next;
                return element;
            }
        };
    }


    @Override
    public T peek() {
       return size > 0 ? get(0) : null;
    }

    @Override
    public T poll() {
        T element = get(0);
        removeAt(0);
        return element;
    }
}
