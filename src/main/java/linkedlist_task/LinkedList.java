package linkedlist_task;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Part 1. Linked List
public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    // Part 1.1. Nested Node class
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // Part 1.1. Add to end
    public void add(T e) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    // Part 1.1. Add to specific index
    public void add(int index, T e) {
        checkPositionIndex(index);
        if (index == size) {
            add(e);
        } else {
            linkBefore(e, getNode(index));
        }
    }

    private void linkBefore(T e, Node<T> succ) {
        Node<T> pred = succ.prev;
        Node<T> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    // Part 1.1. Get by index
    public T get(int index) {
        checkElementIndex(index);
        return getNode(index).item;
    }

    // Part 1.1. Remove by index
    public T remove(int index) {
        checkElementIndex(index);
        return unlink(getNode(index));
    }

    // Part 1.1. Remove by object
    public boolean remove(T e) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (e == null ? x.item == null : e.equals(x.item)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    // Part 1.1. Remove all
    public void removeAll(T e) {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            if (e == null ? x.item == null : e.equals(x.item)) {
                unlink(x);
            }
            x = next;
        }
    }

    // Part 1.1. Add to beginning
    public void addFirst(T e) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    // Part 1.1. Get size
    public int getSize() {
        return size;
    }

    // Part 1.1. Get Node by index
    private Node<T> getNode(int index) {
        if (index < (size / 2)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private T unlink(Node<T> x) {
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // Part 1.1. toString()
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> x = first;
        while (x != null) {
            sb.append(x.item);
            x = x.next;
            if (x != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Part 1.1. Iterator
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T value = current.item;
            current = current.next;
            return value;
        }
    }
}
