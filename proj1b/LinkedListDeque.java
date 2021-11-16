public class LinkedListDeque<T> implements Deque<T> {
    private class Node {         // define the internal node of the linked list.
        private Node prev;
        private T item;
        private Node next;

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private int size;    // Used to save the length of the Deque.
    private Node sentinel;

    public LinkedListDeque() {
        this.sentinel = new Node(null, (T) new Object(), null);
        this.sentinel.prev = sentinel;
        this.sentinel.next = sentinel;
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (Node i = sentinel.next; i != sentinel; i = i.next) {
            if (i.next == sentinel) {
                System.out.println(i.item);
                break;
            }
            System.out.print(i.item + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T target = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;

        return target;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T target = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;

        return target;
    }

    @Override
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        Node pointer = sentinel.next;   // define a pointer.
        while (index > 0) {
            pointer = pointer.next;
            index--;
        }

        return pointer.item;
    }

    public T getRecursive(int index) {
        if (size < index) {
            return null;
        }

        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(Node node, int i) {
        if (i == 0) {
            return node.item;
        }

        return getRecursive(node.next, i - 1);
    }
}
