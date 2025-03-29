package stack_task;

import linkedlist_task.LinkedList;

// Part 2. Stack (LIFO)
public class Stack<T> extends LinkedList<T> {

    // Adds element to the top of the stack
    public void push(T item) {
        add(item); // add to the end
    }

    // Removes and returns the top element of the stack
    public T pop() {
        if (getSize() == 0) return null;
        return remove(getSize() - 1); // знімаємо з кінця
    }
}
