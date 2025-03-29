package stack_task;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("Pushing elements...");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushes: " + stack);

        System.out.println("Popping elements...");
        System.out.println("Pop: " + stack.pop()); // 30
        System.out.println("Pop: " + stack.pop()); // 20
        System.out.println("Stack after pops: " + stack);

        System.out.println("Pushing more...");
        stack.push(40);
        System.out.println("Final stack: " + stack);
    }
}
