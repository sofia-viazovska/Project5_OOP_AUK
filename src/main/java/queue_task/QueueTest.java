package queue_task;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        System.out.println("Enqueuing elements...");
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("cherry");
        System.out.println("Queue after enqueue: " + queue);

        System.out.println("Dequeuing elements...");
        System.out.println("Dequeue: " + queue.dequeue()); // apple
        System.out.println("Dequeue: " + queue.dequeue()); // banana
        System.out.println("Queue after dequeue: " + queue);

        System.out.println("Enqueuing more...");
        queue.enqueue("date");
        System.out.println("Final queue: " + queue);
    }
}

