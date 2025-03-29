package queue_task;

import linkedlist_task.LinkedList;

// Part 3. Queue (FIFO)
public class Queue<T> extends LinkedList<T> {

    // Adds element to the end of the queue
    public void enqueue(T item) {
        add(item); // додаємо в кінець
    }

    // Removes and returns the element at the front of the queue
    public T dequeue() {
        if (getSize() == 0) return null;
        return remove(0); // take from start
    }
}
