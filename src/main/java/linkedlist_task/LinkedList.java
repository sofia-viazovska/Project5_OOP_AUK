package linkedlist_task;

import java.util.Iterator;
import java.util.NoSuchElementException;

// A generic doubly linked list implementation that supports basic operations such as adding, removing,
// retrieving elements by index, and iteration through the elements.
//
// Key Properties:
// - Doubly linked: each node holds references to both the previous and next nodes.
// - Allows adding/removing from both ends and at specific positions.
// - Supports iteration using the enhanced for-each loop.

public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;  // Reference to the first node (head) of the list
    private Node<T> last;   // Reference to the last node (tail) of the list
    private int size = 0;   // Tracks the number of elements in the list

    // Inner class representing a node in the linked list.
    private static class Node<T> {
        T item;          // The data held by the node
        Node<T> next;    // Reference to the next node
        Node<T> prev;    // Reference to the previous node

        Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    // Adds a new element at the end of the list. O(1) operation.
    public void add(T e) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            // If the list was empty, new node becomes both head and tail
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    // Adds an element at a specified index in the list. O(n) in the worst case.
    public void add(int index, T e) {
        checkPositionIndex(index);
        if (index == size) {
            add(e); // Adding to the end
        } else {
            linkBefore(e, getNode(index)); // Insert before the node currently at index
        }
    }

    // Internal helper to insert an element before a given successor node.
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

    // Retrieves the element at a given index. O(n) time.
    public T get(int index) {
        checkElementIndex(index);
        return getNode(index).item;
    }

    // Removes and returns the element at a given index. O(n) time.
    public T remove(int index) {
        checkElementIndex(index);
        return unlink(getNode(index));
    }

    // Removes the first occurrence of a specific element from the list. O(n) time.
    public boolean remove(T e) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (e == null ? x.item == null : e.equals(x.item)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    // Removes all occurrences of a given element from the list. O(n) time.
    public void removeAll(T e) {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            if (e == null ? x.item == null : e.equals(x.item)) {
                unlink(x);
            }
            x = next;
        }
    }

    // Adds a new element to the beginning of the list. O(1) time.
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

    // Returns the current number of elements in the list.
    public int getSize() {
        return size;
    }

    // Helper method to retrieve the node at a given index.
    // Uses a bidirectional search: starts from head if index is in first half,
    // or from tail if index is in second half. O(n) in worst case.
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

    // Internal helper to unlink (remove) a node from the list and return its item.
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

        x.item = null;  // Help GC
        size--;
        return element;
    }

    // Checks if an index is a valid element index (0 to size-1).
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    // Checks if an index is a valid position for inserting (0 to size).
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // Throws if the element index is out of bounds.
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // Throws if the position index is out of bounds.
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // Provides a string representation of the list contents.
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

    // Returns an iterator to enable use in enhanced for-loops.
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // Internal iterator class for traversing the list from front to back.
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


//1. The time complexity of adding an element at the end of the list is **O(1)**. This is because the `add(T e)` method directly links the new node to the end of the list without needing to traverse the list.
//
//2. The time complexity of adding an element at the `i` position of the list with the method `add(int i, T e)` is **O(n)**. This is because the method needs to traverse the list to find the `i`-th position, which takes O(n) time, and then it performs the insertion, which is O(1).
//
//        3. The time complexity of traversing the list using the snippet:
//   for(int i=0; i<list.getSize(); i++ ){
//        System.out.println(list.get(i));
//        }
//        is O(n^2). This is because each call to `list.get(i)` takes O(n) time to traverse the list to the `i`-th position, and this is done for each of the `n` elements in the list, resulting in O(n) * O(n) = O(n^2) time complexity.
