package linkedlist_task;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        System.out.println("Adding elements...");
        list.add("A");
        list.add("B");
        list.add("C");
        list.addFirst("Start");
        list.add(2, "Middle");
        System.out.println("List: " + list);

        System.out.println("Get element at index 2: " + list.get(2));

        list.remove("Middle");
        System.out.println("After removing 'Middle': " + list);

        list.add("C");
        list.add("C");
        System.out.println("After adding 'C' twice: " + list);

        list.removeAll("C");
        System.out.println("After removeAll 'C': " + list);

        list.remove(0);
        System.out.println("After remove index 0: " + list);

        System.out.println("Final size: " + list.getSize());

        System.out.println("Iterating:");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
